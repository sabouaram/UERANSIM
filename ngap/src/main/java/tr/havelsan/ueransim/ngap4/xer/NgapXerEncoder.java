/*
 * MIT License
 *
 * Copyright (c) 2020 ALİ GÜNGÖR
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 * @author Ali Güngör (aligng1620@gmail.com)
 */

package tr.havelsan.ueransim.ngap4.xer;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import tr.havelsan.ueransim.ngap4.core.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class NgapXerEncoder {

    public static String encode(NgapValue value) {
        var factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
        var document = builder.newDocument();

        List<Node> nodes;
        try {
            nodes = encodeIe(document, value, true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        for (var item : nodes) {
            document.appendChild(item);
        }

        var tf = TransformerFactory.newInstance();
        Transformer transformer;
        try {
            transformer = tf.newTransformer();
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        }
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        var writer = new StringWriter();
        try {
            transformer.transform(new DOMSource(document), new StreamResult(writer));
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
        return writer.getBuffer().toString().replaceAll("[\n\r]", "");
    }

    private static List<Node> encodeIe(Document document, Object value, boolean isRoot) throws Exception {
        List<Node> list = new ArrayList<>();

        if (value instanceof NgapBitString) {
            if (isRoot) {
                var root = document.createElement(((NgapBitString) value).getXmlTagName());
                root.appendChild(document.createTextNode(((NgapBitString) value).value.toBinaryString(false)));
                list.add(root);
            } else {
                list.add(document.createTextNode(((NgapBitString) value).value.toBinaryString(false)));
            }
            return list;
        }

        if (value instanceof NgapOctetString) {
            if (isRoot) {
                var root = document.createElement(((NgapOctetString) value).getXmlTagName());
                root.appendChild(document.createTextNode(((NgapOctetString) value).value.toHexString(false)));
                list.add(root);
            } else {
                list.add(document.createTextNode(((NgapOctetString) value).value.toHexString(false)));
            }
            return list;
        }

        if (value instanceof NgapPrintableString) {
            if (isRoot) {
                var root = document.createElement(((NgapPrintableString) value).getXmlTagName());
                root.appendChild(document.createTextNode(((NgapPrintableString) value).value));
                list.add(root);
            } else {
                list.add(document.createTextNode(((NgapPrintableString) value).value));
            }
            return list;
        }

        if (value instanceof NgapInteger) {
            if (isRoot) {
                var root = document.createElement(((NgapInteger) value).getXmlTagName());
                root.appendChild(document.createTextNode(Long.toString(((NgapInteger) value).value)));
                list.add(root);
            } else {
                list.add(document.createTextNode(Long.toString(((NgapInteger) value).value)));
            }
            return list;
        }

        if (value instanceof NgapEnumerated) {
            if (isRoot) {
                var root = document.createElement(((NgapEnumerated) value).getXmlTagName());
                root.appendChild(document.createElement(((NgapEnumerated) value).sValue));
                list.add(root);
            } else {
                list.add(document.createElement(((NgapEnumerated) value).sValue));
            }
            return list;
        }

        if (value instanceof NgapChoice) {
            var choice = (NgapChoice) value;
            var type = choice.getClass();

            var identifiers = choice.getMemberIdentifiers();

            int j = -1;
            Object object = null;

            for (int i = 0; i < identifiers.length; i++) {
                var field = type.getDeclaredField(identifiers[i]);
                var obj = field.get(choice);
                if (obj != null) {
                    if (j == -1) {
                        j = i;
                        object = obj;
                    } else {
                        throw new RuntimeException("multiple non-null fields in choice value");
                    }
                }
            }

            var element = document.createElement(choice.getMemberNames()[j]);
            var node = encodeIe(document, object, false);

            for (var item : node) {
                element.appendChild(item);
            }

            if (isRoot) {
                var root = document.createElement(choice.getXmlTagName());
                root.appendChild(element);
                list.add(root);
            } else {
                list.add(element);
            }

            return list;
        }

        if (value instanceof NgapSequence) {
            var sequence = (NgapSequence) value;
            var type = sequence.getClass();

            var identifiers = sequence.getMemberIdentifiers();
            var names = sequence.getMemberNames();

            var root = document.createElement(sequence.getXmlTagName());

            for (int i = 0; i < identifiers.length; i++) {
                var field = type.getDeclaredField(identifiers[i]);
                var obj = field.get(sequence);
                if (obj != null) {
                    var element = document.createElement(names[i]);
                    for (var item : encodeIe(document, obj, false)) {
                        element.appendChild(item);
                    }

                    if (isRoot) {
                        root.appendChild(element);
                    } else {
                        list.add(element);
                    }
                }
            }

            if (isRoot) {
                list.add(root);
            }

            return list;
        }

        if (value instanceof NgapSequenceOf<?>) {
            var sequenceOf = (NgapSequenceOf<?>) value;
            var itemType = sequenceOf.getItemType();
            var tagName = itemType.getConstructor().newInstance().getXmlTagName();

            var root = document.createElement(sequenceOf.getXmlTagName());

            for (var item : sequenceOf.list) {
                var element = document.createElement(tagName);
                for (var inner : encodeIe(document, item, false)) {
                    element.appendChild(inner);
                }

                if (isRoot) {
                    root.appendChild(element);
                } else {
                    list.add(element);
                }
            }

            if (isRoot) {
                list.add(root);
            }
            return list;
        }

        throw new RuntimeException("unrecognized type in NgapXerEncoder.encodeIe");
    }
}

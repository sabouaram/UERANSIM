package tr.havelsan.ueransim.ngap0.ies.sequence_ofs;

import tr.havelsan.ueransim.ngap0.core.*;
import tr.havelsan.ueransim.ngap0.pdu.*;
import tr.havelsan.ueransim.utils.bits.*;
import tr.havelsan.ueransim.utils.octets.*;
import tr.havelsan.ueransim.ngap0.ies.bit_strings.*;
import tr.havelsan.ueransim.ngap0.ies.octet_strings.*;
import tr.havelsan.ueransim.ngap0.ies.printable_strings.*;
import tr.havelsan.ueransim.ngap0.ies.sequences.*;
import tr.havelsan.ueransim.ngap0.ies.sequence_ofs.*;
import tr.havelsan.ueransim.ngap0.ies.choices.*;
import tr.havelsan.ueransim.ngap0.ies.integers.*;
import tr.havelsan.ueransim.ngap0.ies.enumerations.*;

import java.util.List;

public class NGAP_CriticalityDiagnostics_IE_List extends NGAP_SequenceOf<NGAP_CriticalityDiagnostics_IE_Item> {

    public NGAP_CriticalityDiagnostics_IE_List() {
        super();
    }

    public NGAP_CriticalityDiagnostics_IE_List(List<NGAP_CriticalityDiagnostics_IE_Item> value) {
        super(value);
    }

    @Override
    public String getAsnName() {
        return "CriticalityDiagnostics-IE-List";
    }

    @Override
    public String getXmlTagName() {
        return "CriticalityDiagnostics-IE-List";
    }

    @Override
    public Class<NGAP_CriticalityDiagnostics_IE_Item> getItemType() {
        return NGAP_CriticalityDiagnostics_IE_Item.class;
    }
}

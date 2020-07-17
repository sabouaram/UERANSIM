package tr.havelsan.ueransim.ngap4.ies.enumerations;

import tr.havelsan.ueransim.ngap4.core.*;
import tr.havelsan.ueransim.utils.bits.*;
import tr.havelsan.ueransim.utils.octets.*;
import tr.havelsan.ueransim.ngap4.ies.bit_strings.*;
import tr.havelsan.ueransim.ngap4.ies.octet_strings.*;
import tr.havelsan.ueransim.ngap4.ies.printable_strings.*;
import tr.havelsan.ueransim.ngap4.ies.sequences.*;
import tr.havelsan.ueransim.ngap4.ies.sequence_ofs.*;
import tr.havelsan.ueransim.ngap4.ies.choices.*;
import tr.havelsan.ueransim.ngap4.ies.integers.*;
import tr.havelsan.ueransim.ngap4.ies.enumerations.*;

import java.util.List;

public class NGAP_CauseTransport extends NgapEnumerated {

    public static final NGAP_CauseTransport TRANSPORT_RESOURCE_UNAVAILABLE = new NGAP_CauseTransport("transport-resource-unavailable");
    public static final NGAP_CauseTransport UNSPECIFIED = new NGAP_CauseTransport("unspecified");

    public NGAP_CauseTransport(String sValue) {
        super(sValue);
    }

    @Override
    public String getAsnName() {
        return "CauseTransport";
    }

    @Override
    public String getXmlTagName() {
        return "CauseTransport";
    }
}

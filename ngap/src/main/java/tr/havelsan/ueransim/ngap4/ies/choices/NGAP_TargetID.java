package tr.havelsan.ueransim.ngap4.ies.choices;

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

public class NGAP_TargetID extends NgapChoice {

    public NGAP_TargetRANNodeID targetRANNodeID;
    public NGAP_TargeteNB_ID targeteNB_ID;

    @Override
    public String getAsnName() {
        return "TargetID";
    }

    @Override
    public String getXmlTagName() {
        return "TargetID";
    }

    @Override
    public String[] getMemberNames() {
        return new String[]{"targetRANNodeID", "targeteNB-ID"};
    }

    @Override
    public String[] getMemberIdentifiers() {
        return new String[]{"targetRANNodeID", "targeteNB_ID"};
    }
}

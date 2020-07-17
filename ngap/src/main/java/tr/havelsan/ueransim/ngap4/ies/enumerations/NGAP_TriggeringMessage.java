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

public class NGAP_TriggeringMessage extends NgapEnumerated {

    public static final NGAP_TriggeringMessage INITIATING_MESSAGE = new NGAP_TriggeringMessage("initiating-message");
    public static final NGAP_TriggeringMessage SUCCESSFUL_OUTCOME = new NGAP_TriggeringMessage("successful-outcome");
    public static final NGAP_TriggeringMessage UNSUCCESSFULL_OUTCOME = new NGAP_TriggeringMessage("unsuccessfull-outcome");

    public NGAP_TriggeringMessage(String sValue) {
        super(sValue);
    }

    @Override
    public String getAsnName() {
        return "TriggeringMessage";
    }

    @Override
    public String getXmlTagName() {
        return "TriggeringMessage";
    }
}

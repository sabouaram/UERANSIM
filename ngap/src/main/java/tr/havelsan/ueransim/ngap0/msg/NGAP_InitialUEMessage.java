package tr.havelsan.ueransim.ngap0.msg;

import tr.havelsan.ueransim.ngap0.pdu.*;
import tr.havelsan.ueransim.ngap0.core.*;
import tr.havelsan.ueransim.ngap0.*;
import tr.havelsan.ueransim.ngap0.ies.sequence_ofs.*;
import tr.havelsan.ueransim.ngap0.ies.sequences.*;
import tr.havelsan.ueransim.ngap0.ies.choices.*;
import tr.havelsan.ueransim.ngap0.ies.printable_strings.*;
import tr.havelsan.ueransim.ngap0.ies.bit_strings.*;
import tr.havelsan.ueransim.ngap0.ies.octet_strings.*;
import tr.havelsan.ueransim.ngap0.ies.integers.*;
import tr.havelsan.ueransim.ngap0.ies.enumerations.*;

public class NGAP_InitialUEMessage extends NGAP_BaseMessage {

    public NGAP_InitialUEMessage() {

    }

    @Override
    public NgapMessageType getMessageType() {
        return NgapMessageType.InitialUEMessage;
    }

    @Override
    public NgapProtocolIeType getProtocolIeType() {
        return NgapProtocolIeType.forMessage("InitialUEMessage");
    }

    @Override
    public int getCriticality() {
        return 1;
    }

    @Override
    public int getProcedureCode() {
        return 15;
    }

    @Override
    public int getPduType() {
        return 0;
    }

    @Override
    public int[] getIeId() {
        return new int[] { 85, 38, 121, 90, 26, 3, 112, 0, 171 };
    }

    @Override
    public int[] getIeCriticality() {
        return new int[] { 0, 0, 0, 1, 0, 1, 1, 0, 1 };
    }

    @Override
    public Class<? extends NGAP_Value>[] getIeTypes() {
        return new Class[] { NGAP_RAN_UE_NGAP_ID.class, NGAP_NAS_PDU.class, NGAP_UserLocationInformation.class, NGAP_RRCEstablishmentCause.class, NGAP_FiveG_S_TMSI.class, NGAP_AMFSetID.class, NGAP_UEContextRequest.class, NGAP_AllowedNSSAI.class, NGAP_SourceToTarget_AMFInformationReroute.class };
    }

    @Override
    public int[] getIePresence() {
        return new int[] { 2, 2, 2, 2, 0, 0, 0, 0, 0 };
    }

    @Override
    public String[] getMemberIdentifiers() {
        return new String[] { "protocolIEs" };
    }

    @Override
    public String[] getMemberNames() {
        return new String[] { "protocolIEs" };
    }

    @Override
    public String getAsnName() {
        return "InitialUEMessage";
    }

    @Override
    public String getXmlTagName() {
        return "InitialUEMessage";
    }

}

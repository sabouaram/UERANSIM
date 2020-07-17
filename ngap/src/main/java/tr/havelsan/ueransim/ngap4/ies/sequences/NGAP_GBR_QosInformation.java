package tr.havelsan.ueransim.ngap4.ies.sequences;

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

public class NGAP_GBR_QosInformation extends NgapSequence {

    public NGAP_BitRate maximumFlowBitRateDL;
    public NGAP_BitRate maximumFlowBitRateUL;
    public NGAP_BitRate guaranteedFlowBitRateDL;
    public NGAP_BitRate guaranteedFlowBitRateUL;
    public NGAP_NotificationControl notificationControl;
    public NGAP_PacketLossRate maximumPacketLossRateDL;
    public NGAP_PacketLossRate maximumPacketLossRateUL;

    @Override
    public String getAsnName() {
        return "GBR-QosInformation";
    }

    @Override
    public String getXmlTagName() {
        return "GBR-QosInformation";
    }

    @Override
    public String[] getMemberNames() {
        return new String[]{"maximumFlowBitRateDL", "maximumFlowBitRateUL", "guaranteedFlowBitRateDL", "guaranteedFlowBitRateUL", "notificationControl", "maximumPacketLossRateDL", "maximumPacketLossRateUL"};
    }

    @Override
    public String[] getMemberIdentifiers() {
        return new String[]{"maximumFlowBitRateDL", "maximumFlowBitRateUL", "guaranteedFlowBitRateDL", "guaranteedFlowBitRateUL", "notificationControl", "maximumPacketLossRateDL", "maximumPacketLossRateUL"};
    }
}

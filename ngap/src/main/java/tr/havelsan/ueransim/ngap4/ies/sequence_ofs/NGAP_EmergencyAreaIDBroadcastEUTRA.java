package tr.havelsan.ueransim.ngap4.ies.sequence_ofs;

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

public class NGAP_EmergencyAreaIDBroadcastEUTRA extends NgapSequenceOf<NGAP_EmergencyAreaIDBroadcastEUTRA_Item> {

    public NGAP_EmergencyAreaIDBroadcastEUTRA() {
        super();
    }

    public NGAP_EmergencyAreaIDBroadcastEUTRA(List<NGAP_EmergencyAreaIDBroadcastEUTRA_Item> value) {
        super(value);
    }

    @Override
    public String getAsnName() {
        return "EmergencyAreaIDBroadcastEUTRA";
    }

    @Override
    public String getXmlTagName() {
        return "EmergencyAreaIDBroadcastEUTRA";
    }

    @Override
    public Class<NGAP_EmergencyAreaIDBroadcastEUTRA_Item> getItemType() {
        return NGAP_EmergencyAreaIDBroadcastEUTRA_Item.class;
    }
}

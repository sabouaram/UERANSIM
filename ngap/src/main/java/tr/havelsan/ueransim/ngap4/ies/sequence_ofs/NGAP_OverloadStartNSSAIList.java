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

public class NGAP_OverloadStartNSSAIList extends NgapSequenceOf<NGAP_OverloadStartNSSAIItem> {

    public NGAP_OverloadStartNSSAIList() {
        super();
    }

    public NGAP_OverloadStartNSSAIList(List<NGAP_OverloadStartNSSAIItem> value) {
        super(value);
    }

    @Override
    public String getAsnName() {
        return "OverloadStartNSSAIList";
    }

    @Override
    public String getXmlTagName() {
        return "OverloadStartNSSAIList";
    }

    @Override
    public Class<NGAP_OverloadStartNSSAIItem> getItemType() {
        return NGAP_OverloadStartNSSAIItem.class;
    }
}

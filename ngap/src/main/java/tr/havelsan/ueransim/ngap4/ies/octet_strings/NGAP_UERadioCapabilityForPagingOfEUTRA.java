package tr.havelsan.ueransim.ngap4.ies.octet_strings;

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

public class NGAP_UERadioCapabilityForPagingOfEUTRA extends NgapOctetString {

    public NGAP_UERadioCapabilityForPagingOfEUTRA(OctetString value) {
        super(value);
    }

    public NGAP_UERadioCapabilityForPagingOfEUTRA(BitString value) {
        super(value);
    }

    public NGAP_UERadioCapabilityForPagingOfEUTRA(Octet[] octets) {
        super(octets);
    }

    public NGAP_UERadioCapabilityForPagingOfEUTRA(int[] octetInts) {
        super(octetInts);
    }

    public NGAP_UERadioCapabilityForPagingOfEUTRA(byte[] octetBytes) {
        super(octetBytes);
    }

    public NGAP_UERadioCapabilityForPagingOfEUTRA(String hex) {
        super(hex);
    }

    @Override
    public String getAsnName() {
        return "UERadioCapabilityForPagingOfEUTRA";
    }

    @Override
    public String getXmlTagName() {
        return "UERadioCapabilityForPagingOfEUTRA";
    }
}

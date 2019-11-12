package com.runsim.backend.nas.core.ies;

import com.runsim.backend.utils.OctetInputStream;
import com.runsim.backend.utils.bits.Bit4;

/**
 * Information elements of format V or TV with value part consisting of 1/2 octet
 */
public abstract class InformationElement1 extends InformationElement {
    public abstract InformationElement1 decodeIE1(Bit4 value);

    @Override
    public final InformationElement decodeIE(OctetInputStream stream) {
        int octet = stream.readOctetI();
        int iei = octet >> 4 & 0xF;
        int value = octet & 0xF;
        return decodeIE1(new Bit4(value));
    }

    public abstract int encodeIE1();
}

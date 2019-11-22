package com.runsim.backend.utils.octets;

import com.runsim.backend.utils.bits.Bit;

/**
 * Represents 4-octet or 32-bit unsigned integer
 */
public final class Octet4 extends OctetN {

    public Octet4() {
        this(0);
    }

    public Octet4(long value) {
        super(value, 4);
    }

    public Octet4(Octet octet3, Octet octet2, Octet octet1, Octet octet0) {
        this(Integer.toUnsignedLong(octet0.intValue() | octet1.intValue() << 8 | octet2.intValue() << 16 | octet3.intValue() << 24));
    }

    @Override
    public final Octet4 setBit(int index, int bit) {
        return new Octet4(super.setBit(index, bit).longValue());
    }

    @Override
    public final Octet4 setBit(int index, Bit bit) {
        return new Octet4(super.setBit(index, bit).longValue());
    }

    @Override
    public final Octet4 setBitRange(int start, int end, long value) {
        return new Octet4(super.setBitRange(start, end, value).longValue());
    }
}

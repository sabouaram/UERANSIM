package com.runsim.backend.nas.impl.messages;

import com.runsim.backend.nas.core.messages.PlainNasMessage;
import com.runsim.backend.nas.impl.ies.IE5gMmCause;
import com.runsim.backend.nas.impl.ies.IEEapMessage;
import com.runsim.backend.nas.impl.ies.IEGprsTimer2;

public class RegistrationReject extends PlainNasMessage {

    public IE5gMmCause mmCause;
    public IEGprsTimer2 t3346value;
    public IEGprsTimer2 t3502value;
    public IEEapMessage eapMessage;

    @Override
    public void transcode(ITranscodeBuilder builder) {
        super.transcode(builder);

        builder.mandatoryIE("mmCause");
        builder.optionalIE(0x5F, "t3346value");
        builder.optionalIE(0x16, "t3502value");
        builder.optionalIE(0x78, "eapMessage");
    }
}
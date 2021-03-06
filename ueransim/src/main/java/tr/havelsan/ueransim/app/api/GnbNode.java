/*
 * MIT License
 *
 * Copyright (c) 2020 ALİ GÜNGÖR
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package tr.havelsan.ueransim.app.api;

import tr.havelsan.ueransim.app.api.gnb.app.GnbAppTask;
import tr.havelsan.ueransim.app.api.gnb.mr.MrTask;
import tr.havelsan.ueransim.app.api.gnb.ngap.NgapTask;
import tr.havelsan.ueransim.app.api.gnb.sctp.SctpTask;
import tr.havelsan.ueransim.app.itms.ItmsId;
import tr.havelsan.ueransim.app.structs.simctx.GnbSimContext;

public class GnbNode {

    public static void run(GnbSimContext ctx) {
        var itms = ctx.itms;

        var sctpTask = new SctpTask(itms, ItmsId.GNB_TASK_SCTP, ctx);
        var ngapTask = new NgapTask(itms, ItmsId.GNB_TASK_NGAP, ctx);
        var mrTask = new MrTask(itms, ItmsId.GNB_TASK_MR, ctx);
        var appTask = new GnbAppTask(itms, ItmsId.GNB_TASK_APP, ctx);

        itms.createTask(sctpTask);
        itms.createTask(ngapTask);
        itms.createTask(mrTask);
        itms.createTask(appTask);

        itms.startTask(sctpTask);
        itms.startTask(ngapTask);
        itms.startTask(mrTask);
        itms.startTask(appTask);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NFCtransmission;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import smartmuseumtable.Login;
import org.nfctools.examples.llcp.LlcpService;
import org.nfctools.examples.llcp.NDefListenerNuovo;
import org.nfctools.ndef.NdefListener;
import org.nfctools.ndef.Record;
import org.nfctools.utils.LoggingNdefListener;
import org.nfctools.utils.LoggingStatusListener;

public class NFCreading {

    public NFCreading() {
        try {
            Runtime rt = Runtime.getRuntime();
            Process proc;
            LlcpService nfc = new LlcpService(null, null);
            Thread t = new Thread(new Runnable() {

                @Override
                public void run() {
                    while (true) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                        }
                        if (NDefListenerNuovo.getIstance().hasToken()) {
                            String token = NDefListenerNuovo.getIstance().getRecord();
                        }
                    }
                }
            });
            t.start();
            nfc.run();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

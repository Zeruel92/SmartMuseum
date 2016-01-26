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
import javax.swing.JOptionPane;
import smartmuseumtable.Login;
import org.nfctools.examples.llcp.LlcpService;
import org.nfctools.examples.llcp.NDefListenerNuovo;
import org.nfctools.ndef.NdefListener;
import org.nfctools.ndef.Record;
import org.nfctools.utils.LoggingNdefListener;
import org.nfctools.utils.LoggingStatusListener;
import smartmuseumtable.Museo;
import smartmuseumtable.RestClient;
import smartmuseumtable.Utente;

public class NFCreading implements Runnable {
    private Login l;
    private Thread t;
    public NFCreading(Login l) {
        this.l=l;
        try {
            LlcpService nfc = new LlcpService(null, null);
            t = new Thread(new ThreadNFC());
            t.start();
            Thread t2=new Thread(this);
            t2.start();
            nfc.run();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
               Logger.getLogger(NFCreading.class.getName()).log(Level.SEVERE, null, ex);
            }
            if((Utente.getIstance().getId()!=-1)&&(this.l.isVisible())){
                this.t.stop();
                this.l.setVisible(false);
            }
            else if((Utente.getIstance().getId()==-1)&&(!this.l.isVisible())){
                this.l.setVisible(true);
                this.t=new Thread(new ThreadNFC());
                this.t.start();
                
            }
                
        }
    }
}

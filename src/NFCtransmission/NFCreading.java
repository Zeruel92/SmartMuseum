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
import org.nfctools.ndef.NdefListener;
import org.nfctools.ndef.Record;
import org.nfctools.utils.LoggingNdefListener;
import org.nfctools.utils.LoggingStatusListener;

public class NFCreading {

    public NFCreading() {
        try {
            Runtime rt = Runtime.getRuntime();
            //String[] commands = {"python","C:\\Users\\Claudia\\Desktop\\nfcpy-0.10.2\\examples\\beam.py","recv","print"};
            //String[] commands = {"java", "-cp", "C:\\Users\\Gabriele\\Desktop\\SmartMuseo\\nfctools-nesciu.jar", "org.nfctools.examples.llcp.LlcpService"};
            Process proc;
            LlcpService nfc=new LlcpService(null,null);
           nfc.run();
            
            //proc = rt.exec(commands);
  //          BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            
                //BufferedReader stdError = new BufferedReader(new 
            //InputStreamReader(proc.getErrorStream()));
                // read the output from the command
            // System.out.println("Here is the standard output of the command:\n");
            String s = null;
    /*        while (true) {
               while ((s = stdInput.readLine()) != null) {
                    //Thread.sleep(1000);   
                    if (s.contains("iot")) {
                        System.out.println(s);
                        proc.destroy();
                        stdInput.close();
                        Thread.sleep(1000);
                        proc = rt.exec(commands);
                        stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
                    }//fine if
                }

            }*/
                //Thread.sleep(1000);
            //proc.destroy();

// read any errors from the attempted command
/*System.out.println("Here is the standard error of the command (if any):\n");
             while ((s = stdError.readLine()) != null) {
             System.out.println(s);
             }*/
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

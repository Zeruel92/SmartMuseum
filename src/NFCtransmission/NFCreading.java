/* Questa classe ha il compito di estrapolare dall' ACR122U il token di 
 autenticazione e rimane in ascolto finche' è attiva la classe Login */

/*
 * @author Gabriele Tramonte
 * @author Cosimo Antonaci
 */
package NFCtransmission;

import java.util.logging.Level;
import java.util.logging.Logger;
import smartmuseumtable.Login;
import org.nfctools.examples.llcp.LlcpService;
import smartmuseumtable.Utente;

// Costruzione oggetti
public class NFCreading implements Runnable {

    private Login l;
    private Thread t;

    public NFCreading(Login l) {
        this.l = l;
        try {
            LlcpService nfc = new LlcpService(null, null);
            t = new Thread(new ThreadNFC());
            t.start();
            Thread t2 = new Thread(this);
            t2.start();
            nfc.run();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /* Thread che controlla le schermate di Login e Museo
     -Sel'utente è loggato disabilita il Login e l'ascolto dell'ACR122U
     -Altrimenti riabilita il Login e l'ascolto dell'ACR122 
     */

    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(NFCreading.class.getName()).log(Level.SEVERE, null, ex);
            }
            if ((Utente.getIstance().getId() != -1) && (this.l.isVisible())) {
                this.t.stop();
                this.l.setVisible(false);
            } else if ((Utente.getIstance().getId() == -1) && (!this.l.isVisible())) {
                this.l.setVisible(true);
                this.t = new Thread(new ThreadNFC());
                this.t.start();

            }

        }
    }
}

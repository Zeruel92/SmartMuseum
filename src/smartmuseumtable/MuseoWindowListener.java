package smartmuseumtable;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/*
 * @author Gabriele Tramonte
 * @author Cosimo Antonaci
 */
public class MuseoWindowListener implements WindowListener {

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        Utente.getIstance().logout();
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

}

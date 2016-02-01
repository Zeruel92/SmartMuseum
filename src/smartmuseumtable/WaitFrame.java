package smartmuseumtable;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * @author Gabriele Tramonte
 * @author Cosimo Antonaci
 */
public class WaitFrame extends JFrame{
    public WaitFrame(){
        super("Attendere...");
        JPanel p=new JPanel();
        this.add(p);
        JLabel l=new JLabel("Attendere recupero delle informazioni in corso....");
        p.add(l);
        pack();
    }
}

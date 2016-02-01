package smartmuseumtable;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TableListener implements ListSelectionListener {

    private Museo m;
    private JTable tab;

    public TableListener(Museo m, JTable tab) {
        this.m = m;
        this.tab = tab;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int selezione = Integer.parseInt(tab.getValueAt(tab.getSelectedRow(), 0).toString());
        RestClient httpGET = new RestClient("Opera", selezione);
        while (!httpGET.isStatus()) {
            //waiting for data
        }
        String tmp[] = httpGET.getOutput().split("\n");
        String descrizione = "";
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i].contains("Descrizione")) {
                descrizione = tmp[i].substring(tmp[i].indexOf(" ") + 1);
            }
        }
        JLabel l_descrizione = new JLabel(descrizione);
        this.m.getContentPane().add(l_descrizione, BorderLayout.WEST);
        try {
            Image image = Toolkit.getDefaultToolkit().createImage(new URL("http://52.17.122.110/opera_" + selezione + ".jpg"));
            Image newimg = image.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            JLabel immagineOpera = new JLabel();
            immagineOpera.setIcon(new ImageIcon(newimg));

            this.m.getContentPane().add(immagineOpera, BorderLayout.EAST);
        } catch (MalformedURLException ex) {
            Logger.getLogger(TableListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.m.revalidate();
    }

}

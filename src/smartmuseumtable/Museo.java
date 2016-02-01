package smartmuseumtable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.nfctools.examples.llcp.NDefListenerNuovo;

/*
 * @authors Cosimo Antonaci & Gabriele Tramonte
 */
public class Museo extends javax.swing.JFrame {

    private Vector<String> n_Opera;
    private Vector<String> nomeAutore;
    private Vector<String> cognomeAutore;
    private Vector<Integer> id_Opere;

    /**
     * Creates new form Museo
     */
    public Museo() {
        int id = Utente.getIstance().getId();
        RestClient rest = new RestClient("Preferenze", id);
        while (!rest.isStatus()) {

        }
        String restResult = rest.getOutput();

        n_Opera = new Vector<String>();
        nomeAutore = new Vector<String>();
        cognomeAutore = new Vector<String>();
        id_Opere = new Vector<Integer>();
        if (restResult.equals("No record")) {

        } else {
            String[] tmp = restResult.split("\n");
            for (int i = 0; i < tmp.length; i++) {
                if (tmp[i].contains("NomeOpera")) {
                    n_Opera.addElement(tmp[i].substring(tmp[i].indexOf(" ") + 1));
                } else if (tmp[i].contains("Nome")) {
                    nomeAutore.addElement(tmp[i].substring(tmp[i].indexOf(" ") + 1));
                } else if (tmp[i].contains("Cognome")) {
                    cognomeAutore.addElement(tmp[i].substring(tmp[i].indexOf(" ") + 1));
                } else {
                    id_Opere.addElement(Integer.parseInt(tmp[i].substring(tmp[i].indexOf(" ") + 1)));
                }

            }
        }
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();

        this.addWindowListener(new MuseoWindowListener());

           
        setTitle("Smart Museum");
        setPreferredSize(new java.awt.Dimension(1535, 1246));

        jButton1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton1.setText("Logout");
        jButton1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Utente.getIstance().logout();
                setVisible(false);
            }
        });
        //generazioe tabella
        Vector<String> colonne = new Vector<String>();
        colonne.addElement("Identificativo Opera");
        colonne.addElement("Nome Dell'Opera");
        colonne.addElement("Nome Autore");
        colonne.addElement("Cognome Autore");
        Vector<Vector> righe = new Vector<Vector>();
        if (n_Opera.size() == 0) {
            Vector<String> row = new Vector<String>();
            row.addElement("0");
            row.addElement("Non");
            row.addElement("ci sono");
            row.addElement("Preferenze al momento");
            righe.addElement(row);
        } else {
            for (int i = 0; i < n_Opera.size(); i++) {
                Vector<String> row = new Vector<String>();
                row.addElement(Integer.toString(id_Opere.elementAt(i)));
                row.addElement(n_Opera.elementAt(i));
                row.addElement(nomeAutore.elementAt(i));
                row.addElement(cognomeAutore.elementAt(i));
                righe.addElement(row);
            }
        }
        jTable1 = new JTable(righe, colonne);
        jTable1.getSelectionModel().addListSelectionListener(new TableListener(this,jTable1));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(24, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addContainerGap())
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 11, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Museo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Museo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Museo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Museo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Museo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    public static String token;
    // End of variables declaration                   
}

/* Questa classe ha il compito di effettuare un primo interfacciamento 
 dell'utente con la Smart Table, facendogli effettuare il download dell'app 
 (qualora non l'abbia già installata) oppure autenticarlo al sistema */
package smartmuseumtable;

import NFCtransmission.NFCreading;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @authors Cosimo Antonaci & Gabriele Tramonte
 */
public class Login extends javax.swing.JFrame {
    private JLabel jLabelToken;

    public Login() throws MalformedURLException {
        initComponents();
        // Inizializza l'immagine "freccetta rossa"
        Image img = Toolkit.getDefaultToolkit().createImage(new URL("http://52.17.122.110/pitr_red_arrows_set_5.png"));
        Image newimg = img.getScaledInstance(150, 300, Image.SCALE_SMOOTH);
        jLabelFreccia.setIcon(new ImageIcon(newimg));

        //Inizializza l'immagine per il QrCode dell'app        
        Image imgApp = Toolkit.getDefaultToolkit().createImage(new URL("http://52.17.122.110/App.jpg"));
        Image newimgApp = imgApp.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        jLabelApp.setIcon(new ImageIcon(newimgApp));
        int larghezza = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int altezza = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        setBounds(new java.awt.Rectangle(0, 0, larghezza, altezza));
        setResizable(false);
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        jLabelDownload = new javax.swing.JLabel();
        jLabelLoginSelection = new javax.swing.JLabel();
        jLabelFreccia = new javax.swing.JLabel();
        jLabelTap = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButtonSignIn = new javax.swing.JButton();
        jLabelApp = new javax.swing.JLabel();
        jLabelToken=new JLabel();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Benvenuti in uno Smart Museum");
        this.getContentPane().setLayout(new BorderLayout());
        jLabelDownload.setFont(new java.awt.Font("Arial", 0, 36));
        jLabelDownload.setText("Effettuare il download dell'app Smart Museum ");
        
        jLabelLoginSelection.setFont(new java.awt.Font("Arial", 0, 48));
        jLabelLoginSelection.setText("Selezionare la modalità di login preferita:\n");
        JPanel nord=new JPanel();
        nord.setLayout(new BorderLayout());
        nord.add(jLabelDownload,BorderLayout.WEST);
        nord.add(jLabelApp,BorderLayout.EAST);
        nord.add(jLabelLoginSelection,BorderLayout.SOUTH);
        
        jLabelTap.setFont(new java.awt.Font("Arial", 0, 48));
        jLabelTap.setText("Avvicinare lo smartphone");
        jLabelToken.setFont(new java.awt.Font("Arial",0,48));
        jLabelToken.setText("Inserire Token:");
        JPanel centro=new JPanel();
        centro.setLayout(new BorderLayout());
        JPanel c1=new JPanel();
        JPanel c2=new JPanel();
        c1.setLayout(new BorderLayout());
        c2.setLayout(new BorderLayout());
        centro.add(c1,BorderLayout.CENTER);
        centro.add(c2,BorderLayout.EAST);
        c1.add(jLabelTap,BorderLayout.NORTH);
        JPanel c3=new JPanel();
        c3.setLayout(null);
        c3.add(jPasswordField1);
        c3.add(jButtonSignIn);
        c1.add(jLabelFreccia,BorderLayout.CENTER);
        c2.add(jLabelToken,BorderLayout.NORTH);
        c2.add(c3,BorderLayout.CENTER);
        //c2.add(jButtonSignIn,BorderLayout.SOUTH);
        jPasswordField1.setFont(new java.awt.Font("Arial", 0, 18));
        jPasswordField1.setBounds(0, 0, 350, 30);
        jButtonSignIn.setFont(new java.awt.Font("Arial", 0, 24));
        jButtonSignIn.setBounds(75, 35, 150, 40);
        jButtonSignIn.setText("Sign In");
        jButtonSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        this.getContentPane().add(nord,BorderLayout.NORTH);
        this.getContentPane().add(centro,BorderLayout.CENTER);
      /*  javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelTap, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(160, 160, 160))
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabelDownload)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLabelApp))
                                                .addComponent(jLabelLoginSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(507, 507, 507)
                                        .addComponent(jLabelFreccia, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(166, 166, 166)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jButtonSignIn, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(314, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelDownload)
                                .addComponent(jLabelApp))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelLoginSelection)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(44, 44, 44)
                                        .addComponent(jLabelTap, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(jLabelFreccia, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(202, 202, 202)
                                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButtonSignIn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(626, Short.MAX_VALUE))
        );
        */
        pack();
    }

    /* Pulsante che avvia l'autenticazione */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        String token = new String(jPasswordField1.getPassword());
        jPasswordField1.setText("");
        Authentication autenticator = new Authentication(token);
    }

    public static void main(String args[]) throws IOException, InterruptedException {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Avvia subito la classe NFCreading affinche' si metta in ascolto
         attraverso il lettore NFC per la ricezione del TOKEN */
        Login l = new Login();
        l.setVisible(true);
        NFCreading nfc = new NFCreading(l);
    }

    // Dichiarazione variabili                     
    private javax.swing.JButton jButtonSignIn;
    private javax.swing.JLabel jLabelDownload;
    private javax.swing.JLabel jLabelFreccia;
    private javax.swing.JLabel jLabelLoginSelection;
    private javax.swing.JLabel jLabelTap;
    private javax.swing.JLabel jLabelApp;
    private javax.swing.JPasswordField jPasswordField1;
    // fine dichiarazione variabili                   
}

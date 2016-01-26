/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartmuseumtable;

import javax.swing.JOptionPane;

/**
 *
 * @author Claudia
 */
public class Authentication {

    Authentication(String token) {
       RestClient restClient = new RestClient("Utente",token);
      if( restClient.isStatus()){
        String output=restClient.getOutput();
        JOptionPane.showMessageDialog(null, output);
        Museo m=new Museo();
        m.setVisible(true);
      }
      else JOptionPane.showMessageDialog(null, "Il codice da lei inserito non corrisponde con alcun utente registrato! Riprovi!");
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartmuseumtable;

import javax.swing.JOptionPane;

/**
 *
 * @author Cosimo Antonaci
 * @author Gabriele Tramonte
 */
public class Authentication {

    Authentication(String token) {
        RestClient restClient = new RestClient("Utente", token);
        if (restClient.isStatus()) {
            String output = restClient.getOutput();
            String[] tmp = output.split("\n");
            String email = tmp[1].substring(tmp[1].indexOf(" ") + 1);
            int id = Integer.parseInt(tmp[2].substring((tmp[2].indexOf(" ") + 1)));
            String cognome = tmp[3].substring(tmp[3].indexOf(" ") + 1);
            String nome = tmp[5].substring(tmp[5].indexOf(" ") + 1);
            Utente.getIstance().setId(id);
            Utente.getIstance().setCognome(cognome);
            Utente.getIstance().setEmail(email);
            Utente.getIstance().setNome(nome);
            Utente.getIstance().setToken(token);
            Museo m = new Museo();
            m.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Il codice da lei inserito non corrisponde con alcun utente registrato! Riprovi!");
        }
    }

}

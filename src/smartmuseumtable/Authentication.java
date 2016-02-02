/* Questa classe legge il token dal form "Inserire token" della classe denominata
 "Login" e lo invia al Server rest di Amazon,
 ricevendo i dati dell'utente registrato altrimenti notifica l'errore di 
 battitura sulla  tastiera */
package smartmuseumtable;

import javax.swing.JOptionPane;

/*
 * @author Cosimo Antonaci
 * @author Gabriele Tramonte
 */
public class Authentication {

    Authentication(String token) {
        RestClient restClient = new RestClient("Utente", token);
        while(!restClient.isStatus()){
            //attesa dei dati
        }
        if (restClient.isStatus()) {
            String output = restClient.getOutput();
            String[] tmp = output.split("\n");
            String email = "";
            int id = 0;
            String cognome = "";
            String nome = "";
            for (int i = 0; i < tmp.length; i++) {
                if (tmp[i].contains("email")) {
                    email = tmp[i].substring(tmp[i].indexOf(" ") + 1);
                } else if (tmp[i].contains("id")) {
                    id = Integer.parseInt(tmp[i].substring((tmp[i].indexOf(" ") + 1)));
                } else if (tmp[i].contains("Nome")) {
                    nome = tmp[i].substring(tmp[i].indexOf(" ") + 1);
                } else {
                    cognome = tmp[i].substring(tmp[i].indexOf(" ") + 1);
                }
            }
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NFCtransmission;

import org.nfctools.examples.llcp.NDefListenerNuovo;
import smartmuseumtable.Museo;
import smartmuseumtable.RestClient;
import smartmuseumtable.Utente;

/**
 *
 * @author Gabriele
 */
public class ThreadNFC implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
            if (NDefListenerNuovo.getIstance().hasToken()) {
                String token = NDefListenerNuovo.getIstance().getRecord();
                RestClient rest = new RestClient("Utente", token);
                if (rest.isStatus()) {
                    String output = rest.getOutput();
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
                }
            }
        }
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartmuseumtable;

/**
 *
 * @author Claudia
 */
public class Authentication {

    Authentication(String token) {
       RestClient restClient = new RestClient("Utente",token);
      if( restClient.isStatus()){
          //resto del programma
       /*    testo = new ClientHttp(getApplicationContext()).execute("GET", "Utente", token).get();
            int idUtente = Integer.parseInt(testo.substring(testo.indexOf(" ") + 1, testo.indexOf("\n")));
            testo = new ClientHttp(getApplicationContext()).execute("GET", "Preferenze", Integer.toString(idUtente)).get();
         */       
            //qui devo avviare la classe museo che mi fa vedere le preferenze
          
      }
    }
    
    
}

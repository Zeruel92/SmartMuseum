/* Questa classe gestisce le chiamate rest al server di Amazon */
package smartmuseumtable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import org.json.*;

/*
 * @author Cosimo Antonaci
 * @author Gabriele Tramonte
 */

public class RestClient {

    private boolean status;// diventa true una volta che la comunicazione col server è completata
    private String output;// contiene il risultato della chiamata rest opportunatamente formattato in stringa
    
    /*Questo costruttore fa una richiesta GET (di http) alla tabella passata 
      come parametro e scarica la lista completa degli elementi di quella tabella */
    public RestClient(String tabella) throws IOException {
        String result = "";
        try {
            URL url = new URL("indirizzo/index.php/" + tabella + "/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            //convert response to string
            StringBuilder sb = new StringBuilder();
            sb.append(reader.readLine() + "\n");
            String line = "";
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }

            result = sb.toString();
        } catch (Exception e) {

        }
/*parsing data- JSON to TextPlain( testo in chiaro) */ 

        JSONArray jArray = new JSONArray(result);

        for (int i = 0; i < jArray.length(); i++) {
            JSONObject json = jArray.getJSONObject(i);
            Iterator<String> iter = json.keys();
            while (iter.hasNext()) {
                String key = iter.next();
                String value = json.getString(key);
                result += key + " " + value + "\n";
            }
        }

    }
/*Questo costruttore viene usato in fase di login e manda una richiesta al 
    server (GET), con il token, per ottenere i dati dell'utente */
    public RestClient(String tabella, String token) {
        status = false;
        try {
            URL url = new URL("http://52.17.122.110/index.php/" + tabella + "/token/" + token);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader read = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = read.readLine();
            String html = "";
            while (line != null) {
                html += line;
                line = read.readLine();
            }
            
            //parsing data
            if (!html.equals("null")) {
                JSONArray jArray = new JSONArray(html);
                html = "";
                for (int i = 0; i < jArray.length(); i++) {
                    JSONObject json = jArray.getJSONObject(i);
                    Iterator<String> iter = json.keys();
                    while (iter.hasNext()) {
                        String key = iter.next();
                        String value = json.getString(key);
                        html += key + " " + value + "\n";
                    }
                }
                status = true;
            }
            output = html;
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (IOException ioex) {
            ioex.printStackTrace();
        }
    }
/* Questo costruttore è generico! Basta specificargli tabella e id della risorsa
    che si vuole ottenere...opera,utente etc.. e scarica tutte le info associate */
    public RestClient(String tabella, int id) {
        status = false;
        try {
            URL url = new URL("http://52.17.122.110/index.php/" + tabella + "/" + id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader read = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = read.readLine();
            String html = "";
            while (line != null) {
                html += line;
                line = read.readLine();
            }
            
            //parsing data
            if (!html.equals("null")) {
                JSONArray jArray = new JSONArray(html);
                html = "";
                for (int i = 0; i < jArray.length(); i++) {
                    JSONObject json = jArray.getJSONObject(i);
                    Iterator<String> iter = json.keys();
                    while (iter.hasNext()) {
                        String key = iter.next();
                        String value = json.getString(key);
                        html += key + " " + value + "\n";
                    }
                }
                status = true;
            } else {
                html = "No record";
                status = true;
            }
            output = html;
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (IOException ioex) {
            ioex.printStackTrace();
        }
    }
//metodo GET-verifica stato dell'operazione
    public boolean isStatus() {
        return status;//se true(operazione completata) se false(operazione in corso)
    }
//metodo che una volta completata la richiesta permette di ottenere l'output in TextPlain
    public String getOutput() {
        return this.output;
    }
}

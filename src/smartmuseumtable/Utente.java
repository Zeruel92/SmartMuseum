/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartmuseumtable;

/**
 *
 * @author Gabriele
 */
public class Utente {
    private static Utente istance;

    private static String nome;
    private static String cognome;
    private static int id;
    private static String email;
    private static String token;
    
    public static Utente getIstance(){
        if(istance==null){
            istance=new Utente();
        }
        return istance;
    }
    private Utente(){
        nome="";
        cognome="";
        id=-1;
        email="";
        token="";
    }

    public  String getNome() {
        return nome;
    }

    public  void setNome(String NOME) {
        nome = NOME;
    }

    public  String getCognome() {
        return cognome;
    }

    public  void setCognome(String Cognome) {
        cognome = Cognome;
    }

    public  int getId() {
        return id;
    }

    public  void setId(int ID) {
        id = ID;
    }

    public  String getEmail() {
        return email;
    }

    public  void setEmail(String Email) {
        email = Email;
    }

    public  String getToken() {
        return token;
    }

    public  void setToken(String Token) {
        token = Token;
    }
    
}

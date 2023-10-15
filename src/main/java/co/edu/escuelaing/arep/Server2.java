package co.edu.escuelaing.arep;

import static spark.Spark.*;

public class Server2 {
    public static void main(String[] args) {
        port(getPort());
        secure(getKeyStore(), getKeyStorepwd(), null, null);
        get("/bonjour", (req, res) -> "Bonjour Monde!");
    }
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5001; //returns default port if heroku-port isn't set (i.e. on localhost)
    }

    static String getKeyStore(){
        if(System.getenv("KeyStore") != null){
            return System.getenv("KeyStore");
        }
        return "keys/ecikeystore2.p12";
    }

    static String getTrustStore(){
        if(System.getenv("TrustStore") != null){
            return System.getenv("TrustStore");
        }
        return "keys/ecikeystore.p12";
    }

    static String getKeyStorepwd(){
        if(System.getenv("KeyStorepwd") != null){
            return System.getenv("KeyStorepwd");
        }
        return "eci123";
    }
}

//keytool -genkeypair -alias ecikeypair -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore ecikeystore.p12 -validity 3650


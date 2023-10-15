package co.edu.escuelaing.arep;

import static spark.Spark.*;

public class Server1 {
    public static void main(String[] args) {
        port(getPort());
        secure(getKeyStore(), getKeyStorepwd(), null, null);
        get("/hello", (req, res) -> "Hello World!");
        get("/bonjour", (req, res) -> URLReader.readUrlSecure(getUrl(), getTrustStore(), getKeyStorepwd()));
    }
    private static String getUrl() {
        if (System.getenv("URL") != null) {
            return System.getenv("URL");
        }
        return "https://localhost:5001/bonjour";
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000; //returns default port if heroku-port isn't set (i.e. on localhost)
    }

    static String getKeyStore(){
        if(System.getenv("KeyStore") != null){
            return System.getenv("KeyStore");
        }
        return "keys/ecikeystore.p12";
    }

    static String getTrustStore(){
        if(System.getenv("TrustStore") != null){
            return System.getenv("TrustStore");
        }
        return "keys/ecikeystore2.p12";
    }

    static String getKeyStorepwd(){
        if(System.getenv("KeyStorepwd") != null){
            return System.getenv("KeyStorepwd");
        }
        return "eci123";
    }
}
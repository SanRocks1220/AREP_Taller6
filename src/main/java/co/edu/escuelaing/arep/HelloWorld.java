package co.edu.escuelaing.arep;

import static spark.Spark.*;

public class HelloWorld {
    public static void main(String[] args) {

        //API: secure(keystoreFilePath, keystorePassword, truststoreFilePath, truststorePassword); 
        secure("key/ecikeystore.p12", "eci123", null, null); 

        port(getPort());

        get("/hello", (req, res) -> "Hello World");
    }

    static int getPort() { 
        if (System.getenv("PORT") != null) { 
            return Integer.parseInt(System.getenv("PORT")); 
        } 
        return 5000; //returns default port if heroku-port isn't set (i.e. on localhost) 
    }
}

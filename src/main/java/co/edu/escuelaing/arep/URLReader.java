package co.edu.escuelaing.arep;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyStore;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

public class URLReader {
    
    public static void main(String[] args) throws Exception {
        //readURL("https://www.google.com");

        // Create a file and a password representation 
        File trustStoreFile = new File("key\\myTrustStore.12"); 
        char[] trustStorePassword = "eci456".toCharArray(); 
        // Load the trust store, the default type is "pkcs12", the alternative is "jks" 
        KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType()); 
        trustStore.load(new FileInputStream(trustStoreFile), trustStorePassword); 
        // Get the singleton instance of the TrustManagerFactory 
        TrustManagerFactory tmf = TrustManagerFactory 
        .getInstance(TrustManagerFactory.getDefaultAlgorithm()); 
        
        // Itit the TrustManagerFactory using the truststore object
        tmf.init(trustStore);

        //Set the default global SSLContext so all the connections will use it
        SSLContext sslContext = SSLContext.getInstance("TLS"); 
        sslContext.init(null, tmf.getTrustManagers(), null); 
        SSLContext.setDefault(sslContext); 
        // We can now read this URL
        readURL("https://localhost:5000/hello"); 
        // This one can't be read because the Java default truststore has been 
        // changed. 
        readURL("https://www.google.com");

    }

    public static void readURL(String urlstr) throws Exception {
        String site = urlstr;

        // Crea el objeto que representa una URL
        URL siteURL = new URL(site);
        // Crea el objeto que URLConnection
        URLConnection urlConnection = siteURL.openConnection();
        // Obtiene los campos del encabezado y los almacena en un estructura Map
        Map<String, List<String>> headers = urlConnection.getHeaderFields();
        // Obtiene una vista del mapa como conjunto de pares <K,V>
        // para poder navegarlo
        Set<Map.Entry<String, List<String>>> entrySet = headers.entrySet();
        // Recorre la lista de campos e imprime los valores
        for (Map.Entry<String, List<String>> entry : entrySet) {
            String headerName = entry.getKey();
            //Si el nombre es nulo, significa que es la linea de estado
            if (headerName != null) {
                System.out.print(headerName + ":");
            }
            List<String> headerValues = entry.getValue();
            for (String value : headerValues) {
                System.out.print(value);
            }
            System.out.println("");
            //System.out.println("");
        }

 

        System.out.println("-------message-body------");
        BufferedReader reader
                = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

 

        try (reader) {
            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine);
            }
        } catch (IOException x) {
            System.err.println(x);
        }
    }
}
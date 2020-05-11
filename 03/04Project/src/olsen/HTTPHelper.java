package olsen;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class HTTPHelper {

    // returns HTTP response string
    public String readHTTP(String url) {

        try{
            // Open a connection to the site
            URLConnection connection = new URL(url).openConnection();

            // Input stream to read the response
            InputStream response = connection.getInputStream();

            // Create a new scanner to read the response
            // Regexp \A is start of a string
            Scanner scanner = new Scanner(response);
            String responseBody = scanner.useDelimiter("\\A").next();
            return responseBody;

        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}

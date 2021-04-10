package HighLevelAPIs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class urlConnection {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://example.com");
            URLConnection connection = url.openConnection();
            connection.setDoOutput(true);
            connection.connect();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            for (String s = reader.readLine(); s != null; s = reader.readLine()) {
                System.out.println(s);
            }
            /*BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            for (String s = reader.readLine(); s != null; s = reader.readLine()) {
                System.out.println(s);
            }*/
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

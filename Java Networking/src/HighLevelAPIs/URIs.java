package HighLevelAPIs;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class URIs {
    public static void main(String[] args) {
        try {
//            URI uri = new URI("http://username:password@myserver.com:5000/catalogue/phones?os=android#samsung");
            URI baseUri = new URI("http://username:password@myserver.com:5000");
            URI uri = new URI("/catalogue/phones?os=android#samsung");
            URI resolvedUri = baseUri.resolve(uri);

            URL url = resolvedUri.toURL();
            System.out.println("URL = " + url);
//            URI uri = new URI("hello");

            System.out.println("Scheme = " + resolvedUri.getScheme());
            System.out.println("Scheme-specific part = " + resolvedUri.getSchemeSpecificPart());
            System.out.println("Authority = " + resolvedUri.getAuthority());
            System.out.println("User info = " + resolvedUri.getUserInfo());
            System.out.println("Host = " + resolvedUri.getHost());
            System.out.println("Port = " + resolvedUri.getPort());
            System.out.println("Path = " + resolvedUri.getPath());
            System.out.println("Query = " + resolvedUri.getQuery());
            System.out.println("Fragment = " + resolvedUri.getFragment());

        } catch(URISyntaxException e) {
            System.out.println("URI Bad Syntax: " + e.getMessage());
        } catch(MalformedURLException e) {
            System.out.println("URL Malformed: " + e.getMessage());
        }


    }
}

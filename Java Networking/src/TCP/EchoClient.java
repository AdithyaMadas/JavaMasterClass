package TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000)) {
            socket.setSoTimeout(2000);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            Scanner sc = new Scanner(System.in);
            do {
                String echoLine = sc.nextLine();
                if (echoLine.equalsIgnoreCase("exit")) {
                    writer.println(echoLine);
                    break;
                }
                writer.println(echoLine);
                String result = reader.readLine();
                System.out.println(result);
            } while (true);
        } catch (SocketTimeoutException e) {
            System.out.println("Timed Out! Server down!");
        } catch (IOException e) {
            System.out.println("Other Exception " + e.getMessage());
        }
    }
}

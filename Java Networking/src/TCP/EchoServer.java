package TCP;

import java.io.IOException;
import java.net.ServerSocket;

public class EchoServer {
    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            while (true) {
                new Echoer(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            System.out.println("ServerSocket Exception " + e.getMessage());
        }

        //Server without MultiThreading!
        /*try (ServerSocket serverSocket = new ServerSocket(5000)) {

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

                String echoLine = reader.readLine();
                if (echoLine.equalsIgnoreCase("exit")) {
                    break;
                }
                System.out.println("Echo from server " + echoLine);
                output.println("Echo from server " + echoLine);
            }
        } catch (IOException e) {
            System.out.println("Server Error" + e.getMessage());;
        }*/
    }
}

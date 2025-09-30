import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 8010;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                // This call blocks until a client connects.
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                // Handle the client connection directly on the main thread.
                try (PrintWriter toSocket = new PrintWriter(clientSocket.getOutputStream(), true)) {
                    toSocket.println("Hello from the single-threaded server!");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // The try-with-resources automatically closes the clientSocket here.
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
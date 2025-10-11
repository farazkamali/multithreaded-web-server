



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * A client application that connects to the server.
 * Implements Runnable to be executed in its own thread.
 */
public class Client implements Runnable {

    /**
     * The main logic for the client thread. Connects to the server,
     * sends a message, and prints the response.
     */
    @Override
    public void run() {
        String hostname = "localhost";
        int port = 8010;

        // Use try-with-resources to ensure the socket and its streams are automatically closed.
        try (Socket socket = new Socket(hostname, port);
             PrintWriter toSocket = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            toSocket.println("Hello from Client " + Thread.currentThread().getName());
            String line = fromSocket.readLine();
            System.out.println(Thread.currentThread().getName() + " received response: " + line);

        } catch (IOException e) {
            System.err.println("Client error on thread " + Thread.currentThread().getName() + ": " + e.getMessage());
        }
    }

    /**
     * The main entry point for the client application.
     * It simulates a load by starting multiple client threads.
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        int numClients = 10;
        System.out.println("Starting " + numClients + " client threads...");
        for (int i = 0; i < numClients; i++) {
            Thread thread = new Thread(new Client());
            thread.start();
        }
    }
}
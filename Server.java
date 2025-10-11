import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * A multithreaded TCP server that uses a thread pool to handle concurrent client connections.
 */
public class Server {

    /**
     * Handles a single client connection. Reads a message and sends a response.
     * This method is executed by a thread from the thread pool.
     * @param clientSocket The socket representing the client connection.
     */
    private static void handleClient(Socket clientSocket) {
        System.out.println("Handling client " + clientSocket.getInetAddress() + " using thread pool.");
        // Use try-with-resources to ensure the PrintWriter and Socket are closed.
        try (PrintWriter toSocket = new PrintWriter(clientSocket.getOutputStream(), true)) {
            toSocket.println("Hello from the final version of the server!");
        } catch (IOException e) {
            System.err.println("Error handling client: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        int port = 8010;
        // A thread pool with a fixed number of threads to manage client connections.
        ExecutorService pool = Executors.newFixedThreadPool(10);

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            // The main server loop, continuously listening for new connections.
            while (true) {
                Socket clientSocket = serverSocket.accept();
                // Submits the client handling task to the thread pool for execution.
                pool.execute(() -> handleClient(clientSocket));
            }
        } catch (IOException ex) {
            System.err.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
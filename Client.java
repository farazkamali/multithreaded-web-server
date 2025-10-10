


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client implements Runnable {

    @Override
    public void run() {
        String hostname = "localhost";
        int port = 8010;

        try (Socket socket = new Socket(hostname, port)) {
            PrintWriter toSocket = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            toSocket.println("Hello from Client " + Thread.currentThread().getName());
            String line = fromSocket.readLine();
            System.out.println(Thread.currentThread().getName() + " received: " + line);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Starting 10 client threads...");
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Client());
            thread.start();
        }
    }
}
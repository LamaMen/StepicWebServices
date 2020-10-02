package multithreading.main;

import multithreading.sockets.MultiThreadSocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public final static int PORT = 5050;
    private final static ExecutorService executor = Executors.newFixedThreadPool(10);

    /**
     * Если прервать сервер сторонне, если ещё открыты сокеты, возникает ошибка.
     */

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started");
            while (!server.isClosed()) {
                Socket newUserSocket = server.accept();
                executor.execute(new MultiThreadSocket(newUserSocket));
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

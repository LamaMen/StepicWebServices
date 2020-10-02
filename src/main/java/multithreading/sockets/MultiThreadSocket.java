package multithreading.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MultiThreadSocket implements Runnable {
    private static Socket userSocket;

    public MultiThreadSocket(Socket user) {
        userSocket = user;
    }

    @Override
    public void run() {
        try (PrintWriter outputStream = new PrintWriter(userSocket.getOutputStream());
             BufferedReader inputStream = new BufferedReader(new InputStreamReader(userSocket.getInputStream()))) {

            while (true) {
                String message = inputStream.readLine();
                outputStream.println(message);
                outputStream.flush();
                if (message.equals("Bue.")) {
                    userSocket.close();
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

package ru.netology.javacore;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TodoServer {

    public TodoServer(int port, Todos todos) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try (
                        Socket socket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
                    final String json = in.readLine();
                    todos.setTasks(json, todos);
                    for (String t : todos.getAllTasks()
                    ) {
                        out.print(t + " ");
                    }
                } catch (IOException e) {
                    System.out.println("Connection is down");
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() throws IOException {
        int port = 8989;
        System.out.println("Starting server at " + port + "...");
    }
}

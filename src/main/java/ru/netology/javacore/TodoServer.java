package ru.netology.javacore;

import com.google.gson.Gson;

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

                    out.println("New connection accepted");

                    final String json = in.readLine();
                    System.out.println(json);
                    Todos t = new Gson().fromJson(json, Todos.class);
                    if ("ADD".equals(t.getType())) {
                        todos.addTask(t.getTask());
                    } else if ("REMOVE".equals(t.getType())) {
                        todos.removeTask(t.getTask());
                    }
                    System.out.println(todos.getAllTasks());

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

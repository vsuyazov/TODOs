package ru.netology.javacore;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Todos todos = new Todos();
        TodoServer server = new TodoServer(8980, todos);
        server.start();
    }
}

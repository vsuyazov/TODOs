package ru.netology.javacore;

import java.util.*;

public class Todos {

    ArrayList<String> tasks = new ArrayList<>();

    public void addTask(String task) {
        tasks.add(task);
        Collections.sort(tasks);
    }

    public void removeTask(String task) {
        tasks.remove(task);
    }

    public ArrayList<String> getAllTasks() {
        return tasks;
    }

    public String getAllTasksList() {
        return tasks.toString();
    }
}

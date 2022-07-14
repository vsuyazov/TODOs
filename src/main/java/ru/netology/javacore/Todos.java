package ru.netology.javacore;

import java.util.*;

public class Todos {

    private String type;
    private String task;

    ArrayList<String> tasks = new ArrayList<>();

    public String getType() {
        return type;
    }

    public String getTask() {
        return task;
    }

    public void addTask(String task) {
        tasks.add(task);
        Collections.sort(tasks);
    }

    public void removeTask(String task) {
        tasks.remove(task);
    }

    public String getAllTasks() {
        return tasks.toString();
    }

    @Override
    public String toString() {
        return "type: " + type +
                " task: " + task;
    }
}

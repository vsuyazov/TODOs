package ru.netology.javacore;

import com.google.gson.Gson;

import java.util.*;

public class Todos {

    private String type;
    private String task;

    ArrayList<String> tasks = new ArrayList<>();

    public void setTasks(String json, Todos todos) {
        Todos t = new Gson().fromJson(json, Todos.class);
        if ("ADD".equals(t.getType())) {
            todos.addTask(t.getTask());
        } else if ("REMOVE".equals(t.getType())) {
            todos.removeTask(t.getTask());
        }
    }


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

    public ArrayList<String> getAllTasks() {
        return tasks;
    }

    public String getAllTasksList() {
        return tasks.toString();
    }

    @Override
    public String toString() {
        return task;
    }
}

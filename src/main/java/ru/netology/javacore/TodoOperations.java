package ru.netology.javacore;

import com.google.gson.Gson;

public class TodoOperations {

    private String type;
    private String task;

    public String getType() {
        return type;
    }

    public String getTask() {
        return task;
    }

    public static void setTasks(String json, Todos todos) {
        TodoOperations t = new Gson().fromJson(json, TodoOperations.class);
        if ("ADD".equals(t.getType())) {
            todos.addTask(t.getTask());
        } else if ("REMOVE".equals(t.getType())) {
            todos.removeTask(t.getTask());
        }
    }

    @Override
    public String toString() {
        return task;
    }
}

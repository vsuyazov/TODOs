package ru.netology.javacore;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

public class TodosTests {

    String task1 = "C";
    String task2 = "A";
    String task3 = "B";
    String task4 = "D";

    public Todos setTodos() {

        Todos todos = new Todos();

        todos.addTask(task1);
        todos.addTask(task2);
        todos.addTask(task3);

        return todos;
    }

    @Test
    public void getAllTasksTest() {

        List<String> expectedResult = Arrays.asList("A", "B", "C");

        String actual = setTodos().getAllTasksList();

        Assertions.assertEquals(expectedResult.toString(), actual);
    }

    @Test
    public void removeTaskTest() {
        List<String> expectedResult = Arrays.asList("A", "B");

        Todos actual = setTodos();

        actual.removeTask(task1);

        Assertions.assertEquals(expectedResult.toString(), actual.getAllTasksList());
    }

    @Test
    public void addTasksTest() {
        List<String> expectedResult = Arrays.asList("A", "B", "C", "D");

        Todos actual = setTodos();

        actual.addTask(task4);

        Assertions.assertEquals(expectedResult.toString(), actual.getAllTasksList());
    }
}

package de.sbley.junit5;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class TodoAppTest {

    @Test
    public void addTodo() {
        Todo todo = new Todo("Learn JUnit5", LocalDate.of(2016, Month.NOVEMBER, 14));

        TodoApp todoApp = new TodoApp();
        todoApp.addTodo(todo);

        List<Todo> todos = todoApp.getTodoList();
        assertEquals(1, todos.size(), "todo list should contain 1 element");

        assertAll("todo item should contain correct values", () -> {
            assertEquals("Learn JUnit5", todos.get(0).getTitle());
        }, () -> {
            assertEquals(LocalDate.of(2016, Month.NOVEMBER, 14), todos.get(0).getDueDate());
        });
    }
}

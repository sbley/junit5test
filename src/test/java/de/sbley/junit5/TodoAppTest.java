package de.sbley.junit5;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.expectThrows;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@DisplayName("⭐️ Todo App ⭐️")
public class TodoAppTest {

    private Todo todo;
    private TodoApp todoApp;

    @BeforeEach
    public void setup() {
        todo = new Todo("Learn JUnit5", LocalDate.of(2016, Month.NOVEMBER, 14));
        todoApp = new TodoApp();
    }

    @Test
    @DisplayName("Should add todo to list")
    public void addTodo() {

        // test
        todoApp.addTodo(todo);

        // assert
        List<Todo> todos = todoApp.getTodoList();
        assertEquals(1, todos.size(), () -> "todo list should contain 1 element");

        assertAll("todo item should contain correct values", () -> {
            assertEquals("Learn JUnit5", todos.get(0).getTitle());
        }, () -> {
            assertEquals(LocalDate.of(2016, Month.NOVEMBER, 14), todos.get(0).getDueDate());
        });
    }

    @Nested
    @DisplayName("Remove todo")
    class RemoveTodo {
        @Test
        @DisplayName("Todo list should be empty after deleting last todo")
        public void removeTodo() {
            todoApp.addTodo(todo);

            // test
            todoApp.remove(todo);

            // assert
            assertEquals(0, todoApp.getTodoList().size());
        }

        @Test
        @DisplayName("Should throw exception when deleting unknown todo")
        public void removeTodo_throwExceptionIfTodoIsNotInList() {
            TodoApp todoApp = new TodoApp();

            // test & assert
            IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> {
                todoApp.remove(todo);
            });
            assertEquals("Invalid todo", exception.getMessage());
        }
    }
}

package de.sbley.junit5;

import java.util.ArrayList;
import java.util.List;

public class TodoApp {

    private List<Todo> todos;

    public TodoApp() {
        todos = new ArrayList<>();
    }

    public void addTodo(Todo todo) {
        todos.add(todo);
    }

    public List<Todo> getTodoList() {
        return todos;
    }

    public void remove(Todo todo) {
        if (todos.contains(todo))
            todos.remove(todo);
        else
            throw new IllegalArgumentException("Invalid todo");
    }

}

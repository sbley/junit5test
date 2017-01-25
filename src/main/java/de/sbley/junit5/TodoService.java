package de.sbley.junit5;

import java.util.List;

public class TodoService {

    private TodoRepository repo;

    public TodoService(TodoRepository repo) {
        this.repo = repo;
    }

    public List<Todo> getTodoList() {
        return repo.getTodoList();
    }
}

package de.sbley.junit5;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class TodoRepository {

    private List<Todo> todoList = Arrays.asList(new Todo("one", LocalDate.parse("2016-11-12")),
            new Todo("two", LocalDate.parse("2016-10-01")));

    public List<Todo> getTodoList() {
        return todoList;
    }

}

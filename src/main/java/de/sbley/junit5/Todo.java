package de.sbley.junit5;

import java.time.LocalDate;

public class Todo {

    private String title;
    private LocalDate dueDate;

    public Todo(String title, LocalDate dueDate) {
        this.title = title;
        this.dueDate = dueDate;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

}

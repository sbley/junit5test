package de.sbley.junit5;

import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import de.sbley.junit5.extension.MockitoExtension;

@RunWith(JUnitPlatform.class)
@IncludeEngines("junit-jupiter")
@ExtendWith(MockitoExtension.class)
public class TodoServiceTest {

    private static final Todo SAMPLE_TODO = new Todo("mocked", LocalDate.now());

    @InjectMocks
    private TodoService service;

    @BeforeEach
    void init(@Mock TodoRepository repo) {
        given(repo.getTodoList()).willReturn(singletonList(SAMPLE_TODO));
    }

    @Test
    void getTodoList(@Mock TodoRepository repo) {
        List<Todo> todoList = service.getTodoList();
        assertTrue(todoList.size() == 1);
    }
}

package de.sbley.junit5;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class TodoTest {

    @Nested
    @DisplayName("equals and hashCode should be implemented")
    class EqualsContract implements EqualsHashCodeContract<Todo> {
        @Override
        public Todo value() {
            return new Todo("title", LocalDate.parse("2016-01-01"));
        }

        @Override
        public Todo equalValue() {
            return new Todo("title", LocalDate.parse("2016-01-01"));
        }

        @Override
        public Todo notEqualValue() {
            return new Todo("title", LocalDate.parse("2017-02-02"));
        }
    }
}

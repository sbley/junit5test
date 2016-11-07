package de.sbley.junit5;

import java.time.LocalDate;

import org.junit.jupiter.api.Nested;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class TodoTest {

	@Nested
	class EqualsHashCodeTest implements EqualsHashCodeContract<Todo> {

		@Override
		public Todo createValue() {
			return new Todo("Learn JUnit", LocalDate.of(2010, 1, 1));
		}

		@Override
		public Todo createEqualValue() {
			return new Todo("Learn JUnit", LocalDate.of(2010, 1, 1));
		}

		@Override
		public Todo createNotEqualValue() {
			return new Todo("Watch TV", LocalDate.now());
		}
	}
}

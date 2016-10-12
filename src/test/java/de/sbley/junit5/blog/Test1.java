package de.sbley.junit5.blog;

import static org.hamcrest.text.IsEmptyString.isEmptyString;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class Test1 {

	@Test
	public void emptyString() {
		// JUnit 5
		org.junit.jupiter.api.Assertions.assertTrue("".isEmpty());
		
		// AssertJ
		org.assertj.core.api.Assertions.assertThat("").isEmpty();
		
		// Hamcrest
		org.hamcrest.MatcherAssert.assertThat("", isEmptyString());
	}
}

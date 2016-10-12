package de.sbley.junit5.blog;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

/**
 * Unit test for simple App.
 */
@RunWith(JUnitPlatform.class)
public class AppTest {
//	@Test
//	@DisplayName("My 1st JUnit 5 test! 😎")
//	void myFirstTest(TestInfo testInfo) {
//		assertEquals(2, 1 + 1, "1 + 1 should equal 2");
//		assertEquals("My 1st JUnit 5 test! 😎", testInfo.getDisplayName(), "TestInfo is injected correctly");
//	}
	//
	// @Test
	// @Disabled
	// void disabledTest() {
	//
	// }
	//
	// @Test
	// void groupedAssertions() {
	// LocalDate now = LocalDate.of(2016, Month.FEBRUARY, 3);
	// assertAll("today", () -> assertEquals(3, now.getDayOfMonth(), "day"),
	// () -> assertEquals(Month.FEBRUARY, now.getMonth(), "month"),
	// () -> assertEquals(2016, now.getYear(), "year"));
	// }

	@Test
	void testOnlyOnDeveloperWorkstation() {
		assumeTrue("DEV".equals(System.getenv("ENV")), () -> "Aborting test: not on developer workstation");
		// remainder of test
	}
//
//	@Test
//	public void testName(TestReporter testReporter) {
//		testReporter.publishEntry("a key", "a value");
//	}
//
//	@Test
//	public void hamcrest() throws Exception {
//		assertTrue(IsInstanceOf.instanceOf(String.class).matches(5));
//	}
//	
//	@Test
//	public void hamcrestOld() throws Exception {
//		Assert.assertThat(5, IsInstanceOf.instanceOf(String.class));
//	}

	// @Test
	// public void matchers() throws Exception {
	// List<String> list = Collections.emptyList();
	// assertTrue(isEmpty(list), "empty list");
	// }
}

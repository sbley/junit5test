package de.sbley.junit5;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class FirstTest {

    @Test
    public void test() {
        assertEquals(9, 5 + 4);
    }

}

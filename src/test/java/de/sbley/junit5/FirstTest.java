package de.sbley.junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class FirstTest {

    @org.junit.jupiter.api.Test
    public void junit5() {
        Assertions.assertEquals(9, 4 + 5);
    }
}

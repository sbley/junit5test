package de.sbley.junit5;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import de.sbley.junit5.extension.CoffeeExtension;
import de.sbley.junit5.extension.MockitoExtension;

@RunWith(JUnitPlatform.class)
@IncludeEngines({ "junit-jupiter", "sbley-coffee" })
@ExtendWith({ CoffeeExtension.class, MockitoExtension.class })
public class CoffeeTest {

    @Mock
    Dimension dim;

    @BeforeEach
    void init(@Mock Dimension dim, @Mock java.text.DateFormat format) throws ParseException {
        given(dim.getHeight()).willReturn(200D);
        given(dim.getWidth()).willReturn(300D);
        given(format.parse("heute")).willReturn(new Date());
    }

    @Test
    void junit5test(@Mock Dimension dim) {
        System.out.println(dim.getHeight());
        then(new Rectangle(dim).getWidth()).isEqualTo(300D);
    }

    @Test
    void junit5test(@Mock DateFormat format) throws ParseException {
        System.out.println(format.parse("heute"));
    }
}

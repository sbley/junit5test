package de.sbley.junit5;

import org.junit.platform.runner.IncludeEngines;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@IncludeEngines({ "junit-jupiter", "sbley-coffee" })
public class CoffeeEngineTest {

}

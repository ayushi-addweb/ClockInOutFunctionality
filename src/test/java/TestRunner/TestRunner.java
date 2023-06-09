package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"/Users/addweb/IdeaProjects/ClockInOut/src/test/java/Feature"},
        glue = {"Steps"},
        plugin = {"html:/Users/addweb/Desktop//Report/ClockInOut.html"}
)

public class TestRunner
{

}

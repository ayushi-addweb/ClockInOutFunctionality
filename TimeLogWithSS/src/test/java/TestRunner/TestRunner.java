package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"/Users/addweb/Downloads/TimeLogWithSS/src/test/java/Feature"},
        glue = {"Steps"},
        plugin = {"html:/Users/addweb/Desktop//Report/Timelog.html"}
)

public class TestRunner
{

}

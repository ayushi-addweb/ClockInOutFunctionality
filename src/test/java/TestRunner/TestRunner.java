package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"/Users/addweb/IdeaProjects/TickTalk/ClockInOut/src/test/java/Feature"},
        glue = {"Steps"},
        plugin = {"html:/Users/addweb/Desktop//Report//TickTalk/ClockInOut.html"})
public class TestRunner
{
}

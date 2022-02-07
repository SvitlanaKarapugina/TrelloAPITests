import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features",
        plugin = {"pretty", "html:target/cucumber-report/smoketest", "json:target/cucumber.json"})
public class RunnerTest {
}

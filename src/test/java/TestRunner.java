import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/resources/features", // path to your feature files
        glue = "steps",                // package containing step definitions
        plugin = {
                "pretty",                         // console output
                "html:target/cucumber-reports.html", // HTML report
                "json:target/cucumber-reports.json"  // JSON report
        },
        monochrome = true
)
public class TestRunner {
}

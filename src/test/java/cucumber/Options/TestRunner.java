package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/features",
		glue= {"stepDefinations"},
		plugin = {"pretty",
			                "html:target/cucumber-reports/cucumber.html",
			                "json:target/cucumber-reports/cucumber.json"
			        }
		//tags= "@DeletePlace"		
		)
public class TestRunner {

}

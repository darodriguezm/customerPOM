import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features ="src/test/resources/features/",
		glue="steps",
		publish = true
)
public class TestRunner extends AbstractTestNGCucumberTests{
	
	public TestRunner() {
		System.out.println("iniciando test");
	}
}
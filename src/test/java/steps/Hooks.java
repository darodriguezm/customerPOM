package steps;

import common.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClass {

	private BaseClass base;

	public Hooks(BaseClass baseClass){
		super();
		this.base = baseClass;
	}

	@Before
	public void beforeScenario() {
		System.out.println("Impresión antes de ejecutar el caso");
	}
	
	@After
	public void afterScenario() {
		System.out.println("Impresión después de ejecutar el caso");
		this.base.driver.close();
	}
	
	@BeforeStep
	public void beforeStep(Scenario scenario) {
		//System.out.println("Escenario: " + scenario.getId());
	}
}

package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helpers.SodimacWebHelpers;

public class HomePage {
	@FindBy(css = "[placeholder=\"¿Qué estás buscando?\"]")
	private WebElement busquedaField;
	
	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void realizarBusqueda(String producto) {
		busquedaField.sendKeys(producto);
		busquedaField.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(SodimacWebHelpers.waitTime, TimeUnit.SECONDS);
	}
	
}

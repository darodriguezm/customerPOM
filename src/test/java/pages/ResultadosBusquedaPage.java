package pages;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import helpers.SodimacWebHelpers;

public class ResultadosBusquedaPage {
	
	@FindBy(css=".jsx-2202861071.search-term")
	private WebElement resultadoBusquedaLabel;
	
	@FindBy(css=".product-wrapper")
	private List<WebElement> productosField;
	
	private WebDriver driver;
	
	public ResultadosBusquedaPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void SeleccionarProductoAleatorio() {
		Random aleatorio = new Random();
		int nextValueInt = aleatorio.nextInt(productosField.size()); 

		WebElement articuloRandom = productosField.get(nextValueInt);
		
		articuloRandom.click();
		driver.manage().timeouts().implicitlyWait(SodimacWebHelpers.waitTime, TimeUnit.SECONDS);
	}
	
	public void AssertPage(String articulo) {
		String ResultadoBusquedaText = "Resultados de búsqueda para \"" + articulo + "\"";

		Assert.assertEquals(ResultadoBusquedaText, resultadoBusquedaLabel.getText());
	}
}

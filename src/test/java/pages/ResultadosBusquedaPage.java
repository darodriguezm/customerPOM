package pages;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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
		
		SodimacWebHelpers.log(driver, "ResultadosBusquedaPage - Constructor: ");
	}
	
	public void SeleccionarProductoAleatorio() {
		Random aleatorio = new Random();
		int nextValueInt = aleatorio.nextInt(productosField.size()); 

		WebElement articuloRandom = productosField.get(nextValueInt);
		
		SodimacWebHelpers.log(driver, "ResultadosBusquedaPage.SeleccionarProductoAleatorio - Producto aleatorio seleccionado: \n" + articuloRandom.getText());
		
		articuloRandom.findElement(By.cssSelector(".product-title")).click();
		driver.manage().timeouts().implicitlyWait(SodimacWebHelpers.waitTime, TimeUnit.SECONDS);
	}
	
	public void AssertPage(String articulo) {
		String resultadoBusquedaText = "Resultados de búsqueda para \"" + articulo + "\"";
		String resultadoBusquedaLabelText = resultadoBusquedaLabel.getText();
		
		SodimacWebHelpers.log(driver, "ResultadoBusquedaPage.AssertPage - valor esperado: " + resultadoBusquedaText + ", valor actual: " + resultadoBusquedaLabelText);
		Assert.assertEquals(resultadoBusquedaText, resultadoBusquedaLabelText);
	}
}

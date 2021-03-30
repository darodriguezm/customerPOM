package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ArticuloPage {
	@FindBy(id = "accordion-product-description")
	private WebElement descriptionField;

	@FindBy(css = ".simple-table")
	private List<WebElement> detallesField;

	private WebDriver driver;

	public ArticuloPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void AssertNullFields() {
		List<String> valores = new ArrayList<String>();

		detallesField.forEach((detalleFila) -> {
			String textoValor = detalleFila.findElement(By.cssSelector(".value")).getText();
			valores.add(textoValor);
		});
		
		Assert.assertFalse(valores.contains(""));

	}

	public void AssertPage() {
		String descriptionText = "Descripción";

		Assert.assertEquals(descriptionText, descriptionField.getText());
	}
}

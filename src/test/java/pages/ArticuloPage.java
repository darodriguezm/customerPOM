package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import helpers.SodimacWebHelpers;

public class ArticuloPage {
	@FindBy(id = "accordion-product-description")
	private WebElement descriptionField;

	@FindBy(css = ".value.cell")
	private List<WebElement> detallesField;

	private WebDriver driver;

	public ArticuloPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		SodimacWebHelpers.log(driver, "ArticuloPage - Constructor");
	}

	public void AssertNullFields() {
		List<String> valores = new ArrayList<String>();
		
		detallesField.forEach((elementCell) -> {
			String valor = elementCell.findElement(By.tagName("div")).getText();
			valores.add(valor);

		});
		
		SodimacWebHelpers.log(driver, "ArticuloPage.AssertNullField - \n" + String.join("\n", valores));
		Assert.assertFalse(valores.contains(""));

	}

	public void AssertPage() {
		String descriptionText = "Descripción";
		String descriptionFieldText = descriptionField.getText();
		
		SodimacWebHelpers.log(driver, "ArticuloPage.AssertPage - valor esperado: " + descriptionText + ", valor actual: " + descriptionFieldText);
		Assert.assertEquals(descriptionText, descriptionFieldText);
	}
}

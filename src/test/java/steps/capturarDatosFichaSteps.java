package steps;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.SodimacWebHelpers;
import pages.ArticuloPage;
import pages.HomePage;
import pages.ResultadosBusquedaPage;

public class capturarDatosFichaSteps {
	private WebDriver driver;

    @Given ("^quiero ingresar al portal de sodimac$")
    public void ingresarAlPortal() {
    	this.driver = SodimacWebHelpers.initChromeDriver(driver, "https://www.sodimac.cl/sodimac-cl/");
    	
    }
    
    @When ("^realizo la busqueda de un tipo de (.*)$")
    public void realizarBusquedaDeArticulo(String articulo) {
    	HomePage homePage = new HomePage(this.driver);
    	homePage.realizarBusqueda(articulo);
    	
    	ResultadosBusquedaPage resultadoBusquedaPage = new ResultadosBusquedaPage(this.driver);
    	resultadoBusquedaPage.AssertPage(articulo);
    	
    }
    
    @When ("^ingreso a los detalles de un producto aleatorio del resultado$")
    public void ingresarAProductoAleatorio() {
    	ResultadosBusquedaPage resultadoBusquedaPage = new ResultadosBusquedaPage(this.driver);
    	resultadoBusquedaPage.SeleccionarProductoAleatorio();
    	
    	ArticuloPage articuloPage = new ArticuloPage(this.driver);
    	articuloPage.AssertPage();
    }
    
    @Then ("^validar que los campos del articulo seleccionado no sean nulos$")
    public void validarNoNulidesDeCampos() {
    	ArticuloPage articuloPage = new ArticuloPage(this.driver);
    	articuloPage.AssertNullFields();
    	
    }
    
    @After
    public void closeChrome() {
    	this.driver.close();
    	
    }
    
}

package steps;

import common.BaseClass;
import helpers.SodimacWebHelpers;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ArticuloPage;
import pages.HomePage;
import pages.ResultadosBusquedaPage;

public class capturarDatosFichaSteps extends BaseClass{

	
	private BaseClass base;

	public capturarDatosFichaSteps(BaseClass baseClass){
		super();
		this.base = baseClass;
	}

    @Given ("^quiero ingresar al portal de sodimac$")
    public void ingresarAlPortal() {
    	this.base.driver = SodimacWebHelpers.initChromeDriver(this.base.driver, this.url);
    	
    }
    
    @When ("^realizo la busqueda de un tipo de (.*)$")
    public void realizarBusquedaDeArticulo(String articulo) {
    	HomePage homePage = new HomePage(this.base.driver);
    	homePage.realizarBusqueda(articulo);
    	
    	ResultadosBusquedaPage resultadoBusquedaPage = new ResultadosBusquedaPage(this.base.driver);
    	resultadoBusquedaPage.AssertPage(articulo);
    	
    }
    
    @When ("^ingreso a los detalles de un producto aleatorio del resultado$")
    public void ingresarAProductoAleatorio() {
    	ResultadosBusquedaPage resultadoBusquedaPage = new ResultadosBusquedaPage(this.base.driver);
    	resultadoBusquedaPage.SeleccionarProductoAleatorio();
    	
    	ArticuloPage articuloPage = new ArticuloPage(this.base.driver);
    	articuloPage.AssertPage();
    }
    
    @Then ("^validar que los campos del articulo seleccionado no sean nulos$")
    public void validarNoNulidesDeCampos() {
    	ArticuloPage articuloPage = new ArticuloPage(this.base.driver);
    	articuloPage.AssertNullFields();
    	
    }
	/* 
	@After
	public void closeChrome() {
		this.base.driver.close();
	  
	}
	  */
    
}

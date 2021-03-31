package helpers;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SodimacWebHelpers {

	public static int waitTime = 20;

	public static WebDriver initChromeDriver(WebDriver driver, String url) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to(url);

		SodimacWebHelpers.log(driver, "Inicializando ChromeDriver");
		
		return driver;
	}

	public static void log(WebDriver driver, String record) {
		Logger log = Logger.getLogger(SodimacWebHelpers.class.getName());
		
		log.info(record);
		log.info("Url actual: " + driver.getCurrentUrl());
		log.info("Título de página: " + driver.getTitle());

	}

}

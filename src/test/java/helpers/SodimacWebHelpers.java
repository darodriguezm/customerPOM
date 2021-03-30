package helpers;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SodimacWebHelpers {

	private static FileRecordWriter fileRecordWriter= new FileRecordWriter();
	
	public static int waitTime = 10;
	
	public static WebDriver initChromeDriver(WebDriver driver, String url) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to(url);
		
		return driver;
	}
	
	public static void outputWriter(WebDriver driver, String record) {
		
		List<String> currentValues = new ArrayList<String>();
		
		currentValues.add(driver.getCurrentUrl());
		currentValues.add(driver.getTitle());
		currentValues.add(record);
		
		fileRecordWriter.append(String.join(",", currentValues));
	}
	
	
}

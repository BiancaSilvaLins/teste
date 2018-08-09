package core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

	private static WebDriver driver;
	
	private DriverFactory() {
		
	}
	
	public static WebDriver getDriver() {
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", Propriedades.driverPath + "chromedriver2-40.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("no-sandbox");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		return driver;
	}
	
	public static void killDriver() {
		if (driver != null)  {
			driver.quit();
			driver = null;
		}
	}
}

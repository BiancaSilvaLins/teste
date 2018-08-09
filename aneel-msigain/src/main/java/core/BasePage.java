package core;
import org.openqa.selenium.WebDriver;

import core.DSL;

public class BasePage {

	private WebDriver driver;
	private DSL dsl;
	
	public BasePage() {
		dsl = new DSL(driver);
	}
	
}

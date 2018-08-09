package core;

import static core.DriverFactory.*;
import java.io.File;
import java.io.IOException;
import org.junit.After;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

public class BaseTest {

	@Rule
	public TestName testName = new TestName();
	
	@After
	public void finalizar() throws IOException {
		TakesScreenshot ss = (TakesScreenshot) DriverFactory.getDriver(); 
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File("target" + File.separator + "screenshot" + File.separator + testName.getMethodName() + ".jpg"));
		
		if (Propriedades.FECHAR_BROWSER) {
			//killDriver();
		} 
	}
}

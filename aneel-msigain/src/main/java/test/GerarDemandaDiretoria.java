package test;

import static core.DriverFactory.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import core.DriverFactory;
import core.Propriedades;
import pages.AnalisarDemandaDiretoriaPage;
import pages.GerarDemandaDiretoriaPage;
import pages.UtilPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GerarDemandaDiretoria {
	private WebDriver driver;
	private GerarDemandaDiretoriaPage page;	
	private UtilPage util;
	

	@Before
	public void iniciar() throws InterruptedException, IOException {
		driver = DriverFactory.getDriver();
		page = new GerarDemandaDiretoriaPage(driver);
		util = new UtilPage(driver);
		
		Login login = new Login();
		login.Login_Init();
		
		util.mudarPerfil();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section/header/ul[1]/li[3]/a")));
		util.selecionarPerfilAdministrador();
	}
	
	@Rule
	public TestName testName = new TestName();
	
	@After
	public void finalizar() throws IOException {
		TakesScreenshot ss = (TakesScreenshot) driver;
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File("target" + File.separator + "screenshot" + File.separator + testName.getMethodName() + ".jpg"));

			if (Propriedades.FECHAR_BROWSER) {
				killDriver();
			}
	}
	
	@Test
	public void CT01_Fluxo_Principal() throws InterruptedException {
		page.clicarAin();
		page.clicarDiretoria();		
		page.clicarClassificar();

		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		wait.until(ExpectedConditions.
				visibilityOfElementLocated(By.
						xpath("//*[@id=\"tableClassificar\"]/tbody/tr[1]/td[1]")));
		page.clicarDemanda();

		wait.until(ExpectedConditions.
				visibilityOfElementLocated(By.id("headingOne")));
		
		page.clicarGerarDemanda();	
		
		Thread.sleep(1000);
		assertEquals(page.obterTextoByName("h1"), "Extrato da Demanda");
		
		page.clicarConfirmarGerarDemanda();
	}
}

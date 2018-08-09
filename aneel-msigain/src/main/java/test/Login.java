package test;

import static core.DriverFactory.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import core.DSL;
import core.DriverFactory;
import core.Propriedades;
import pages.LoginPage;


public class Login {

	private WebDriver driver = DriverFactory.getDriver();
	private LoginPage page;

	public void Login_Init() throws InterruptedException {
		this.iniciar();
		this.LoginUsuario();
	}
	
	@Before
	public void iniciar() throws InterruptedException {
		driver.get("http://s3a.teste.aneel.net");
		page = new LoginPage(driver);
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
	public void LoginUsuario() throws InterruptedException {
		page.fazerLogin();
		assertEquals(page.sistemaPresente("MSIGAIN"), "MSIGAIN");
		page.acessaSistema("MSIGAIN");
		assertEquals(page.verificaTitulo(), "Painel de Controle");
	}
}

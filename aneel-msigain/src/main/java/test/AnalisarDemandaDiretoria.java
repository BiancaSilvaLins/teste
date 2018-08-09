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
import pages.UtilPage;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AnalisarDemandaDiretoria {
	private WebDriver driver;
	private AnalisarDemandaDiretoriaPage page;
	private UtilPage util;
	
	@Before
	public void iniciar() throws InterruptedException, IOException {
		driver = DriverFactory.getDriver();
		page = new AnalisarDemandaDiretoriaPage(driver);
		util = new UtilPage(driver);
		
		Login login = new Login();
		login.Login_Init();
		
		util.mudarPerfil();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
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
	
	@Ignore
	public void CT01() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section/header/ul[1]/li[3]/a")));
		util.selecionarPerfilAdministrador();
		
		page.clicarAin();
		page.clicarDiretoria();
		page.clicarAnalisar();
		
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loading")));
		page.clicarManifestacaoUorg();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tableAnalisarComManifestacaoUorg']/tbody/tr/td[1]/a")));
		page.clicarDemanda();
		page.informarAnaliseAin("Teste automatizado");
		page.clicarDemandaSerTratada();
		page.clicarSalvar();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tableAnalisarComManifestacaoUorg']/tbody/tr/td[1]/a")));
		page.clicarDemanda();
		
		page.salvoUorg();
	}
	
	@Ignore
	public void CT02() throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section/header/ul[1]/li[3]/a")));
		util.selecionarPerfilSuperintendente();
		
		page.clicarUorg();
		page.clicarDeterminacao();
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loading")));
		page.clicarManifestacaoUorgPendente();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tableDemandaDiretoriaPendentesResposta']/tbody/tr/td[1]/a")));
		page.clicarDemandaPendente();
		
		page.clicarAnalisarResposta();
		
		page.informarAnaliseResposta("Teste Automatizado");
		
		page.clicarSalvar2();
		
		page.salvoComSucesso();
		
	}
	
	@Ignore
	public void CT03() throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section/header/ul[1]/li[3]/a")));
		util.selecionarPerfilAdministrador();
		
		page.clicarAin();
		page.clicarDiretoria();
		page.clicarAnalisar();
		
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loading")));
		page.clicarManifestacaoDiretoria();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tableAnalisarComManifestacaoDiretoria']/tbody/tr/td[1]/a")));
		page.clicarDemanda3();
		page.informarAnaliseAin3("Teste automatizado");
		page.clicarSalvar3();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tableAnalisarComManifestacaoDiretoria']/tbody/tr/td[1]/a")));
		page.clicarDemanda3();
		
		page.salvoDiretoria();
	}
	
	@Ignore
	public void CT04() throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section/header/ul[1]/li[3]/a")));
		util.selecionarPerfilDiretoria();
		
		page.clicarDiretoriaPendente();
		page.clicarDeterminacaoDiretoria();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='collapseOneDiretoria']")));
		page.clicarManifestacaoDiretoriaPendente();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pendenteManifestacaoDiretoriaTable']/tbody/tr[1]/td[1]/a")));
		page.clicarDemandaDiretoriaPendente();
		
		page.informarResposta("Teste Automatizado");
		
		page.clicarSalvar4();
		
		page.salvoComSucessoDir();
			
	}
	
	@Test
	public void CT05() throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section/header/ul[1]/li[3]/a")));
		util.selecionarPerfilAdministrador();
		
		page.clicarAin();
		page.clicarDiretoria();
		page.clicarAnalisar();
		
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loading")));
		page.clicarManifestacaoUorg();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tableAnalisarComManifestacaoUorg']/tbody/tr/td[1]/a")));
		page.clicarDemanda();
		
		page.retornarUORG();
		
		page.retornoUORG();
	}
	
	@Test
	public void CT06() throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section/header/ul[1]/li[3]/a")));
		util.selecionarPerfilAdministrador();
		
		page.clicarAin();
		page.clicarDiretoria();
		page.clicarAnalisar();
		
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loading")));
		page.clicarManifestacaoDiretoria();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tableAnalisarComManifestacaoDiretoria']/tbody/tr/td[1]/a")));
		page.clicarDemanda3();
		
		page.retornarDiretoria();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section/header/ul[1]/li[3]/a")));
		util.selecionarPerfilDiretoria();
		
		page.clicarDiretoriaPendente();
		page.clicarDeterminacaoDiretoria();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='collapseOneDiretoria']")));
		page.clicarManifestacaoDiretoriaPendente();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pendenteManifestacaoDiretoriaTable']/tbody/tr[1]/td[1]/a")));
		page.clicarDemandaDiretoriaPendente();
		
		
	}

}

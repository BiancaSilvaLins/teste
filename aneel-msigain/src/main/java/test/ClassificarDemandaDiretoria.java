package test;

import static core.DriverFactory.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
import pages.ClassificarDemandaDiretoriaPage;
import pages.UtilPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClassificarDemandaDiretoria {
	private WebDriver driver;
	private ClassificarDemandaDiretoriaPage page;
	private UtilPage util;
	@Before
	public void iniciar() throws InterruptedException, IOException {
		driver = DriverFactory.getDriver();
		page = new ClassificarDemandaDiretoriaPage(driver);
		util = new UtilPage(driver);
		
		Login login = new Login();
		login.Login_Init();
		
		util.mudarPerfil();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section/header/ul[1]/li[3]/a")));
		util.selecionarPerfilAdministrador();
		
		page.clicarAin();
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
	@Test
	public void CT01_Fluxo_Principal() throws InterruptedException {
		page.clicarDiretoria();
		page.clicarClassificar();

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.
				visibilityOfElementLocated(By.
						xpath("//*[@id=\"tableClassificar\"]/tbody/tr[1]/td[1]")));
		page.clicarDemanda();

		wait.until(ExpectedConditions.
				visibilityOfElementLocated(By.id("headingOne")));
		page.clicarAjustarDemanda();
		
		page.informarDemandaAjustada("Teste automatizado");
		
		page.clicarIndicarResponsavel();
		
		page.informarUnidadeResponsavel();
		page.clicarAdicionarUnidadeEnvolvida();
		
		page.definirPrazo();
		page.definirTotalDias("12");
		page.definirPadraoReiteracao("1");
		page.clicarAdicionar();	
		
	}
	
	@Ignore
	@Test
	public void CT02_FA01_Incluir_IndicacaoUORG() throws InterruptedException{
		page.clicarDiretoria();
		page.clicarClassificar();

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.
				visibilityOfElementLocated(By.
						xpath("//*[@id=\"tableClassificar\"]/tbody/tr[1]/td[1]")));
		page.clicarDemanda();

		wait.until(ExpectedConditions.
				visibilityOfElementLocated(By.id("headingOne")));
		page.clicarAjustarDemanda();
		
		page.informarDemandaAjustada("Teste automatizado");
		page.clicarIndicarResponsavel();
		page.informarUnidadeResponsavel();
	}
	
	@Test
	public void CT03_FA02_Retirar_IndicacaoUORG() throws InterruptedException{
		page.clicarDiretoria();
		page.clicarClassificar();

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.
				visibilityOfElementLocated(By.
						xpath("//*[@id=\"tableClassificar\"]/tbody/tr[1]/td[1]")));
		page.clicarDemanda();

		wait.until(ExpectedConditions.
				visibilityOfElementLocated(By.id("headingOne")));
		page.clicarAjustarDemanda();
		
		page.informarDemandaAjustada("Teste automatizado");
		page.clicarIndicarResponsavel();
		page.informarUnidadeResponsavel();
		page.clicarAdicionarUnidadeEnvolvida();
		
		String unidadeEnvolvida = page.getUnidadeResponsavelAdicionada();
		
		wait.until(ExpectedConditions.
		visibilityOfElementLocated(By.
				xpath("//*[@id=\"UnidadesAdicionais\"]/tbody/tr/td[3]/a")));		

		page.retirarUnidadeResponsavel("Excluir");		
	
		assertFalse(unidadeEnvolvida.equals(page.getUnidadeResponsavelAdicionada()));
	}
	
	@Ignore
	@Test
	public void CT04_FA03_Salvar() throws InterruptedException {
		page.clicarDiretoria();
		page.clicarClassificar();

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.
				visibilityOfElementLocated(By.
						xpath("//*[@id=\"tableClassificar\"]/tbody/tr[1]/td[1]")));
		page.clicarDemanda();

		wait.until(ExpectedConditions.
				visibilityOfElementLocated(By.id("headingOne")));
		page.clicarAjustarDemanda();
		
		page.informarDemandaAjustada("Teste automatizado");
		
		page.clicarIndicarResponsavel();
		
		page.informarUnidadeResponsavel();
		page.clicarAdicionarUnidadeEnvolvida();
		

		page.definirPrazo();
		page.definirTotalDias("12");
		page.definirPadraoReiteracao("1");
		
		page.clicarSalvar();
	}
	
	@Ignore
	@Test
	public void CT04_FA04_Alterar() throws InterruptedException {
		page.clicarDiretoria();
		page.clicarClassificar();

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.
				visibilityOfElementLocated(By.
						xpath("//*[@id=\"tableClassificar\"]/tbody/tr[1]/td[1]")));
		page.clicarDemanda();

		wait.until(ExpectedConditions.
				visibilityOfElementLocated(By.id("headingOne")));
		page.clicarAjustarDemanda();
		
		page.clicarAlterar();
		
		assertEquals("Alterar - Demanda", page.getHeaderXpath());
		
		
		wait.until(ExpectedConditions.
				visibilityOfElementLocated(By.id("headingOne")));
		page.clicarAjustarDemanda();
		page.informarDemandaAjustada("Teste automatizado");
		
		page.definirPrazo();
		page.definirTotalDias("12");
		page.definirPadraoReiteracao("1");
		
		page.clicarSalvarAlteracao();
		
		wait.until(ExpectedConditions.
				visibilityOfElementLocated(By.className("toast-message")));
		assertEquals("Registro Alterado com Sucesso.", page.getMensagemSucessoToast());
	}
}

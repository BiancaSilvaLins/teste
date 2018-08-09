package pages;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.DSL;

public class ClassificarDemandaDiretoriaPage {
	private DSL dsl;
	
	public ClassificarDemandaDiretoriaPage(WebDriver driver) {
		dsl = new DSL(driver);
	}

	public void clicarAin() {
		dsl.clicarBotaoXpath("//*[@id=\"nav\"]/section/section/div/nav/ul/li[1]/a");
		dsl.clicarBotaoXpath("//*[@id=\"nav\"]/section/section/div/nav/ul/li[1]/ul/li/a");
	}

	public void clicarDiretoria() throws InterruptedException {
		dsl.clicarBotaoXpath("//*[@id=\"recomendacaoCheck\"]/div/div/div/div/div[3]/label/i");
	}

	public void clicarClassificar() {
		dsl.clicarBotaoXpath("//*[@id=\"determinacaoDirCheck\"]/div[2]/div/div/div/div[1]/label/i");
	}

	public void clicarDemanda() {
		dsl.clicarBotaoXpath("//*[@id=\"tableClassificar\"]/tbody/tr[1]/td[1]/a");
	}

	public void informarDemandaAjustada(String demanda) throws InterruptedException {
		Thread.sleep(1000);
		dsl.escrever(By.name("DscDemandaAjustada"), demanda );
	}

	public void clicarIndicarResponsavel() throws InterruptedException {
		dsl.clicarBotao(By.id("collapsedUnidadeResponsavel"));
	}

	public void definirPrazo() {
		dsl.clicarBotaoXpath("//*[@id=\"formClassificar\"]/section/article/div[3]/div/div/div[1]/label/i");
	}

	public void definirTotalDias(String s) {
		dsl.escrever("diasUteisCamp", s);
	}

	public void definirPadraoReiteracao(String s) {
		dsl.escrever("MdaDiaReiteracao", s);		
	}

	public void clicarAdicionar() {
		dsl.actionsClicarBotaoById("AdicionarDemandaBtn");
	}

	public void clicarAjustarDemanda() {
		dsl.clicarBotaoXpath("//*[@id=\"headingOne\"]/a");
	}

	public void informarUnidadeResponsavel() {
		dsl.escrever(By.id("NomEnteDespersonalizado"), "SFE");
		dsl.acionarTeclado(Keys.ARROW_DOWN);
		dsl.acionarTeclado(Keys.ENTER);
	}

	public void clicarAdicionarUnidadeEnvolvida() throws InterruptedException {
		
		dsl.acionarTeclado(Keys.PAGE_DOWN);
	}

	public void retirarUnidadeResponsavel(String title) {
		dsl.clicarBotao(By.cssSelector("[title^='"+title+"']"));
	}
	
	public String getUnidadeResponsavelAdicionada() {
		return dsl.obterTexto(By.xpath("//*[@id=\"UnidadesAdicionais\"]/tbody/tr/td[1]"));
	}

	public void clicarSalvar() {
		dsl.clicarBotaoXpath("//*[@id=\"formClassificar\"]/section/footer/button[2]");
	}
	
	public String getMensagemSucessoToast() {
		String s = null;
		s = dsl.obterTexto(By.className("toast-message"));
		return s;
	}
	
	public String getMensagemSucessoToast2() {
		String s = null;
		s = dsl.obterTexto(By.className("toast-success"));
		return s;
	}


	public void clicarAlterar() {
		dsl.clicarBotaoXpath("//*[@id=\"demandasTable\"]/tbody/tr[1]/td[3]/button\r\n");
	}
	
	public String getHeaderXpath() {
		return dsl.obterTexto(By.xpath("//*[@id='content']/section/section/section/section/div/div[1]/div/h1"));
	}

	public void clicarSalvarAlteracao() {
		dsl.clicarBotaoXpath("//*[@id=\"formClassificar\"]/section/footer/button");
	}
	
}


package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.DSL;

public class AnalisarDemandaDiretoriaPage {
	private DSL dsl;

	public AnalisarDemandaDiretoriaPage(WebDriver driver) {
		dsl = new DSL(driver);

	}

	public void clicarAin() {
		dsl.clicarBotaoXpath("//*[@id=\"nav\"]/section/section/div/nav/ul/li[1]/a");
		dsl.clicarBotaoXpath("//*[@id=\"nav\"]/section/section/div/nav/ul/li[1]/ul/li/a");
	}
	
	public void clicarUorg() {
		dsl.clicarBotaoXpath("//*[@id='nav']/section/section/div/nav/ul/li/a");
		dsl.clicarBotaoXpath("//*[@id='nav']/section/section/div/nav/ul/li/ul/li/a");
	}
	
	public void clicarDiretoriaPendente(){
		dsl.clicarBotaoXpath("//*[@id='nav']/section/section/div/nav/ul/li/a");
		dsl.clicarBotaoXpath("//*[@id='nav']/section/section/div/nav/ul/li/ul/li/a");
		dsl.selecionarCombo(("diretoresDropDown"), "Romeu Donizete Rufino");
	}
	

	public void clicarDiretoria() throws InterruptedException {
		dsl.clicarBotaoXpath("//*[@id=\"recomendacaoCheck\"]/div/div/div/div/div[3]/label/i");
	}
	
	public void clicarDeterminacao() throws InterruptedException {
		WebElement btn  = dsl.getDriver().findElement(By.xpath("//div[@class='radio i-checks radio-inline']//input"));
		JavascriptExecutor js=(JavascriptExecutor) dsl.getDriver();
		js.executeScript("arguments[0].click();", btn);
	}
	
	public void clicarDeterminacaoDiretoria() throws InterruptedException {
		WebElement btn  = dsl.getDriver().findElement(By.xpath("//div[@class='radio i-checks radio-inline']//input"));
		JavascriptExecutor js=(JavascriptExecutor) dsl.getDriver();
		js.executeScript("arguments[0].click();", btn);
	}


	public void clicarAnalisar() throws InterruptedException {
		dsl.clicarBotaoXpath("//*[@id=\"determinacaoDirCheck\"]/div[2]/div/div/div/div[2]/label/i");
	}

	public void clicarManifestacaoUorg() throws InterruptedException {
		dsl.clicarBotao(By.id("collapseOneId"));
	}
	
	public void clicarManifestacaoUorgPendente() throws InterruptedException {
		dsl.clicarBotao(By.id("collapseOneDiretoria"));
	}
	
	public void clicarManifestacaoDiretoriaPendente() throws InterruptedException {
		dsl.clicarBotaoXpath("//*[@id='collapseOneDiretoria']");
	}
	
	public void clicarManifestacaoDiretoria() throws InterruptedException {
		dsl.clicarBotao(By.id("LabelComManDiretoriaCount"));
	}

	public void clicarDemanda() throws InterruptedException {
		dsl.clicarBotaoXpath("//*[@id='tableAnalisarComManifestacaoUorg']/tbody/tr/td[1]/a");
	}
	
	public void clicarDemandaPendente() throws InterruptedException {
		dsl.clicarBotaoXpath("//*[@id='tableDemandaDiretoriaPendentesResposta']/tbody/tr/td[1]/a");
	}
	
	public void clicarDemandaDiretoriaPendente() throws InterruptedException {
		dsl.clicarBotaoXpath("//*[@id='pendenteManifestacaoDiretoriaTable']/tbody/tr[1]/td[1]/a");
	}
	
	public void clicarAnalisarResposta () throws InterruptedException {
		dsl.clicarBotaoXpath("//*[@id='btsDemanda']/a[2]");
	}
	
	public void informarAnaliseResposta(String resposta) throws InterruptedException {
		Thread.sleep(1000);
		dsl.escrever(By.xpath("//*[@id='txtRespostaDemandaDiv']/div/div[6]"), resposta);
	}
	
	public void informarResposta(String respostaDir) throws InterruptedException {
		Thread.sleep(1000);
		dsl.escrever(By.xpath("//*[@id='txtRespostaDemandaDiv']/div/div[6]"), respostaDir);
	}
	

	public void informarAnaliseAin(String analise) throws InterruptedException {
		Thread.sleep(1000);
		dsl.escrever(By.name("DscAnaliseDemanda"), analise );
	}
	
	public void clicarDemanda3() throws InterruptedException {
		dsl.clicarBotaoXpath("//*[@id='tableAnalisarComManifestacaoDiretoria']/tbody/tr/td[1]/a");
	}

	public void informarAnaliseAin3(String analise) throws InterruptedException {
		Thread.sleep(1000);
		dsl.escrever(By.name("DscAnaliseDemanda"), analise );
	}

	public void clicarDemandaSerTratada() throws InterruptedException {
		dsl.clicarRadioAtivo("Tratamento");
	}


	public void clicarSalvar() throws InterruptedException {
		dsl.clicarBotaoXpath("//*[@id=\"formAnalisar\"]/footer/button[2]");
		Thread.sleep(5000);
	}
	
	public void clicarSalvar2() throws InterruptedException {
		dsl.clicarBotaoXpath("//*[@id='content']/section/section/section/section/div/div[2]/div/div/div/section/footer[2]/button[2]");
		Thread.sleep(5000);
	}
	
	public void clicarSalvar3() throws InterruptedException {
		dsl.clicarBotaoXpath("//*[@id='formAnalisar']/footer/button[2]");
		Thread.sleep(5000);
	}
	
	public void clicarSalvar4() throws InterruptedException {
		dsl.clicarBotaoXpath("//*[@id='content']/section/section/section/section/div/div[2]/div/div[1]/div/section/footer[6]/button[2]");
		Thread.sleep(5000);
	}
	
	
	public void salvoComSucesso() throws InterruptedException {
		dsl.alertasToast(By.xpath("//*[@id='toast-container']/div/div"), "Dado(s) salvo(s) com sucesso.");
	}
	
	public void salvoComSucessoDir() throws InterruptedException{
		dsl.alertasToast(By.xpath("//*[@id='toast-container']/div"), "Dado(s) salvo(s) com sucesso.");
	}
	
	
	public void salvoUorg () throws InterruptedException{
		dsl.alertasToast(By.xpath("//*[@id='content']/section/section/section/section/div/div[2]/div/div[1]/div/section/article[2]/div/div[6]/div/p"), "Teste automatizado");
	}
	
	public void salvoDiretoria () throws InterruptedException{
		dsl.alertasToast(By.xpath("//*[@id='content']/section/section/section/section/div/div[2]/div/div[1]/div/section/article[3]/div/div[1]/div/p"), "Teste automatizado");
	}
	
	
	public void retornarUORG () throws InterruptedException{
		dsl.clicarBotao(By.id("btnRetornarUorg"));
	}
	
	public void retornoUORG () throws InterruptedException{
		dsl.alertasToast(By.xpath("//*[@id='toast-container']/div"), "Envio/Retorno enviado com sucesso.");
	}
	
	public void retornarDiretoria () throws InterruptedException{
		dsl.clicarBotao(By.id("btnRetornarDiretoria"));
	}
	
	
	
}

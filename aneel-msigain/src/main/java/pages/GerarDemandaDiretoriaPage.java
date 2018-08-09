package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import core.DSL;

public class GerarDemandaDiretoriaPage {
	private DSL dsl;

	public GerarDemandaDiretoriaPage(WebDriver driver) {
		dsl = new DSL(driver);

	}

	public void clicarGerarDemanda() {
		dsl.clicarBotao(By.id("btnGerarDemanda"));
	}
	
	public void clicarAin() {
		dsl.clicarBotaoXpath("//*[@id=\"nav\"]/section/section/div/nav/ul/li[1]/a");
		dsl.clicarBotaoXpath("//*[@id=\"nav\"]/section/section/div/nav/ul/li[1]/ul/li/a");
	}

	public void clicarDiretoria() throws InterruptedException {
		dsl.clicarBotaoXpath("//*[@id=\"recomendacaoCheck\"]/div/div/div/div/div[3]/label/i");
	}

	public void clicarAnalisar() throws InterruptedException {
		dsl.clicarBotaoXpath("//*[@id=\"determinacaoDirCheck\"]/div[2]/div/div/div/div[2]/label/i");
	}

	public void clicarManifestacaoUorg() throws InterruptedException {
		dsl.clicarBotaoXpath("//*[@id=\"collapseOneId\"]/b");
	}

	public void clicarDemanda() {
		dsl.clicarBotaoXpath("//*[@id=\"tableClassificar\"]/tbody/tr[1]/td[1]/a");
	}

	public void clicarClassificar() {
		dsl.clicarBotaoXpath("//*[@id=\"determinacaoDirCheck\"]/div[2]/div/div/div/div[1]/label/i");
	}

	public void clicarConfirmarGerarDemanda() {
		dsl.clicarBotao(By.className("btn-primary"));;

	}

	public String obterTextoByName(String string) {
		return dsl.obterTexto(By.tagName("h1"));
	}
	
	public String getMensagemSucessoToast() {
		String s = null;
		s = dsl.obterTexto(By.className("toast-message"));
		return s;
	}


}

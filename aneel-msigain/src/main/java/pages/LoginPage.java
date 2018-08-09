package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import core.DSL;

public class LoginPage {
	private DSL dsl;

	public LoginPage(WebDriver driver) {
		dsl = new DSL(driver);
	}

	public void fazerLogin() throws InterruptedException {
		dsl.escrever(By.name("Usuario"), "celiaines");
		dsl.clicarBotaoXpath("//*[@id=\"formLogin\"]/section/footer/button/i");
	}
	
	public String sistemaPresente(String sistema) throws InterruptedException {
		return dsl.obterTexto(sistema);
	}
	
	public void acessaSistema(String sistema) throws InterruptedException {
		dsl.clicarBotao(sistema);
	}
	
	public String sistemaAcessado() throws InterruptedException {
		return dsl.obterTexto("perfilLogado");
	}

	public String verificaTitulo() {
		String s = dsl.obterTexto(By.tagName("h1"));
		return s;
	}
}
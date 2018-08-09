package pages;

import org.openqa.selenium.WebDriver;

import core.DSL;

public class UtilPage {
	private DSL dsl;
	
	public UtilPage(WebDriver driver) {
		dsl = new DSL(driver);
	}
		
	public void mudarPerfil() {
		dsl.clicarBotaoXpath("/html/body/section/header/ul[1]/li[3]/a");
	}
	
	public void selecionarPerfilAdministrador() {
		dsl.clicarBotaoXpath("/html/body/section/header/ul[1]/li[3]/ul/li[3]/a");
	}
	
	public void selecionarPerfilSuperintendente() {
		dsl.clicarBotaoXpath("/html/body/section/header/ul[1]/li[3]/ul/li[1]/a");
	}
	
	public void selecionarPerfilDiretoria() {
		dsl.clicarBotaoXpath("/html/body/section/header/ul[1]/li[3]/ul/li[2]/a");
	}
}


package compras.page;

import compras.core.BasePage;

public class LoginPage extends BasePage{
	
	public void acessarSistema() {
		acessarUrl("https://www.saucedemo.com/");
	}

	public void dadosDoLogin(String usuario, String senha) {
		escrever("user-name", usuario);
		escrever("password", senha);
	}
	
	public void efetuarLogin() {
		  clicarBotao("login-button");
	}
}

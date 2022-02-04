package compras.page;

import compras.core.BasePage;

public class CarrinhoPage extends BasePage{
	
	public void clicarCheckout() {
		clicarBotao("checkout");
	}
	
	public String validarBotoaoRemove() {
		return obterTexto("remove-sauce-labs-backpack");
	}

}

package compras.page;

import compras.core.BasePage;

public class CheckoutPage extends BasePage{
	
	public void inserirDadosChackout(String nome, String sobreNome, String zipCode) {
		escrever("first-name", nome);
		escrever("last-name", sobreNome);
		escrever("postal-code", zipCode);
	}
	
	public void clicarEmContinue() {
		clicarBotao("continue");
	}
	
	public void clicarEmFinish() {
		clicarBotao("finish");
	}
	
	public String compraRealizada() {
	return	obterTextoXpath("//*[@id=\"checkout_complete_container\"]/h2");
		
		
	}
	
	public int camposCriticados() {
		return obterTamanhoXpath("//*[@data-icon='times-circle']");
	}
	 
	public void clicarEmCancel() {
		clicarBotao("cancel");
	}
	
}

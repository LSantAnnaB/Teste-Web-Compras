package compras.page;

import compras.core.BasePage;

public class ProdutosPage extends BasePage{

		public void quantidadeDeProdutos(int produtos) {
			selecionarProdutos(produtos);
		}
		
		public void cliciarCarrinho() {
			clicarBotao("shopping_cart_container");
		}
		
		public void selecionarFiltro() {
			selecionarCombo("//span[@class='select_container']//select", "Price (low to high)");
		}
		
		public void validarOrdemMenorpreco() {
			obterTextoXpath("//div[@class='inventory_item'][1]//div[@class='inventory_item_price']");
		}
		
		public String validarRetornoPagProducts() {
		return	obterTextoXpath("//span[@class='title']");
		}
}

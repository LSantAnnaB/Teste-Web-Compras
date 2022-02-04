package steps.definitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;



import compras.page.CarrinhoPage;
import compras.page.CheckoutPage;
import compras.page.LoginPage;
import compras.page.ProdutosPage;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class EfetuarCompras {

	LoginPage login = new LoginPage();
	ProdutosPage produtos = new ProdutosPage();
	CarrinhoPage carrinho = new CarrinhoPage();
	CheckoutPage checkout = new CheckoutPage();

	@Dado("^que eu efetue login com usuario standard$")
	public void queEuEfetueLoginComUsuarioStandard() throws Throwable {
		login.acessarSistema();
		Thread.sleep(1000);
		login.dadosDoLogin("standard_user", "secret_sauce");
		login.efetuarLogin();

	}

	@Quando("^eu adiciono os produtos ao carrinho$")
	public void euAdicionoOsProdutosAoCarrinho() throws Throwable {
		produtos.quantidadeDeProdutos(3);

	}

	@Quando("^clico no carrinho$")
	public void clicoNoCarrinho() throws Throwable {
		produtos.cliciarCarrinho();

	}

	@Quando("^realizo o checkout$")
	public void realizoOCheckout() throws Throwable {
		carrinho.clicarCheckout();

	}

	@Quando("^preencho os dados para checkout$")
	public void preenchoOsDadosParaCheckout() throws Throwable {
		checkout.inserirDadosChackout("Lucas", "SantAnna", "25900605");

	}

	@Quando("^clico em continue$")
	public void clicoEmContinue() throws Throwable {
		checkout.clicarEmContinue();

	}

	@Quando("^clico em finish$")
	public void clicoEmFinish() throws Throwable {
		checkout.clicarEmFinish();

	}

	@Entao("^o sistema exibe a menssagem de confirmacao de compra$")
	public void oSistemaExibeAMenssagemDeConfirmacaoDeCompra() throws Throwable {
		assertTrue("THANK YOU FOR YOUR ORDER".equals(checkout.compraRealizada()) );
		assertEquals("THANK YOU FOR YOUR ORDER", checkout.compraRealizada());
	}

	@Quando("^eu seleciono preco do mais baixo para mais alto$")
	public void euSelecionoPrecoDoMaisBaixoParaMaisAlto() throws Throwable {
		produtos.selecionarFiltro();

	}

	@Entao("^os produtos sao reordenados do mais baixo para mais alto$")
	public void osProdutosSaoReordenadosDoMaisBaixoParaMaisAlto() throws Throwable {
		produtos.validarOrdemMenorpreco();

	}

	@Entao("^vejo o botao remover para cada produto selecionado$")
	public void vejoOBotaoRemoverParaCadaProdutoSelecionado() {
		assertEquals("$7.99", carrinho.validarBotoaoRemove());
	}

	@Entao("^eu verifico que o sistema criticou os campos obrigatorios$")
	public void euVerificoQueOSistemaCriticouOsCamposObrigatorios() {
		assertEquals( 3 ,checkout.camposCriticados());

	}

	@Quando("^clico em cancel$")
	public void clicoEmCancel() throws Throwable {
		checkout.clicarEmCancel();

	}

	@Entao("^o sistema retorna para pagina de produtos$")
	public void oSistemaRetornaParaPaginaDeProdutos() {
		assertEquals("PRODUCTS", produtos.validarRetornoPagProducts());
	}

}

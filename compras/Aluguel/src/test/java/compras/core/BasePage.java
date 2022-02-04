package compras.core;



import static compras.core.DriverFactory.getDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

	/************* URL ************/

	public void acessarUrl(String url) {
		getDriver().get(url);
	}

	/********* TextField e TextArea ************/

	public void escrever(By by, String texto) {
		getDriver().findElement(by).clear();
		getDriver().findElement(by).sendKeys(texto);
	}

	public void escrever(String id_campo, String texto) {
		escrever(By.id(id_campo), texto);
	}

	public String obterValorCampo(String id_campo) {
		return getDriver().findElement(By.id(id_campo)).getAttribute("value");
	}

	/********* Botao ************/

	public void clicarBotao(String id) {
		getDriver().findElement(By.id(id)).click();
	}
	
	
/********* Textos ************/
	
	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}
	
	public String obterTexto(String id) {
		return obterTexto(By.id(id));
	}
	
	public String obterTextoXpath(By by) {
		return getDriver().findElement(by).getText();
	}
	public String obterTextoXpath(String xpath) {
		return obterTexto(By.xpath(xpath));
	}
	
	public int obterTamanhoXpath(By by) {
		return getDriver().findElements(by).size();
	}
	public int obterTamanhoXpath(String xpath) {
		return obterTamanhoXpath(By.xpath(xpath));
	}
	
	public void selecionarCombo(String xpath, String valor) {
		WebElement element = getDriver().findElement(By.xpath(xpath));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}
	
	
	
	public void selecionarProdutos(int qtdProdutos) {

		List<WebElement> produtos = getDriver().findElements(By.xpath("//div[@class='pricebar']//button"));

		int contador = 0;

		for (WebElement elemento : produtos) {
			elemento.click();
			contador++;
			if (contador == qtdProdutos) {
				break;
			}

		}
	}

}

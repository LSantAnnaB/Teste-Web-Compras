#language: pt
#enconding: UTF-8


Funcionalidade: Fazer a compra de 3 ou mais itens


	Cenario: Validar compras com mais de 3  itens 

	Dado  que eu efetue login com usuario standard
	Quando eu adiciono os produtos ao carrinho 
	E clico no carrinho
	E realizo o checkout 
	E preencho os dados para checkout
	E clico em continue
	E clico em finish
	Entao o sistema exibe a menssagem de confirmacao de compra
	
	Cenario: Validar por ordem de preco crescente

	Dado  que eu efetue login com usuario standard
	Quando eu seleciono preco do mais baixo para mais alto 
	Entao os produtos sao reordenados do mais baixo para mais alto
	
	Cenario: Validar botao remover para qualquer item do carrinho 

	Dado  que eu efetue login com usuario standard
	Quando eu adiciono os produtos ao carrinho 
	E clico no carrinho
	Entao vejo o botao remover para cada produto selecionado 
	
	Cenario: Validar campos obrigatorios

	Dado  que eu efetue login com usuario standard
	Quando eu adiciono os produtos ao carrinho 
	E clico no carrinho
	E realizo o checkout 
	E clico em continue
	Entao eu verifico que o sistema criticou os campos obrigatorios 
	
	Cenario: Validar cancelamento da compra antes de finalizar

	Dado que eu efetue login com usuario standard
	Quando eu adiciono os produtos ao carrinho 
	E clico no carrinho
	E realizo o checkout 
	E preencho os dados para checkout
	E clico em continue
	E clico em cancel
	Entao o sistema retorna para pagina de produtos
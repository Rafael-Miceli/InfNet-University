algoritmo "semnome"
// Função :
// Autor :
// Data : 11/06/2013
// Seção de Declarações 
var
   estado, categoria, tipo: inteiro
   titulo, descricao, validade: caracter
   precopromocional, precoantigo: real

inicio
// Seção de Comandos 

	estado <- 0
	categoria <- 0
	tipo <- 0

	escreval("Cadastrar promoção")
	escreval("Título")
	leia(titulo)
	escreval("Descrição")
	leia(descricao)
	escreval("Validade")
	leia(validade)
	
	enquanto (estado < 1) ou (estado > 4) faca
		escreval("Para selecionar um estado, digite o número ao lado do estado de sua escolha")
		escreval()	
		
		escreval("1 - RJ")
		escreval("2 - SP")
		escreval("3 - MG")
		escreval("4 - ES")
		
		leia(estado)
	fimenquanto	
	
	enquanto (categoria < 1) ou (categoria > 4) faca
		escreval("Para selecionar uma categoria, digite o número ao lado da categoria de sua escolha")
		escreval()	
		
		escreval("1 - Comida")
		escreval("2 - Eletrônicos")
		escreval("3 - Viagens")
		escreval("4 - Casa")
		
		leia(categoria)
	fimenquanto
	
	enquanto (tipo < 1) ou (tipo > 2) faca
		escreval("Para selecionar se a promoção é de destaque ou do dia, digite o número ao lado do tipo de sua escolha")
		escreval()	
		
		escreval("1 - Do dia")
		escreval("2 - Destaque")
		
		leia(tipo)
	fimenquanto
	
	
	
	
	escreval("Preço antigo")
	leia(precoantigo)
	escreval("Preço promocional")
	leia(precopromocional)
	
	escreval()
	escreval()
	escreval("Promoção cadastrada")	
	
	escreval("Título: ", titulo)
	escreval("Descrição: ", descricao)
	escreval("Validade: ", validade)
	
	escolha(estado)
   	caso 1
   	     	escreval("Estado: RJ")
   	caso 2
   	     	escreval("Estado: SP")
   	caso 3
   	     	escreval("Estado: MG")
   	caso 4
   	     	escreval("Estado: ES")
	fimescolha
	
	escolha(categoria)
   	caso 1
   	     	escreval("Categoria: Comida")
   	caso 2
   	     	escreval("Categoria: Eletrônicos")
   	caso 3
   	     	escreval("Categoria: Viagens")
   	caso 4
   	     	escreval("Categoria: Casa")
	fimescolha
	
	escolha(tipo)
   	caso 1
   	     	escreval("Tipo: Promoção do dia")
   	caso 2
   	     	escreval("Tipo: Promoção em destaque")
	fimescolha
	
	escreval("Preço antigo: R$", precoantigo)
	escreval("Preço promocional: R$", precopromocional)

fimalgoritmo

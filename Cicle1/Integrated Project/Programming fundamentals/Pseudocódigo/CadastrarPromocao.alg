algoritmo "semnome"
// Fun��o :
// Autor :
// Data : 11/06/2013
// Se��o de Declara��es 
var
   estado, categoria, tipo: inteiro
   titulo, descricao, validade: caracter
   precopromocional, precoantigo: real

inicio
// Se��o de Comandos 

	estado <- 0
	categoria <- 0
	tipo <- 0

	escreval("Cadastrar promo��o")
	escreval("T�tulo")
	leia(titulo)
	escreval("Descri��o")
	leia(descricao)
	escreval("Validade")
	leia(validade)
	
	enquanto (estado < 1) ou (estado > 4) faca
		escreval("Para selecionar um estado, digite o n�mero ao lado do estado de sua escolha")
		escreval()	
		
		escreval("1 - RJ")
		escreval("2 - SP")
		escreval("3 - MG")
		escreval("4 - ES")
		
		leia(estado)
	fimenquanto	
	
	enquanto (categoria < 1) ou (categoria > 4) faca
		escreval("Para selecionar uma categoria, digite o n�mero ao lado da categoria de sua escolha")
		escreval()	
		
		escreval("1 - Comida")
		escreval("2 - Eletr�nicos")
		escreval("3 - Viagens")
		escreval("4 - Casa")
		
		leia(categoria)
	fimenquanto
	
	enquanto (tipo < 1) ou (tipo > 2) faca
		escreval("Para selecionar se a promo��o � de destaque ou do dia, digite o n�mero ao lado do tipo de sua escolha")
		escreval()	
		
		escreval("1 - Do dia")
		escreval("2 - Destaque")
		
		leia(tipo)
	fimenquanto
	
	
	
	
	escreval("Pre�o antigo")
	leia(precoantigo)
	escreval("Pre�o promocional")
	leia(precopromocional)
	
	escreval()
	escreval()
	escreval("Promo��o cadastrada")	
	
	escreval("T�tulo: ", titulo)
	escreval("Descri��o: ", descricao)
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
   	     	escreval("Categoria: Eletr�nicos")
   	caso 3
   	     	escreval("Categoria: Viagens")
   	caso 4
   	     	escreval("Categoria: Casa")
	fimescolha
	
	escolha(tipo)
   	caso 1
   	     	escreval("Tipo: Promo��o do dia")
   	caso 2
   	     	escreval("Tipo: Promo��o em destaque")
	fimescolha
	
	escreval("Pre�o antigo: R$", precoantigo)
	escreval("Pre�o promocional: R$", precopromocional)

fimalgoritmo

algoritmo "semnome"
// Fun��o :
// Autor :
// Data : 11/06/2013
// Se��o de Declara��es 
var
	Cupons: vetor[1..4, 1..3] de caracter
	cupom, promocao: caractere
	
funcao BuscarCupom(cupom: caractere): caractere
var
   i: inteiro   
   promo: caractere
inicio
	i <- 1
	promo <- "nulo"
	
	repita
		se (cupom = Cupons[i, 1]) entao
			promo <- Cupons[i, 2]
		fimse		
		i <- i + 1
	ate (promo <> "nulo") ou (i > 4)

	retorne promo
fimfuncao

inicio
// Se��o de Comandos 

	//CarregarCupons()
	
	Cupons[1, 1] <- "123456"
	Cupons[1, 2] <- "Comida XPTO"
	
	Cupons[2, 1] <- "112233"
	Cupons[2, 2] <- "Viagem para Acapulco"
	
	Cupons[3, 1] <- "332211"
	Cupons[3, 2] <- "Xbox 360"
	
	Cupons[4, 1] <- "987654"
	Cupons[4, 2] <- "Pedra de Carv�o"
	
	//CarregarCupons()	
	
	
	escreval("Digite c�digo do cupom")
	leia(cupom)
		
	promocao <- BuscarCupom(cupom)
	
	escreval()	
	se (promocao <> "nulo") entao
		escreval("Cupom v�lido: ", promocao)
	senao
		escreval("Cupom inv�lido!")
	fimse
	
fimalgoritmo


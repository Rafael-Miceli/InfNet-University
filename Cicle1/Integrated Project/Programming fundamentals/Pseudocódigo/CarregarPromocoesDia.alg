algoritmo "semnome"
// Função :
// Autor :
// Data : 11/06/2013
// Seção de Declarações 
var
  Promocoes: vetor[1..6, 1..8] de caracter
  i, k, l: inteiro

inicio
// Seção de Comandos 

	//Promocoes <- CarregarPromocoes()
	
	para i de 1 ate 5 faca
        Promocoes[i, 1] <- "teste"
        Promocoes[i, 2] <- "teste"
        Promocoes[i, 3] <- "06/06/2013"
        Promocoes[i, 4] <- "1"
        Promocoes[i, 5] <- "2"
        Promocoes[i, 6] <- "2"
        Promocoes[i, 7] <- "500,00"
        Promocoes[i, 8] <- "399,99"
   fimpara
   
   Promocoes[6, 1] <- "teste"
   Promocoes[6, 2] <- "teste"
   Promocoes[6, 3] <- "14/06/2013"
   Promocoes[6, 4] <- "2"
   Promocoes[6, 5] <- "4"
   Promocoes[6, 6] <- "1"
   Promocoes[6, 7] <- "230,00"
   Promocoes[6, 8] <- "129,99"

	escreval("Promoção do dia")
	escreval()
	
	para k de 1 ate 6 faca
		se (Promocoes[k,6] = "1") entao		
			para l de 1 ate 8 faca
				escolha(l)
					caso 4
						escolha(Promocoes[k,l])
							caso "1"
								escreval("RJ")
							caso "2"
								escreval("SP")
							caso "3"
								escreval("MG")
							caso "4"
								escreval("ES")
						fimescolha
					caso 5
						escolha(Promocoes[k,l])
							caso "1"
								escreval("Comida")
							caso "2"
								escreval("Eletrônicos")
							caso "3"
								escreval("Viagens")
							caso "4"
								escreval("Casa")
						fimescolha
					caso 6
					outrocaso
						escreval(Promocoes[k,l])				
				fimescolha
			fimpara
			escreval()
			escreval()
		fimse
   fimpara
	
	//ExibirPromocoesEmDestaque(Promocoes)


fimalgoritmo

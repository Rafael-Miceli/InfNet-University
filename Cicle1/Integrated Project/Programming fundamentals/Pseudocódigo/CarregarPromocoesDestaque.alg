algoritmo "semnome"
// Função :
// Autor :
// Data : 11/06/2013
// Seção de Declarações 
var
   Promocoes: vetor[1..5, 1..8] de caracter
   i, k, l: inteiro

funcao CarregarPromocoes(): caracter
var
   i: inteiro
   promofunc: vetor[1..5, 1..8] de caracter
inicio
      para i de 1 ate 5 faca
           promofunc[i, 1] <- "teste"
           promofunc[i, 2] <- "teste"
           promofunc[i, 3] <- "06/06/2013"
           promofunc[i, 4] <- "RJ"
           promofunc[i, 5] <- "Eletrônico"
           promofunc[i, 6] <- "Destaque"
           promofunc[i, 7] <- "500,00"
           promofunc[i, 8] <- "399,99"
      fimpara
      
      retorne promofunc
fimfuncao


procedimento ExibirPromocoesEmDestaque(promoproc: caracter)
var
   k, l: inteiro
inicio
      para k de 1 ate 5 faca
           para l de 1 ate 8 faca
                escreval(promoproc[k,l]
           fimpara
      fimpara
fimprocedimento

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

	escreval("Promoções em destaque")
	escreval()
	
	para k de 1 ate 5 faca
		se (Promocoes[k,6] = "2") entao		
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

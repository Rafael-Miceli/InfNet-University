algoritmo "semnome"
// Fun��o :
// Autor :
// Data : 11/06/2013
// Se��o de Declara��es 
var
  Promocoes, PromocoesAchadas: vetor[1..6, 1..8] de caracter
  i, k, l, m, n: inteiro
  achou: logico
  busca: caractere

inicio
// Se��o de Comandos 
	
	//CarregarPromocoes()
	
	para i de 1 ate 4 faca
		Promocoes[i, 1] <- "teste"
		Promocoes[i, 2] <- "teste"
		Promocoes[i, 3] <- "06/06/2013"
		Promocoes[i, 4] <- "1"
		Promocoes[i, 5] <- "2"
		Promocoes[i, 6] <- "2"
		Promocoes[i, 7] <- "500,00"
		Promocoes[i, 8] <- "399,99"
	fimpara

	Promocoes[6, 1] <- "teste2"
	Promocoes[6, 2] <- "teste achado"
	Promocoes[6, 3] <- "14/06/2013"
	Promocoes[6, 4] <- "1"
	Promocoes[6, 5] <- "3"
	Promocoes[6, 6] <- "1"
	Promocoes[6, 7] <- "230,00"
	Promocoes[6, 8] <- "129,99"
	
	Promocoes[5, 1] <- "teste2"
	Promocoes[5, 2] <- "teste achado 2"
	Promocoes[5, 3] <- "14/06/2013"
	Promocoes[5, 4] <- "2"
	Promocoes[5, 5] <- "4"
	Promocoes[5, 6] <- "2"
	Promocoes[5, 7] <- "230,00"
	Promocoes[5, 8] <- "129,99"
	
	//CarregarPromocoes()
	

	escreval("Promo��es por busca")
	escreval("O que voc� busca?")
	leia(busca)
	
	
	l <- 1
	//ExibirPromocoesPorBusca(busca)	
	para i de 1 ate 6 faca
		se (busca = Promocoes[i, 1]) entao
		   achou <- verdadeiro
			para k de 1 ate 8 faca
			   PromocoesAchadas[l, k] <- Promocoes[i, k]
         fimpara
			l <- l + 1
		fimse
	fimpara
	
	// Verifica se achou ou nao
	escreval()
	escreval()
	se achou entao
	   escreval("Promo��es Achadas:")
	   escreval()
		para m de 1 ate l faca
			para n de 1 ate 8 faca 
				escolha(n)
					caso 4
						escolha(PromocoesAchadas[m, n])
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
						escolha(PromocoesAchadas[m, n])
							caso "1"
								escreval("Comida")
							caso "2"
								escreval("Eletr�nicos")
							caso "3"
								escreval("Viagens")
							caso "4"
								escreval("Casa")
						fimescolha
					caso 6
						escolha(PromocoesAchadas[m, n])
							caso "1"
								escreval("Promo��o do dia")
							caso "2"
								escreval("Promo��o em destaque")
						fimescolha
					outrocaso
						escreval(PromocoesAchadas[m, n])				
				fimescolha
			fimpara
			escreval()
			escreval()
		fimpara	    
	senao
	    escreval("Nao achou promo��es na busca")
	fimse

fimalgoritmo

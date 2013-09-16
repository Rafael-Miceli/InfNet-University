algoritmo "semnome"
// Função :
// Autor :
// Data : 11/06/2013
// Seção de Declarações 
var
  Promocoes: vetor[1..6, 1..8] de caracter
  i, produto: inteiro


inicio
// Seção de Comandos 

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
	
	escreval("Selecione o produto que vc deseja comprar digitando o número referente a ele")
	escreval()
	
	para i de 1 ate 6 faca
		escreval(i, " - ", Promocoes[i, 1])
		escreval("Descrição: ", Promocoes[i, 2])
		escreval("Válido até: ", Promocoes[i, 3])
		escreval("Estado: ", Promocoes[i, 4])
		escreval("Categoria: ", Promocoes[i, 5])
		escreval("Preço antigo: ", Promocoes[i, 7])
		escreval("Preço promocional: ", Promocoes[i, 8])
		escreval()
	fimpara
	
	leia(produto)
	
	//ComprarProduto(produto)
	se (produto > 0) e (produto < 7) entao
		escreval("Produto: ", Promocoes[produto, 1], " comprado")
	senao
		escreval("Este produto não está no catálogo")
	fimse

fimalgoritmo

algoritmo "Exercicio1"
// Fun��o :
// Autor :
// Data : 27/04/2013
// Se��o de Declara��es 
var
   n1, n2, trocadorN1: inteiro
   
PROCEDIMENTO TrocaVariavel()
var
inicio
      trocadorN1 <- n1
      n1 <- n2
      n2 <- trocadorN1
FIMPROCEDIMENTO
   
inicio
      leia(n1)
      leia(n2)
      TrocaVariavel()
      escreval("n1 = ", n1)
      escreva("n2 = ", n2)

fimalgoritmo

algoritmo "Exercicio1"
// Função :
// Autor :
// Data : 27/04/2013
// Seção de Declarações 
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

algoritmo "semnome"
// Fun��o :
// Autor :
// Data : 19/05/2013
// Se��o de Declara��es 
var
  soma, i, numero, numeroMaior, numeroMenor: inteiro
inicio
// Se��o de Comandos 
   i <- 0
   soma <- 0

   escreval("Escreva 1 numero")
   leia(numero)
   
   numeroMaior <- numero
   numeroMenor <- numero
   soma <- soma + numero

   para i de 1 ate 19 faca
       escreval("Escreva 1 numero")
       leia(numero)
       
       se numeroMaior <= numero entao
          numeroMaior <- numero
       fimse
       
       se numeroMenor >= numero entao
          numeroMenor <- numero
       fimse
       
       soma <- soma + numero
       
   fimpara
   
   escreval("Soma dos n�mero dos 20 n�meros ", soma)
   escreval("M�dia dos n�mero ", soma / 20)
   escreval("Maior n�mero ", numeroMaior)
   escreval("Menor n�mero ", numeroMenor)
fimalgoritmo

algoritmo "semnome"
// Função :
// Autor :
// Data : 19/05/2013
// Seção de Declarações 
var
  soma, i, numero, numeroMaior, numeroMenor: inteiro
inicio
// Seção de Comandos 
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
   
   escreval("Soma dos número dos 20 números ", soma)
   escreval("Média dos número ", soma / 20)
   escreval("Maior número ", numeroMaior)
   escreval("Menor número ", numeroMenor)
fimalgoritmo

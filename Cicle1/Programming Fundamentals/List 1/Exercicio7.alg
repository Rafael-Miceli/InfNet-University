algoritmo "semnome"
// Fun��o :
// Autor :
// Data : 27/04/2013
// Se��o de Declara��es 
var
   altura, base, area: real
   
PROCEDIMENTO CalculaArea(altura, base: real)
var
inicio

      area <- altura * base

FIMPROCEDIMENTO

inicio
// Se��o de Comandos 
   escreval("Digite o comprimento da altura.")
   leia(altura)
   escreval("Digite o comprimento da base.")
   leia(base)
   CalculaArea(altura, base)
   escreval("A �rea do ret�ngulo �:", area)

fimalgoritmo

algoritmo "semnome"
// Função :
// Autor :
// Data : 27/04/2013
// Seção de Declarações 
var
   altura, base, area: real
   
PROCEDIMENTO CalculaArea(altura, base: real)
var
inicio

      area <- altura * base

FIMPROCEDIMENTO

inicio
// Seção de Comandos 
   escreval("Digite o comprimento da altura.")
   leia(altura)
   escreval("Digite o comprimento da base.")
   leia(base)
   CalculaArea(altura, base)
   escreval("A área do retângulo é:", area)

fimalgoritmo

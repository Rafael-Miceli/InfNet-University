algoritmo "semnome"
// Fun��o :
// Autor :
// Data : 27/04/2013
// Se��o de Declara��es 
var
   raio, area: real
   
PROCEDIMENTO CalculaArea(raio: real)
var
inicio

      area <- 4 * PI * (raio * raio)

FIMPROCEDIMENTO

inicio
// Se��o de Comandos
   escreval("Digite o comprimento da raio.")
   leia(raio)
   CalculaArea(raio)
   escreval("A �rea da esfera �:", area)

fimalgoritmo

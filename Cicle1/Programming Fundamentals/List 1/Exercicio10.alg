algoritmo "semnome"
// Fun��o :
// Autor :
// Data : 27/04/2013
// Se��o de Declara��es 
var
   altura, raio, area: real
   
PROCEDIMENTO CalculaArea(altura, raio: real)
var
inicio

      area <- altura * PI * (raio * raio)

FIMPROCEDIMENTO

inicio
// Se��o de Comandos
   escreval("Digite o comprimento da altura.")
   leia(altura)
   escreval("Digite o comprimento da raio.")
   leia(raio)
   CalculaArea(altura, raio)
   escreval("A �rea do cilindro �:", area)

fimalgoritmo

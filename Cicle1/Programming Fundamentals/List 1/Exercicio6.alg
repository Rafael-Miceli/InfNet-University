algoritmo "semnome"
// Fun��o :
// Autor :
// Data : 27/04/2013
// Se��o de Declara��es 
var
   lado, area: real
   
PROCEDIMENTO CalculaArea(lado: real)
var
inicio

      area <- lado * lado

FIMPROCEDIMENTO

inicio
// Se��o de Comandos 
   escreval("Digite o comprimento do lado.")
   leia(lado)
   CalculaArea(lado)
   escreval("A �rea do quadrado �: ", area)

fimalgoritmo

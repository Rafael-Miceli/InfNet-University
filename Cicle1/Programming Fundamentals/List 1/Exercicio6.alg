algoritmo "semnome"
// Função :
// Autor :
// Data : 27/04/2013
// Seção de Declarações 
var
   lado, area: real
   
PROCEDIMENTO CalculaArea(lado: real)
var
inicio

      area <- lado * lado

FIMPROCEDIMENTO

inicio
// Seção de Comandos 
   escreval("Digite o comprimento do lado.")
   leia(lado)
   CalculaArea(lado)
   escreval("A área do quadrado é: ", area)

fimalgoritmo

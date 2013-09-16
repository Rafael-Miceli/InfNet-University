algoritmo "semnome"
// Função :
// Autor :
// Data : 27/04/2013
// Seção de Declarações 
var
   raio, area: real
   
PROCEDIMENTO CalculaArea(raio: real)
var
inicio

      area <- PI * (raio * raio)

FIMPROCEDIMENTO

inicio
// Seção de Comandos
   escreval("Digite o comprimento da raio.")
   leia(raio)
   CalculaArea(raio)
   escreval("A área do círculo é:", area)

fimalgoritmo

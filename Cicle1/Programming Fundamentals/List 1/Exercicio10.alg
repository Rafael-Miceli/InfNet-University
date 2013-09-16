algoritmo "semnome"
// Função :
// Autor :
// Data : 27/04/2013
// Seção de Declarações 
var
   altura, raio, area: real
   
PROCEDIMENTO CalculaArea(altura, raio: real)
var
inicio

      area <- altura * PI * (raio * raio)

FIMPROCEDIMENTO

inicio
// Seção de Comandos
   escreval("Digite o comprimento da altura.")
   leia(altura)
   escreval("Digite o comprimento da raio.")
   leia(raio)
   CalculaArea(altura, raio)
   escreval("A área do cilindro é:", area)

fimalgoritmo

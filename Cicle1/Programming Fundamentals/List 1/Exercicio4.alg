algoritmo "semnome"
// Fun��o :
// Autor :
// Data : 27/04/2013
// Se��o de Declara��es 
var
   conta, gorjeta: real
   
PROCEDIMENTO CalcularGorjeta(conta: real)
var
inicio

      gorjeta <- conta / 100

FIMPROCEDIMENTO
inicio
// Se��o de Comandos 
   escreval("Digite o valor da conta.")
   leia(conta)
   CalcularGorjeta(conta)
   escreval("O valor da gorjeta a pagar � de: ", gorjeta)
fimalgoritmo

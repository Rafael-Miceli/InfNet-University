algoritmo "semnome"
// Função :
// Autor :
// Data : 27/04/2013
// Seção de Declarações 
var
   conta, gorjeta: real
   
PROCEDIMENTO CalcularGorjeta(conta: real)
var
inicio

      gorjeta <- conta / 100

FIMPROCEDIMENTO
inicio
// Seção de Comandos 
   escreval("Digite o valor da conta.")
   leia(conta)
   CalcularGorjeta(conta)
   escreval("O valor da gorjeta a pagar é de: ", gorjeta)
fimalgoritmo

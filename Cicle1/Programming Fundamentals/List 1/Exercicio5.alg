algoritmo "semnome"
// Fun��o :
// Autor :
// Data : 27/04/2013
// Se��o de Declara��es 
var
   salario, reajuste, salarioposreajuste: real
FUNCAO CalculaReajuste(salario, reajuste: real):real
var
inicio

      retorne salario + ((salario * reajuste)/100)

FIMFUNCAO
   
inicio
// Se��o de Comandos 
   escreval("Digite o valor do sal�rio.")
   leia(salario)
   escreval("Digite o valor percentual do reajuste")
   leia(reajuste)
   
   salarioposreajuste <- CalculaReajuste(salario, reajuste)
   
   escreval("Seu novo sal�rio �: ", salarioposreajuste)
   
fimalgoritmo

algoritmo "semnome"
// Função :
// Autor :
// Data : 27/04/2013
// Seção de Declarações 
var
   salario, reajuste, salarioposreajuste: real
FUNCAO CalculaReajuste(salario, reajuste: real):real
var
inicio

      retorne salario + ((salario * reajuste)/100)

FIMFUNCAO
   
inicio
// Seção de Comandos 
   escreval("Digite o valor do salário.")
   leia(salario)
   escreval("Digite o valor percentual do reajuste")
   leia(reajuste)
   
   salarioposreajuste <- CalculaReajuste(salario, reajuste)
   
   escreval("Seu novo salário é: ", salarioposreajuste)
   
fimalgoritmo

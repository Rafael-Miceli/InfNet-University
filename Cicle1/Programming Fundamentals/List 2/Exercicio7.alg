algoritmo "semnome"
// Fun��o :
// Autor :
// Data : 27/04/2013
// Se��o de Declara��es 
var
   salario, novosalario: real

FUNCAO CalculaSalario(salario: real):real
var
inicio

      se(salario <= 1000) entao
          retorne salario + (salario * 30 / 100)
      fimse
      se(salario > 1000) e (salario <= 2000) entao
          retorne salario + (salario * 25 / 100)
      fimse
      se(salario > 2000) e (salario <= 3000) entao
          retorne salario + (salario * 20 / 100)
      fimse
      se(salario > 3000) e (salario <= 4000) entao
          retorne salario + (salario * 15 / 100)
      fimse
      se(salario > 4000) entao
          retorne salario + (salario * 10 / 100)
      fimse
      
FIMFUNCAO
   
inicio
// Se��o de Comandos
   escreval("Digite o sal�rio")
   leia(salario)
   
   novosalario <- CalculaSalario(salario)
   
   escreval("Seu novo sal�rio � de:", novosalario)

fimalgoritmo

algoritmo "semnome"
// Fun��o :
// Autor :
// Data : 27/04/2013
// Se��o de Declara��es 
var
   nota1, nota2: inteiro
   media: real
   
FUNCAO CalculaMedia(nota1, nota2: inteiro):real
var
inicio

   retorne (nota1 + nota2) /2
   
FIMFUNCAO

inicio
// Se��o de Comandos 
   escreval("Digite a sua primeira nota mais sua segunda nota respectivamente.")
   leia(nota1)
   leia(nota2)
   media <- CalculaMedia(nota1, nota2)
   escreval("Sua m�dia �: ", media)

fimalgoritmo

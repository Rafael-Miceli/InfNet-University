algoritmo "semnome"
// Fun��o :
// Autor :
// Data : 27/04/2013
// Se��o de Declara��es 
var
   char: caracter
inicio
// Se��o de Comandos
   escreval("Digite uma letra qualquer")
   leia(char)
   
   escolha(char)
   caso "a", "A", "e", "E", "i", "I", "o", "O", "u", "U"
        escreval("'", char, "' � uma vogal")
   outrocaso
        escreval("'", char, "' � uma consoante")
   fimescolha

fimalgoritmo

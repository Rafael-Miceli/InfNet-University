algoritmo "semnome"
// Função :
// Autor :
// Data : 27/04/2013
// Seção de Declarações 
var
   char: caracter
inicio
// Seção de Comandos
   escreval("Digite uma letra qualquer")
   leia(char)
   
   escolha(char)
   caso "a", "A", "e", "E", "i", "I", "o", "O", "u", "U"
        escreval("'", char, "' é uma vogal")
   outrocaso
        escreval("'", char, "' é uma consoante")
   fimescolha

fimalgoritmo

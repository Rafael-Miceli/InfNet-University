algoritmo "semnome"
// Fun��o :
// Autor :
// Data : 19/05/2013
// Se��o de Declara��es 
var
  char: caractere
  vogais, fim: inteiro
  
inicio
// Se��o de Comandos 
   fim <- 0

   repita
       escreval("Digite um caracter, digite '.' para terminar a execu��o")
       leia(char)
       
       se (char = ".") entao
           fim <- 1
       senao
           escolha(char)
           caso "a", "A", "e", "E", "i", "I", "o", "O", "u", "U"
               vogais <- vogais + 1
           outrocaso

           fimescolha
       fimse
   ate fim > 0
   
   escreval("Voc� digitou ", vogais, " vogais")


fimalgoritmo

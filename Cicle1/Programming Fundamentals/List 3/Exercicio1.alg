algoritmo "semnome"
// Função :
// Autor :
// Data : 19/05/2013
// Seção de Declarações 
var
  char: caractere
  vogais, fim: inteiro
  
inicio
// Seção de Comandos 
   fim <- 0

   repita
       escreval("Digite um caracter, digite '.' para terminar a execução")
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
   
   escreval("Você digitou ", vogais, " vogais")


fimalgoritmo

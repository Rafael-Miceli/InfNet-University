algoritmo "semnome"
// Fun��o :
// Autor :
// Data : 27/04/2013
// Se��o de Declara��es 
var
   numero: inteiro
inicio
// Se��o de Comandos

  escreval("Digite o primeiro octeto.")

  leia(numero)
  
  se (numero >= 0) e (numero <= 127) entao
     escreval("Sua classe �: A")
  senao
     se (numero >= 128) e (numero <= 191) entao
        escreval("Sua classe �: B")
     senao
        se (numero >= 192) e (numero <= 223) entao
           escreval("Sua classe �: C")
        senao
             se (numero >= 224) e (numero <= 239) entao
                escreval("Sua classe �: D")
             senao
                  se (numero >= 240) entao
                     escreval("Sua classe �: E")
                  fimse
             fimse
        fimse
     fimse
  fimse
  
fimalgoritmo

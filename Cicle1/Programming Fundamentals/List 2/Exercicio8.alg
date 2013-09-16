algoritmo "semnome"
// Função :
// Autor :
// Data : 27/04/2013
// Seção de Declarações 
var
   numero: inteiro
inicio
// Seção de Comandos

  escreval("Digite o primeiro octeto.")

  leia(numero)
  
  se (numero >= 0) e (numero <= 127) entao
     escreval("Sua classe é: A")
  senao
     se (numero >= 128) e (numero <= 191) entao
        escreval("Sua classe é: B")
     senao
        se (numero >= 192) e (numero <= 223) entao
           escreval("Sua classe é: C")
        senao
             se (numero >= 224) e (numero <= 239) entao
                escreval("Sua classe é: D")
             senao
                  se (numero >= 240) entao
                     escreval("Sua classe é: E")
                  fimse
             fimse
        fimse
     fimse
  fimse
  
fimalgoritmo

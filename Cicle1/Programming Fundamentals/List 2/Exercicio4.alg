algoritmo "semnome"
// Função :
// Autor :
// Data : 27/04/2013
// Seção de Declarações 
var
   numero, numeroMaior, numero2, numero3: inteiro
inicio
// Seção de Comandos
  numeroMaior <- 0

  escreval("Digite três números respectivamente.")

  leia(numero)
  leia(numero2)
  leia(numero3)
  
  se (numero > numero2) e (numero > numero3) entao
     numeroMaior <- numero
  senao
     se (numero2 > numero) e (numero2 > numero3) entao
        numeroMaior <- numero2
     senao
        se (numero3 > numero2) e (numero3 > numero) entao
           numeroMaior <- numero3
        fimse
     fimse
  fimse
  
  Escreval("Maior número é:", numeroMaior)
fimalgoritmo

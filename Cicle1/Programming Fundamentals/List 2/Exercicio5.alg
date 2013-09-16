algoritmo "semnome"
// Função :
// Autor :
// Data : 27/04/2013
// Seção de Declarações 
var
   numero, numero2, numero3, numeroMaior, numeroMenor, numeroMedio: inteiro
inicio
// Seção de Comandos

   escreval("Digite três números.")
   
   leia(numero)
   leia(numero2)
   leia(numero3)

   se (numero >= numero2) e (numero >= numero3) entao
     numeroMaior <- numero
   senao
     se (numero2 >= numero) e (numero2 >= numero3) entao
        numeroMaior <- numero2
     senao
        se (numero3 >= numero2) e (numero3 >= numero) entao
           numeroMaior <- numero3
        fimse
     fimse
   fimse
  
   se (numero <= numero2) e (numero <= numero3) entao
     numeroMenor <- numero
   senao
     se (numero2 <= numero) e (numero2 <= numero3) entao
        numeroMenor <- numero2
     senao
        se (numero3 <= numero2) e (numero3 <= numero) entao
           numeroMenor <- numero3
        fimse
     fimse
   fimse

   se ((numeroMaior = numero) ou (numeroMaior = numero2)) e ((numeroMenor = numero) ou (numeroMenor = numero2)) entao
     numeroMedio <- numero3
   senao
     se ((numeroMaior = numero) ou (numeroMaior = numero3)) e ((numeroMenor = numero) ou (numeroMenor = numero3)) entao
       numeroMedio <- numero2
     senao
       se ((numeroMaior = numero2) ou (numeroMaior = numero3)) e ((numeroMenor = numero2) ou (numeroMenor = numero3)) entao
         numeroMedio <- numero
       fimse
     fimse
   fimse

  escreval("Números em ordem crescente: ", numeroMenor, " ", numeroMedio, " ", numeroMaior)
fimalgoritmo

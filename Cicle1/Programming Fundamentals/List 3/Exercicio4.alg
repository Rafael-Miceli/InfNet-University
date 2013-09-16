algoritmo "semnome"
// Função :
// Autor :
// Data : 19/05/2013
// Seção de Declarações 
var
  soma, i, numero, numeroMaior, numeroMenor, quantidade: inteiro
inicio
// Seção de Comandos 
   i <- 0
   soma <- 0

   escreval("Selecione quantos números você quer digitar")
   leia(quantidade)
   
   se quantidade > 0 entao
   
      escreval("Escreva um numero")
      leia(numero)

      numeroMaior <- numero
      numeroMenor <- numero
      soma <- soma + numero

      i <- i + 1

      enquanto (i < quantidade) faca
          escreval("Escreva um numero")
          leia(numero)

          se numeroMaior <= numero entao
             numeroMaior <- numero
          fimse

          se numeroMenor >= numero entao
             numeroMenor <- numero
          fimse

          soma <- soma + numero

          i <- i + 1

      fimenquanto
   
      escreval("Soma dos número dos números ", soma)
      escreval("Média dos número ", soma / 20)
      escreval("Maior número ", numeroMaior)
      escreval("Menor número ", numeroMenor)
   senao
      escreval("Você escolheu não digitar nenhum numero")
   fimse
      
fimalgoritmo

algoritmo "semnome"
// Fun��o :
// Autor :
// Data : 19/05/2013
// Se��o de Declara��es 
var
  soma, i, numero, numeroMaior, numeroMenor, quantidade: inteiro
inicio
// Se��o de Comandos 
   i <- 0
   soma <- 0

   escreval("Selecione quantos n�meros voc� quer digitar")
   leia(quantidade)
   
   se quantidade > 0 entao
   
      escreval("Escreva um numero")
      leia(numero)

      enquanto (numero % 10 = 0) faca
         escreval("Digite um n�mero que termine com zero")
      fimenquanto

      numeroMaior <- numero
      numeroMenor <- numero
      soma <- soma + numero

      i <- i + 1

      enquanto (i <= quantidade) faca
          escreval("Escreva um numero")
          leia(numero)
          
          enquanto (numero % 10 = 0) faca
             escreval("Digite um n�mero que termine com zero")
          fimenquanto

          se numeroMaior <= numero entao
             numeroMaior <- numero
          fimse

          se numeroMenor >= numero entao
             numeroMenor <- numero
          fimse

          soma <- soma + numero

          i <- i + 1

      fimenquanto

      escreval("Soma dos n�mero dos 20 n�meros ", soma)
      escreval("M�dia dos n�mero ", soma / 20)
      escreval("Maior n�mero ", numeroMaior)
      escreval("Menor n�mero ", numeroMenor)
   senao
      escreval("Voc� escolheu n�o digitar nenhum numero")
   fimse
fimalgoritmo

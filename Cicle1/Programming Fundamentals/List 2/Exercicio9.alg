algoritmo "semnome"
// Fun��o :
// Autor :
// Data : 27/04/2013
// Se��o de Declara��es 
var
   mes: inteiro
   nomeMes: caractere

FUNCAO RetornaMes(mes: inteiro):caractere
var
inicio

      escolha mes
      
      caso 1
           retorne "Janeiro"
      caso 2
           retorne "Fevereiro"
      caso 3
           retorne "Mar�o"
      caso 4
           retorne "Abril"
      caso 5
           retorne "Maio"
      caso 6
           retorne "Junho"
      caso 7
           retorne "Julho"
      caso 8
           retorne "Agosto"
      caso 9
           retorne "Setembro"
      caso 10
           retorne "Outubro"
      caso 11
           retorne "Novembro"
      caso 12
           retorne "Dezembro"
      outrocaso
           retorne "M�s inv�lido"
      fimescolha
      
FIMFUNCAO
   
inicio
// Se��o de Comandos
   escreval("Digite um n�mero correpondente a um m�s")
   leia(mes)
   
   nomeMes <- RetornaMes(mes)
   
   escreval("Voc� selecionou o m�s de: ", nomeMes)

fimalgoritmo

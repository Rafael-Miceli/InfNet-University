algoritmo "semnome"
// Função :
// Autor :
// Data : 27/04/2013
// Seção de Declarações 
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
           retorne "Março"
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
           retorne "Mês inválido"
      fimescolha
      
FIMFUNCAO
   
inicio
// Seção de Comandos
   escreval("Digite um número correpondente a um mês")
   leia(mes)
   
   nomeMes <- RetornaMes(mes)
   
   escreval("Você selecionou o mês de: ", nomeMes)

fimalgoritmo

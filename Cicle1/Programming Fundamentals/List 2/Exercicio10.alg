algoritmo "semnome"
// Fun��o :
// Autor :
// Data : 27/04/2013
// Se��o de Declara��es 
var
   data: caractere

FUNCAO DataValida(data: caractere):logico
var
t1, t2, t3, t4  : inteiro
inicio
      //01/01/2013
      retorne falso

     //M�s igual a fevereiro
     se (Asc(copia(data,4, 4)) = 48) e (Asc(copia(data,5, 5)) = 50) entao
        se (Asc(copia(data, 1, 1)) >= 48) e (Asc(copia(data, 1, 1)) <= 50) entao
           se (Asc(copia(data, 2, 2)) >= 48) e (Asc(copia(data, 2, 2)) <= 57) entao
              se (Asc(copia(data, 10, 10)) >= 48) e (Asc(copia(data, 10, 10)) <= 57) e (Asc(copia(data, 7, 7)) >= 48) e (Asc(copia(data, 7, 7)) <= 57) e (Asc(copia(data, 8, 8)) >= 48) e (Asc(copia(data, 8, 8)) <= 57) e (Asc(copia(data, 9, 9)) >= 48) e (Asc(copia(data, 9, 9)) <= 57) entao
                 retorne verdadeiro
              fimse
           fimse
        fimse
     fimse

     //M�s igual a 01, 03, 05, 07, 08
     se (Asc(copia(data,4, 4)) = 48) e ((Asc(copia(data,5, 5)) = 49) ou (Asc(copia(data,5, 5)) = 51) ou (Asc(copia(data,5, 5)) = 53) ou (Asc(copia(data,5, 5)) = 56) ou (Asc(copia(data,5, 5)) = 55)) entao
        se (Asc(copia(data, 1, 1)) >= 48) e (Asc(copia(data, 1, 1)) <= 50) entao
           se (Asc(copia(data, 2, 2)) >= 48) e (Asc(copia(data, 2, 2)) <= 57) entao
              se (Asc(copia(data, 10, 10)) >= 48) e (Asc(copia(data, 10, 10)) <= 57) e (Asc(copia(data, 7, 7)) >= 48) e (Asc(copia(data, 7, 7)) <= 57) e (Asc(copia(data, 8, 8)) >= 48) e (Asc(copia(data, 8, 8)) <= 57) e (Asc(copia(data, 9, 9)) >= 48) e (Asc(copia(data, 9, 9)) <= 57) entao
                 retorne verdadeiro
              fimse
           fimse
        fimse

        se (Asc(copia(data, 1, 1)) = 51) entao
           se (Asc(copia(data, 2, 2)) >= 48) e (Asc(copia(data, 2, 2)) <= 49) entao
              se (Asc(copia(data, 10, 10)) >= 48) e (Asc(copia(data, 10, 10)) <= 57) e (Asc(copia(data, 7, 7)) >= 48) e (Asc(copia(data, 7, 7)) <= 57) e (Asc(copia(data, 8, 8)) >= 48) e (Asc(copia(data, 8, 8)) <= 57) e (Asc(copia(data, 9, 9)) >= 48) e (Asc(copia(data, 9, 9)) <= 57) entao
                 retorne verdadeiro
              fimse
           fimse
        fimse

     fimse

     //M�s igual a 04, 06, 09
     se (Asc(copia(data,4, 4)) = 48) e ((Asc(copia(data,5, 5)) = 52) ou (Asc(copia(data,5, 5)) = 54) ou (Asc(copia(data,5, 5)) = 57)) entao

        se (Asc(copia(data, 1, 1)) >= 48) e (Asc(copia(data, 1, 1)) <= 50) entao
           se (Asc(copia(data, 2, 2)) >= 48) e (Asc(copia(data, 2, 2)) <= 57) entao
              se (Asc(copia(data, 10, 10)) >= 48) e (Asc(copia(data, 10, 10)) <= 57) e (Asc(copia(data, 7, 7)) >= 48) e (Asc(copia(data, 7, 7)) <= 57) e (Asc(copia(data, 8, 8)) >= 48) e (Asc(copia(data, 8, 8)) <= 57) e (Asc(copia(data, 9, 9)) >= 48) e (Asc(copia(data, 9, 9)) <= 57) entao
                 retorne verdadeiro
              fimse
           fimse
        fimse

        se (Asc(copia(data, 1, 1)) = 51) entao
           se (Asc(copia(data, 2, 2)) = 48) entao
              se (Asc(copia(data, 10, 10)) >= 48) e (Asc(copia(data, 10, 10)) <= 57) e (Asc(copia(data, 7, 7)) >= 48) e (Asc(copia(data, 7, 7)) <= 57) e (Asc(copia(data, 8, 8)) >= 48) e (Asc(copia(data, 8, 8)) <= 57) e (Asc(copia(data, 9, 9)) >= 48) e (Asc(copia(data, 9, 9)) <= 57) entao
                 retorne verdadeiro
              fimse
           fimse
        fimse

     fimse
     
     //M�s igual a 10 e 12
     se (Asc(copia(data,4, 4)) = 49) e ((Asc(copia(data,5, 5)) = 48) ou (Asc(copia(data,5, 5)) = 50)) entao
        
        se (Asc(copia(data, 1, 1)) >= 48) e (Asc(copia(data, 1, 1)) <= 50) entao
           se (Asc(copia(data, 2, 2)) >= 48) e (Asc(copia(data, 2, 2)) <= 57) entao
              se (Asc(copia(data, 10, 10)) >= 48) e (Asc(copia(data, 10, 10)) <= 57) e (Asc(copia(data, 7, 7)) >= 48) e (Asc(copia(data, 7, 7)) <= 57) e (Asc(copia(data, 8, 8)) >= 48) e (Asc(copia(data, 8, 8)) <= 57) e (Asc(copia(data, 9, 9)) >= 48) e (Asc(copia(data, 9, 9)) <= 57) entao
                 retorne verdadeiro
              fimse
           fimse
        fimse
        
        se (Asc(copia(data, 1, 1)) = 51) entao
           se (Asc(copia(data, 2, 2)) >= 48) e (Asc(copia(data, 2, 2)) <= 49) entao
              se (Asc(copia(data, 10, 10)) >= 48) e (Asc(copia(data, 10, 10)) <= 57) e (Asc(copia(data, 7, 7)) >= 48) e (Asc(copia(data, 7, 7)) <= 57) e (Asc(copia(data, 8, 8)) >= 48) e (Asc(copia(data, 8, 8)) <= 57) e (Asc(copia(data, 9, 9)) >= 48) e (Asc(copia(data, 9, 9)) <= 57) entao
                 retorne verdadeiro
              fimse
           fimse
        fimse
        
     fimse
     
     //M�s igual a 11
     se (Asc(copia(data,4, 4)) = 49) e (Asc(copia(data,5, 5)) = 49) entao

        se (Asc(copia(data, 1, 1)) >= 48) e (Asc(copia(data, 1, 1)) <= 50) entao
           se (Asc(copia(data, 2, 2)) >= 48) e (Asc(copia(data, 2, 2)) <= 57) entao
              se (Asc(copia(data, 10, 10)) >= 48) e (Asc(copia(data, 10, 10)) <= 57) e (Asc(copia(data, 7, 7)) >= 48) e (Asc(copia(data, 7, 7)) <= 57) e (Asc(copia(data, 8, 8)) >= 48) e (Asc(copia(data, 8, 8)) <= 57) e (Asc(copia(data, 9, 9)) >= 48) e (Asc(copia(data, 9, 9)) <= 57) entao
                 retorne verdadeiro
              fimse
           fimse
        fimse

        se (Asc(copia(data, 1, 1)) = 51) entao
           se (Asc(copia(data, 2, 2)) = 48) entao
              se (Asc(copia(data, 10, 10)) >= 48) e (Asc(copia(data, 10, 10)) <= 57) e (Asc(copia(data, 7, 7)) >= 48) e (Asc(copia(data, 7, 7)) <= 57) e (Asc(copia(data, 8, 8)) >= 48) e (Asc(copia(data, 8, 8)) <= 57) e (Asc(copia(data, 9, 9)) >= 48) e (Asc(copia(data, 9, 9)) <= 57) entao
                 retorne verdadeiro
              fimse
           fimse
        fimse

     fimse
FIMFUNCAO
   
inicio
// Se��o de Comandos
   escreval("Digite uma data")
   leia(data)
   
   se (Compr(data) = 10) entao
      se (DataValida(data)) entao
         escreval("Sua data ", data, " � uma data v�lida")
      senao
         escreval("Sua data ", data, " n�o � uma data v�lida")
      fimse
   senao
      escreval("Sua data ", data, " n�o � uma data v�lida")
   fimse

fimalgoritmo

#include <stdio.h>

main(){
   float nota1 = 0;
   float nota2 = 0;
   float media = 0;

   printf("Digite a primeira nota\n");
   scanf("%f", &nota1);
   printf("Digite a segunda nota\n");
   scanf("%f", &nota2);
   media = (nota1 + (nota2 * 2)) / 3;
   printf("A media da sua nota e \n%2.2f", media);
}

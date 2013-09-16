#include <stdio.h>

main(){
   float lado = 0;
   float area = 0;

   printf("Digite o lado do quadrado\n");
   scanf("%f", &lado);
   area = lado * lado;
   printf("A area do quadrado e: \n%2.0f", area);
}

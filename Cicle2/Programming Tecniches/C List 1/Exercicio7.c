#include <stdio.h>

main(){
   float base = 0;
   float altura = 0;
   float area = 0;

   printf("Digite a altura do retangulo\n");
   scanf("%f", &altura);
   printf("Digite a base do retangulo\n");
   scanf("%f", &base);
   area = altura * base;
   printf("A area do retangulo e: \n%2.0f", area);
}

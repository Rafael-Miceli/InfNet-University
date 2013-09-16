#include <stdio.h>

main(){
   int num1 = 0;
   int num2 = 0;
   int num3 = 0;

   printf("Digite um numero\n");
   scanf("%d", &num1);
   printf("Digite outro numero\n");
   scanf("%d", &num2);
   num3 = num1;
   num1 = num2;
   num2 = num3;
   printf("Numero 1 = %d\n", num1);
   printf("Numero 2 = %d\n", num2);
}

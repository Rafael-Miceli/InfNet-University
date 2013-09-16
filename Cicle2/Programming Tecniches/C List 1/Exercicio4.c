#include <stdio.h>

main(){
   float conta = 0;
   float gorjeta = 0;

   printf("Digite o valor da conta\n");
   scanf("%f", &conta);
   gorjeta = conta * 10 / 100;
   printf("o total da gorjeta e: \nR$%2.2f", gorjeta);
}

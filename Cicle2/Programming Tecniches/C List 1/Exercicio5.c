#include <stdio.h>

main(){
   float salario = 0;
   float reajuste = 0;
   float total = 0;

   printf("Digite o slario\n");
   scanf("%f", &salario);
   printf("Digite o percentual do reajuste\n");
   scanf("%f", &reajuste);
   total = salario += salario * reajuste / 100;
   printf("Seu novo salario e: \nR$%2.2f", total);
}

#include <stdio.h>
#include <math.h>

main(){
   float raio = 0;
   float area = 0;

   printf("Digite o raio do circulo\n");
   scanf("%f", &raio);
   area = (raio * raio) * M_PI;
   printf("A area do circulo e: \n%2.3f", area);
}

#include <stdio.h>
#include <math.h>

main(){
   float raio = 0;
   float area = 0;

   printf("Digite o raio da esfera\n");
   scanf("%f", &raio);
   area = (raio * raio) * (4 * M_PI);
   printf("A area da esfera e: \n%2.3f", area);
}

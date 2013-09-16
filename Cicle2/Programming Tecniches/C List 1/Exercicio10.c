#include <stdio.h>
#include <math.h>

main(){
   float raio = 0;
   float altura = 0;
   float volume = 0;

   printf("Digite o raio do cilindro\n");
   scanf("%f", &raio);
   printf("Digite a altura do cilindro\n");
   scanf("%f", &altura);
   volume = altura * (raio * raio) * M_PI;
   printf("O volume do clindro e: \n%2.3f", volume);
}

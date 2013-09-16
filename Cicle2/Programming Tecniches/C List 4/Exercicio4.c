#include<stdio.h>

main()
{
    int i = 0, j = 0, reverseArray[20], IsZero = 1, soma = 0;
    float media;

    while(IsZero != 0 && i < 20)
    {
        printf("Digite um numero, ou zero para sair.\n");
        scanf(" %d", &IsZero);
        if(IsZero == 0 && i == 0)
            return;

        reverseArray[i] = IsZero;
        soma += IsZero;
        i++;
    }
    i = i - 1;

    media = soma / i;

    printf("Numeros maiores que a media:%.2f\n", media);
    for(j = 0 ; j < i; j++)
    {
        if(reverseArray[j] >= media)
            printf(" %.2d", reverseArray[j]);
    }


}

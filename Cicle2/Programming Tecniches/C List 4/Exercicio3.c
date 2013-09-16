#include<stdio.h>

main()
{
    int i = 0, reverseArray[20], IsZero = 1;

    while(IsZero != 0 && i < 20)
    {
        printf("Digite um numero, ou zero para sair.\n");
        scanf(" %d", &IsZero);
        if(IsZero == 0 && i == 0)
            return;

        reverseArray[i] = IsZero;
        i++;
    }

    printf("Numeros invertidos:\n");
    i = i - 2;

    for(i ; i > -1; i--)
    {
        printf(" %d", reverseArray[i]);
    }


}

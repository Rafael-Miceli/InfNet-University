#include<stdio.h>

main()
{
    int i = 0, qtdArray[21], num = 1;
    
    for(i = 0; i < 20; i++)
    {
        qtdArray[i] = 0;
    }
    
    printf("Digite um numero, ou zero para sair.\n");
    scanf(" %d", &num);
    
    while(num != 0)
    {
        if(num > 0 && num < 21)
        {
            qtdArray[num] += 1;
        }
        else
        {
            printf("Numero invalido.\n");
        }
        
        printf("Digite um numero, ou zero para sair.\n");
        scanf(" %d", &num);
    }
    
    for(i = 1 ; i < 21; i++)
    {
        printf("Numero de %d", i);
        printf(" = ", qtdArray[i]);
    }


}

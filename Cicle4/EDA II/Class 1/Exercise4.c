#include<stdio.h>
#include<string.h>

void ReverseStr(char palavra[], int comeco, int fim)
{
    if(comeco < fim)
    {
        char temp = palavra[comeco];
        palavra[comeco] = palavra[fim];
        palavra[fim] = temp;

        ReverseStr(palavra, ++comeco, --fim);
    }
}

void Invert(char palavra[])
{
    if(strlen(palavra) > 0)
    {
        ReverseStr(palavra, 0, strlen(palavra) - 1);
    }
}

main()
{
    char palavra[] = {};
    printf("Digite uma palavra que retorno ela invertida para voce: ");
    scanf("%s", palavra);

    Invert(palavra);
    printf("\n%s", palavra);
}

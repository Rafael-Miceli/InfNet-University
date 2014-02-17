#include<stdio.h>

int CalcularMdc(int dividendo, int divisor)
{
    int resto = 0;

    //Se previnir caso entrem com o divisor igual a zero
    if (divisor < 1)
        return 0;

    resto = dividendo % divisor;

    if(resto == 0)
        return divisor;

    CalcularMdc(divisor, resto);
}

main()
{
    int dividendo = 0, divisor = 0, mdc = 0;

    printf("Digite o dividendo: ");
    scanf("%d", &dividendo);
    printf("Digite o divisor: ");
    scanf("%d", &divisor);

    mdc = CalcularMdc(dividendo, divisor);
    printf("\n MDC = %d", mdc);
}

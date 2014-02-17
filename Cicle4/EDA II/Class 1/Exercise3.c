#include<stdio.h>

int CalculatePrime(dividendo, divisor)
{
    int resto = 0;
    if (divisor >= dividendo || (dividendo < 4 && dividendo > 0))
        return 1;

    resto = dividendo % divisor;

    if (resto == 0)
        return 0;

    CalculatePrime(dividendo, ++divisor);
}

int IsPrime(number)
{
    return CalculatePrime(number, 2);
}

main()
{
    int number = 0;
    printf("Digite um numero, te direi se ele e primo ou nao: ");
    scanf("%d", &number);

    if(IsPrime(number))
        printf("O numero %d eh primo", number);
    else
        printf("O numero %d Nao eh primo", number);
}

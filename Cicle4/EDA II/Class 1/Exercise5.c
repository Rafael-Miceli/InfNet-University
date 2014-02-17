#include<stdio.h>

int vet[9];

void InicializarVetor(int posicaoInicial, int posicaoFinal)
{
    if(posicaoInicial > posicaoFinal)
        return;

    vet[posicaoInicial] = (posicaoInicial + 1) * 2;
    InicializarVetor(++posicaoInicial, posicaoFinal);
}

int BuscarMaiorElemento(int posicao, int maiorElemento, int fim)
{
    if(posicao > fim)
        return maiorElemento;

    if (vet[posicao] > maiorElemento)
        maiorElemento = BuscarMaiorElemento(++posicao, vet[posicao], fim);
    else
        maiorElemento = BuscarMaiorElemento(++posicao, maiorElemento, fim);
}

int ExibirMaiorElemento()
{
    int posicaoInicial = 0, posicaoFinal = 9, maiorElemento = 0;

    maiorElemento = BuscarMaiorElemento(posicaoInicial, maiorElemento, posicaoFinal);

    return maiorElemento;
}

main()
{
    printf("Populando o vetor");
    InicializarVetor(0, 9);

    printf("\nMaior elemento: %d", ExibirMaiorElemento());
}

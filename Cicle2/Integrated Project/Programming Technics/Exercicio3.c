#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* BuscarProduto(char nomeProduto[])
{
    FILE *arq;
    char temp[512];

    arq = fopen("estoque.txt", "r");
    if(arq == NULL)
    {
        fclose(arq);
        return temp;
    }
    else
    {
        while(fgets(temp, 521, arq) != NULL)
        {
            if(strstr(temp, nomeProduto) != NULL)
            {
                fclose(arq);
                return temp;
            }
        }


    }
}

main()
{
    char produtoABuscar[60], answer = 'N';
    char* Produto;

    do
    {
        printf("Digite o nome do produto para busca: \n");
        scanf("%s", produtoABuscar);

        Produto = BuscarProduto(produtoABuscar);

        if(Produto != NULL)
            printf("Produto: \n%s", Produto);
        else
            printf("Produto nao encontrado");

        do
        {
            printf("\n\nDeseja buscar outro produto? S/N \n");
            scanf(" %c", &answer);
        } while(answer != 'S' && answer != 'N');

    }while(answer == 'S');

}

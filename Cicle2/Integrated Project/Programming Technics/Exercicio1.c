#include <stdio.h>

main()
{
    typedef struct{
        int codigo;
        char nome[20];
        float preco;
        int quantidade;
    } Produto;

    Produto _produto;
    FILE *_file;
    int i = 0;


    printf("Informe o codigo do produto\n");
    scanf(" %d", &_produto.codigo);
    while(_produto.codigo)
    {
        printf("Informe o nome do produto\n");
        scanf("%s", _produto.nome);
        printf("Informe o preco do produto\n");
        scanf("%f", &_produto.preco);
        printf("Informe a quantidade deste produto em estoque\n");
        scanf("%d", &_produto.quantidade);

        _file = fopen("estoque.txt", "a");
        if (_file != NULL){
            fprintf(_file, "%d", _produto.codigo);
            fprintf(_file, " %s",_produto.nome);
            fprintf(_file, " %.2f",_produto.preco);
            fprintf(_file, " %d\n",_produto.quantidade);

            fclose(_file);
        }
        else
        {
            puts("Erro: abertura do arquivo de destino");
            return;
        }

        printf("Informe o codigo do produto\n");
        scanf(" %d", &_produto.codigo);
    }

}

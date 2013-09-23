#include <stdio.h>

main()
{
    typedef struct{
        int cod_prod;
        int cod_mov;
        int quantidade;
    } Movimento;

    Movimento _movimento;
    FILE *_file;
    char tipoMov;
    int i = 0;


    printf("Informe o codigo do movimento\n");
    scanf(" %d", &_movimento.cod_mov);
    while(_movimento.cod_mov)
    {
        printf("Informe o codigo do produto movimentado\n");
        scanf(" %d", &_movimento.cod_prod);
        printf("Informe a quantidade de produtos movimentados\n");
        scanf(" %d", &_movimento.quantidade);
        printf("Informe tipo de movimento, entrada (+) ou saida (-)\n");
        scanf(" %c", &tipoMov);

        _file = fopen("arqMov.txt", "a");
        if (_file != NULL){
            fprintf(_file, "%d", _movimento.cod_mov);
            fprintf(_file, " %d",_movimento.cod_prod);
            fprintf(_file, " %c", tipoMov);
            fprintf(_file, "%d\n",_movimento.quantidade);

            fclose(_file);
        }
        else
        {
            puts("Erro: abertura do arquivo de destino");
            return;
        }

        printf("Informe o codigo do movimento\n");
        scanf(" %d", &_movimento.cod_mov);
    }

}

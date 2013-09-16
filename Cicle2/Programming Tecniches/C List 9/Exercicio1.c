#include <stdio.h>
#include <string.h>

main()
{
    FILE *arq;
    int car, line = 1;
    char nomearq[] = "Exercicio1.c";

    arq = fopen(nomearq, "r");
    if (arq != NULL) {

        printf("%d ", line);
        line++;
        car = fgetc(arq);
        while (car != EOF) {
            if (car == '\n')
            {
                printf("%c", car);
                printf("%d ", line);
                line++;
            }
            else
            {
                printf("%c", car);
            }
            car = fgetc(arq);
        }
        fclose(arq);
    }
    else
        puts("Erro: abertura do arquivo");
}

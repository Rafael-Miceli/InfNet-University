#include <stdio.h>

typedef struct{
   int cod_prod;
   char nome[20];
   float preco;
   int quantidade;
}tp_estoque;

typedef struct{
    int cod_mov;
    int cod_prod;
    int quantidade;
}tp_movimento;

    FILE *est;   // foram declaradoa aqui para ficar mais fácil na hora de utilizá-los nos procedimentos
    FILE *mov;


void carrega_estoque( tp_estoque vet[],int *tt) // O estoque foi carregado em um vetor de até 50 posições
{
    *tt = 0;
    int ret , i = -1;
    tp_estoque estoque;
    char nome_estoque[] = "estoque.dat";

    est = fopen(nome_estoque, "rb");
    if (est != NULL){
       ret = fread(&estoque, sizeof(tp_estoque), 1, est);
       while (ret != 0){
           vet[++i] = estoque;
           (*tt)++;
           ret = fread(&estoque, sizeof(tp_estoque), 1, est);
       }
       fclose(est);
    }
    else
        puts("Erro: Abertura do arquivo");
}

void processa_movimento(tp_estoque vet[] , tp_movimento *movimento) // O movimento foi lido e o estoque atualizado no vetor
{
    int ret , i = -1;
    char nome_movimento[] = "movimento.dat";
    char nome_estoque[] = "estoque.dat";

    mov = fopen(nome_movimento, "rb");
    if (mov != NULL){
        est = fopen(nome_estoque, "rb");
        if (est != NULL){
        while ((!feof(mov)) && (!feof(est))){
             fread(&movimento, sizeof(tp_movimento), 1, mov);
             fread(&vet[++i],sizeof(tp_estoque), 1, est);
             if (movimento->cod_prod == vet[i].cod_prod){
                 printf("Passei aqui nao erro Ln 59");
                 vet[i].quantidade = vet[i].quantidade + (movimento->quantidade);
             }
        }
        }
        else
            puts("Erro: Abertura do arquivo de estoque");
     }
     else
         puts("Erro: Abertura do arquivo de movimento");
    }

void grava_estoque(tp_estoque vet[], int tt) //O vetor foi gravado em um novo estoque
{
    FILE *est02;
    char nome_estoque02[] = "estoque02.dat";
    int ret , i = -1;

    est02 = fopen(nome_estoque02, "wb");
    if (est02 != NULL){
       ret = fwrite(vet, sizeof(tp_estoque), tt, est02); // Todos os registros foram gravados de uma só vez
       if (ret == tt)
          printf("Estoque gravado com sucesso");
       else
          printf("Foram gravados apenas %d",ret);
        fclose(est02);
    }
    else
        puts("Erro: Abertura do arquivo");
}


main(){
    int total_registros;
    tp_estoque vet[50] = {0};
    tp_movimento movimento;

    carrega_estoque(vet, &total_registros);
    processa_movimento(vet, &movimento);
    grava_estoque(vet, total_registros);
}

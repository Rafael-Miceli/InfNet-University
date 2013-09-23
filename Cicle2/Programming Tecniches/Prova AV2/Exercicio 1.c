#include <stdio.h>

typedef struct{
    int Conta;
    char Nome[20];
    float Saldo;
} Cliente;

char FileName[] = "Contas.dat";

int ContaValida(int conta, Cliente *cliente)
{
    while(conta < 0)
    {
        printf("Valor de conta invalido, por favor preencha um valor valido\n");
        scanf("%d", &conta);
    }
    if(conta == 0)
        return 0;
    else
    {
        cliente->Conta = conta;
        return 1;
    }
}

void GerarArquivoConta(Cliente cliente)
{
    FILE *file;
    int retur;

    file = fopen(FileName, "ab");
    fflush(stdin);

    retur = fwrite(&cliente, sizeof(Cliente), 1, file);
    if(retur == 1)
        printf("Registro gravado com sucesso\n");

    fclose(file);
}

void LerArquivo()
{
    FILE *file;
    int retur;
    Cliente cliente;

    file = fopen(FileName, "rb");
    if (file != NULL)
    {
        retur = fread(&cliente, sizeof(Cliente), 1, file);
        while(retur != 0)
        {
            printf("\nConta: %d\n", cliente.Conta);
            printf("Nome: %s\n", cliente.Nome);
            printf("Saldo: %.2f\n", cliente.Saldo);
            retur = fread(&cliente, sizeof(Cliente), 1, file);
        }

        fclose(file);
    }
    else
        printf("Erro ao tentar ler arquivo");
}

main()
{
    Cliente _cliente;
    int conta;

    printf("Digite sua conta\n");
    scanf("%d", &conta);
    while(ContaValida(conta, &_cliente))
    {
        printf("Digite seu nome\n");
        scanf("%s", _cliente.Nome);
        printf("Digite seu saldo\n");
        scanf("%f", &_cliente.Saldo);
        GerarArquivoConta(_cliente);
        printf("Digite sua conta\n");
        scanf("%d", &conta);
    }

    LerArquivo();
}

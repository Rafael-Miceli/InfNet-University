#include <stdio.h>
#include <string.h>

typedef struct{
    int Conta;
    char Nome[20];
    float Saldo;
} Cliente;

Cliente _clientes[50];
char FileName[] = "Contas.dat";
int _totalClientes;

void CarregaClientes()
{
    FILE *file;
    int retur, i = 0;
    Cliente cliente;

    file = fopen(FileName, "rb");
    if (file != NULL)
    {
        retur = fread(&cliente, sizeof(Cliente), 1, file);
        while(retur != 0)
        {
            _clientes[i].Conta = cliente.Conta;
            strcpy(_clientes[i].Nome, cliente.Nome);
            _clientes[i].Saldo = cliente.Saldo;

            i++;

            retur = fread(&cliente, sizeof(Cliente), 1, file);
        }

        _totalClientes = i;

        fclose(file);
    }
    else
        printf("Erro ao tentar ler arquivo");

}

float CalcularMediaDosSaldos()
{
    float totSaldos = 0, media = 0;
    int i = 0;

    for(i; i < _totalClientes; i++)
    {
        totSaldos += _clientes[i].Saldo;
    }

    media = totSaldos / _totalClientes;

    return media;
}

void ClientesComSaldoMaiorOuIgualAMedia(float media)
{
    int i = 0;

    for(i; i < _totalClientes; i++)
    {
        if(_clientes[i].Saldo >= media)
        {
            printf("\nCliente(s) com saldo maior ou igual a media\n");
            printf("\nConta: %d\n", _clientes[i].Conta);
            printf("Nome: %s\n", _clientes[i].Nome);
            printf("Saldo: %.2f\n", _clientes[i].Saldo);
        }
    }
}

main()
{
    float media;

    CarregaClientes();
    media = CalcularMediaDosSaldos();
    ClientesComSaldoMaiorOuIgualAMedia(media);
}

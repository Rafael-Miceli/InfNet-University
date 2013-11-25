#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<stdbool.h>

typedef struct{
    char *Nome;
    char *Codigo;
	float Preco;
} Oferta;

Oferta ofertas[4];

//Está é a fila
//========
struct fila
{
    Oferta oferta_pedida;
    struct fila *link;
}*primeiro_no=NULL,*ultimo_no=NULL;
//========

//Esse são os "protótipos" dos métodos que contém neste arquivo
//========
void InserirNaFila(int numero_oferta_selecionada);
int FilaVazia();
void MostrarPedidos();
void MostrarOfertas();
void CadastrarOfertas();
bool OfertaExiste(int numero_oferta_selecionada);
void FinalizarPedidos();
//========

main()
{
    CadastrarOfertas();

    int opcao_escolhida, numero_oferta_selecionada, numero_pedido_selecionado;
    Oferta oferta_selecionada;

    while(1)
    {
        printf("\n1.Fazer pedido\n");
        printf("2.Finalizar Pedido\n");
        printf("3.Exibir Pedidos Feitos\n");
        printf("4.Sair\n");
        printf("Selecione uma das opcoes anteriores: ");

        scanf("%d", &opcao_escolhida);

        switch(opcao_escolhida)
        {
            case 1:

                MostrarOfertas();

                printf("\nSelecione uma oferta: ");
                scanf("%d",&numero_oferta_selecionada);

                if (OfertaExiste(numero_oferta_selecionada - 1))
                {
                    InserirNaFila(numero_oferta_selecionada - 1);
                }
                else
                    printf("Oferta selecionada invalida.\n");
                break;
            case 2:
                if(FilaVazia())
                {
                    printf("\nNenhum pedido feito\n");
                    break;
                }
                printf("Finalizando pedidos:\n\n");
                FinalizarPedidos();
                break;
            case 3:
				MostrarPedidos();
                break;
            case 4:
                exit(1);
                break;
            default :
                printf("Opcao incorreta\n");
        }
    }
}

void CadastrarOfertas()
{
    ofertas[0].Codigo = "00001";
    ofertas[0].Nome = "Televisao";
    ofertas[0].Preco = 2000.00;

    ofertas[1].Codigo = "00002";
    ofertas[1].Nome = "Cama";
    ofertas[1].Preco = 3800.00;

    ofertas[2].Codigo = "00003";
    ofertas[2].Nome = "Guarda Roupa";
    ofertas[2].Preco = 4400.00;

    ofertas[3].Codigo = "00004";
    ofertas[3].Nome = "Armario";
    ofertas[3].Preco = 2100.00;

    ofertas[4].Codigo = "00005";
    ofertas[4].Nome = "Rack";
    ofertas[4].Preco = 1535.00;
}

void MostrarOfertas()
{
    int i;
    for(i = 0; i < 5; i++)
    {
		printf("\n\n%d.", i + 1);
		printf("Oferta: %s\n", ofertas[i].Nome);
		printf("Preco: R$%.2f\n", ofertas[i].Preco);
    }
}

//Este método serve para o caso do usuário digitar o numero de alguma oferta que não existe
bool OfertaExiste(int numero_oferta_selecionada)
{
    if (numero_oferta_selecionada < 5 && numero_oferta_selecionada >= 0)
    {
		return true;
    }

    return false;
}

void InserirNaFila(int numero_oferta_selecionada)
{
    struct fila *novo_no;

	//Cria um novo nó na fila
    novo_no = (struct fila *)malloc(sizeof(struct fila));

	//Se não conseguir criar o novo nó, significa que a memória esta com espaço cheio
    if(novo_no == NULL)
    {
        printf("Memoria Cheia\n");
        return;
    }

	//Insere a oferta na fila
    novo_no->oferta_pedida = ofertas[numero_oferta_selecionada];
    novo_no->link = NULL;

	//Como é uma fila aqui a verificação serve para o seguinte:
	//Se o primeiro nó da fila for nulo, significa que é a primeira vez que esta sendo criado um nó na fila,
	//Senão, significa que ja existe nó nessa fila, então, é criado um nó na última posição da fila
    if(primeiro_no == NULL)
        primeiro_no=novo_no;
    else
        ultimo_no->link = novo_no;

    ultimo_no=novo_no;
}

int FilaVazia()
{
    if(primeiro_no == NULL)
        return 1;
    else
        return 0;

}

void MostrarPedidos()
{
    struct fila *no_a_exibir;
    no_a_exibir = primeiro_no;
    int i = 1;

    if(FilaVazia())
    {
        printf("\nNenhum pedido feito\n");
        return;
    }

    printf("\n******* Pedidos *******\n");


    while(no_a_exibir!=NULL)
    {
        printf("%d.", i);
        printf("Nome: %s\n",no_a_exibir->oferta_pedida.Nome);
        printf("Preco: %.2f\n",no_a_exibir->oferta_pedida.Preco);
        no_a_exibir = no_a_exibir->link;
        i++;
    }

    printf("***********************\n");
}

void FinalizarPedidos()
{
    struct fila *no_a_finalizar;
    Oferta pedido_finalizado;
    int i = 1;

    while(!FilaVazia())
    {
        no_a_finalizar = primeiro_no;
        pedido_finalizado = no_a_finalizar->oferta_pedida;
        primeiro_no = primeiro_no->link;
        free(no_a_finalizar);

        printf("Pedido [%s] finalizado, seu voucher eh: ", pedido_finalizado.Nome);
        printf("%s", pedido_finalizado.Codigo);
        printf("%d\n", i);

        i++;
    }

    exit(1);
}

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<stdbool.h>

typedef struct{
    char *Nome;
    char *Codigo;
	int Quantidade;
	float Preco;
} Oferta;

Oferta ofertas[4];

struct node
{
    Oferta oferta_pedida;
    struct node *link;
}*primeiro_no=NULL,*ultimo_no=NULL;

void InserirPedidoNaFila(int numero_oferta_selecionada);
void RemoverPedidoSelecionado(int numero_pedido_selecionado);
int FilaDePedidosVazia();
void ExibirPedidos();
void ExibirOfertas();
void CadastrarOfertas();
bool OfertaPedidaValida(int numero_oferta_selecionada);
void FinalizarPedidosEmFila();

main()
{
    CadastrarOfertas();

    int choice, numero_oferta_selecionada, numero_pedido_selecionado;
    Oferta oferta_selecionada;

    while(1)
    {
        printf("\n1.Fazer pedido de alguma oferta\n");
        printf("2.Finalizar Pedido\n");
        printf("3.Remover Pedido\n");
        printf("4.Exibir Pedidos Feitos\n");
        printf("5.Sair\n");
        printf("Selecione uma das opcoes anteriores: ");

        scanf("%d", &choice);

        switch(choice)
        {
            case 1:
                ExibirOfertas();
                printf("\nSelecione uma oferta: ");
                scanf("%d",&numero_oferta_selecionada);

                if (OfertaPedidaValida(numero_oferta_selecionada - 1))
                {
                    InserirPedidoNaFila(numero_oferta_selecionada - 1);
                }
                else
                    printf("Oferta selecionada invalida.\n");
                break;
            case 2:
                if(FilaDePedidosVazia())
                {
                    printf("\nSem pedidos\n");
                    break;
                }
                printf("Finalizando os pedidos:\n\n");
                FinalizarPedidosEmFila();
                break;
            case 3:
                if(FilaDePedidosVazia())
                {
                    printf("\nSem pedidos\n");
                    break;
                }
                ExibirPedidos();
                printf("Selecione um pedido para cancela-lo:");
                scanf("%d", &numero_pedido_selecionado);
                RemoverPedidoSelecionado(numero_pedido_selecionado);
                break;
            case 4:
                ExibirPedidos();
                break;
            case 5:
                exit(1);
            default :
                printf("Wrong choice\n");
        }
    }
}

void CadastrarOfertas()
{
    //Criando a oferta do Xbox One
    ofertas[0].Codigo = "00001";
    ofertas[0].Nome = "Xbox One";
    ofertas[0].Preco = 2000.00;
    ofertas[0].Quantidade = 6;

    //Criando a oferta do PS4
    ofertas[1].Codigo = "00002";
    ofertas[1].Nome = "PS4";
    ofertas[1].Preco = 3800.00;
    ofertas[1].Quantidade = 3;

    //Criando a oferta da televisão
    ofertas[2].Codigo = "00003";
    ofertas[2].Nome = "TV Led 50'";
    ofertas[2].Preco = 4400.00;
    ofertas[2].Quantidade = 12;

    //Criando a oferta do Home Theater
    ofertas[3].Codigo = "00004";
    ofertas[3].Nome = "Home Theater";
    ofertas[3].Preco = 2100.00;
    ofertas[3].Quantidade = 8;

    //Criando a oferta do Sofá
    ofertas[4].Codigo = "00005";
    ofertas[4].Nome = "Sofa de 2 lugares";
    ofertas[4].Preco = 1535.00;
    ofertas[4].Quantidade = 2;
}

void ExibirOfertas()
{
    int i;
    for(i = 0; i < 5; i++)
    {
        if(ofertas[i].Quantidade > 0)
        {
            printf("\n\n%d.", i + 1);
            printf("Oferta: %s\n", ofertas[i].Nome);
            printf("Preco: R$%.2f\n", ofertas[i].Preco);
            printf("Quantidade em estoque: %d\n", ofertas[i].Quantidade);
        }
    }
}

bool OfertaPedidaValida(int numero_oferta_selecionada)
{
    if (numero_oferta_selecionada < 5 && numero_oferta_selecionada >= 0)
    {
        if(ofertas[numero_oferta_selecionada].Quantidade > 0)
        {
            return true;
        }
    }

    return false;
}

void InserirPedidoNaFila(int numero_oferta_selecionada)
{
    struct node *novo_no;
    novo_no = (struct node *)malloc(sizeof(struct node));

    if(novo_no == NULL)
    {
        printf("Memoria Cheia\n");
        return;
    }

    ofertas[numero_oferta_selecionada].Quantidade--;

    novo_no->oferta_pedida = ofertas[numero_oferta_selecionada];
    novo_no->link = NULL;

    if(primeiro_no == NULL)     
        primeiro_no=novo_no;
    else
        ultimo_no->link = novo_no; 
    ultimo_no=novo_no;
}

void RemoverPedidoSelecionado(int numero_pedido_selecionado)
{
    struct node *no_atual, *no_anterior, *no_a_remover;
    no_atual = no_anterior = primeiro_no;
    int i = 1;

    if(FilaDePedidosVazia())
    {
        printf("\nSem pedidos\n");
        return;
    }

    for(i; i <= numero_pedido_selecionado; i++)
    {
        if(i == numero_pedido_selecionado)
        {
            no_a_remover = no_atual;
            no_anterior->link = no_atual->link;
            free(no_a_remover);
            break;
        }
        no_anterior = no_atual;
        no_atual = no_atual->link;
    }
}

int FilaDePedidosVazia()
{
    if(primeiro_no == NULL)
        return 1;
    else
        return 0;

}

void ExibirPedidos()
{
    struct node *no_a_exibir;
    no_a_exibir = primeiro_no;
    int i = 1;

    if(FilaDePedidosVazia())
    {
        printf("\nSem pedidos\n");
        return;
    }

    printf("\n======= Pedidos =======\n");


    while(no_a_exibir!=NULL)
    {
        printf("%d.", i);
        printf("Nome: %s\n",no_a_exibir->oferta_pedida.Nome);
        printf("Preco: %.2f\n",no_a_exibir->oferta_pedida.Preco);
        no_a_exibir = no_a_exibir->link;
        i++;
    }

    printf("=======================\n");
}

void FinalizarPedidosEmFila()
{
    struct node *no_a_finalizar;
    Oferta pedido_finalizado;
    int i = 1;

    while(!FilaDePedidosVazia())
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

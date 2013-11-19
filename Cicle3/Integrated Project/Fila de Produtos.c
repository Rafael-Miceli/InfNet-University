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
}*front=NULL,*rear=NULL;

void insert(int numero_oferta_selecionada);
void RemoverPedidoSelecionado(int numero_pedido_selecionado);
int isEmpty();
void display();
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
                    insert(numero_oferta_selecionada - 1);
                }
                else
                    printf("Oferta selecionada invalida.\n");
                break;
            case 2:
                if(isEmpty())
                {
                    printf("\nSem predidos\n");
                    break;
                }
                printf("Finalizando os pedidos:\n\n");
                FinalizarPedidosEmFila();
                break;
            case 3:
                if(isEmpty())
                {
                    printf("\nSem predidos\n");
                    break;
                }
                display();
                printf("Selecione um pedido para cancela-lo:");
                scanf("%d", &numero_pedido_selecionado);
                RemoverPedidoSelecionado(numero_pedido_selecionado);
                break;
            case 4:
                display();
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

void insert(int numero_oferta_selecionada)
{
    struct node *tmp;
    tmp = (struct node *)malloc(sizeof(struct node));

    if(tmp==NULL)
    {
        printf("Memory not available\n");
        return;
    }

    ofertas[numero_oferta_selecionada].Quantidade--;

    tmp->oferta_pedida = ofertas[numero_oferta_selecionada];
    tmp->link=NULL;

    if(front==NULL)      /*If Queue is empty*/
        front=tmp;
    else
        rear->link = tmp; /*The above statement would link the the previous node to the newly created node*/
    rear=tmp;
}

void RemoverPedidoSelecionado(int numero_pedido_selecionado)
{
    struct node *curr, *bef, *tmp;
    curr = bef = front;
    int i = 1;

    if(isEmpty())
    {
        printf("\nSem pedidos\n");
        return;
    }

    for(i; i <= numero_pedido_selecionado; i++)
    {
        if(i == numero_pedido_selecionado)
        {
            tmp = curr;
            bef->link = curr->link;
            free(tmp);
            break;
        }
        bef = curr;
        curr = curr->link;
    }
}

int isEmpty()
{
    if(front==NULL)
        return 1;
    else
        return 0;

}

void display()
{
    struct node *ptr;
    ptr = front;
    int i = 1;

    if(isEmpty())
    {
        printf("\nSem pedidos\n");
        return;
    }

    printf("\n======= Pedidos =======\n");


    while(ptr!=NULL)
    {
        printf("%d.", i);
        printf("Nome: %s\n",ptr->oferta_pedida.Nome);
        printf("Preco: %.2f\n",ptr->oferta_pedida.Preco);
        ptr=ptr->link;
        i++;
    }

    printf("=======================\n");
}

void FinalizarPedidosEmFila()
{
    struct node *tmp;
    Oferta item;
    int i = 1;

    while(!isEmpty())
    {
        tmp = front;
        item = tmp->oferta_pedida;
        front = front->link;
        free(tmp);

        printf("Pedido [%s] finalizado, seu voucher eh: ", item.Nome);
        printf("%s", item.Codigo);
        printf("%d\n", i);

        i++;
    }

    exit(1);
}

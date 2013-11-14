#include<stdlib.h>
#include<stdio.h>
#include<stdbool.h>

    struct no{
        int valor;
        struct no *proximo;
    };

    struct no *no_raiz = NULL;
    struct no *no_atual = NULL;

struct no* CriarLista(int valor)
{
    printf("\n Criando lista com no_raiz com valor: [%d]\n", valor);
    struct no *ptr = (struct no*)malloc(sizeof(struct no));

    if(ptr == NULL)
    {
        printf("\n Criacao do (no) falhou \n");
        return NULL;
    }

    ptr->valor = valor;
    ptr->proximo = NULL;

    no_raiz = no_atual = ptr;
    return ptr;
}

struct no* AdicionarNaLista(int valor, bool Adicionar_No_Final_Da_Lista)
{
    if(no_raiz == NULL)
        return (CriarLista(valor));

    if(Adicionar_No_Final_Da_Lista)
        printf("\n Adicionar (no) no final da lista com valor: [%d]\n", valor);
    else
        printf("\n Adicionar (no) no comeco da lista com valor: [%d]\n", valor);

    struct no *ptr = (struct no*)malloc(sizeof(struct no));

    if(ptr == NULL)
    {
        printf("\n Criacao do (no) falhou \n");
        return NULL;
    }

    ptr->valor = valor;
    ptr->proximo = NULL;

    if(Adicionar_No_Final_Da_Lista)
    {
        no_atual->proximo = ptr;
        no_atual = ptr;
    }
    else
    {
        ptr->proximo = no_raiz;
        no_raiz = ptr;
    }

    return ptr;
}

struct no* BuscarNaLista(int valor, struct no **anterior)
{
    struct no *ptr = no_raiz;
    struct no *tmp = NULL;
    bool encontrado = false;

    printf("\n Buscando na lista pelo valor: [%d] \n", valor);

    while(ptr != NULL)
    {
        if(ptr->valor == valor)
        {
            encontrado = true;
            break;
        }
        else
        {
            tmp = ptr;
            ptr = ptr->proximo;
        }
    }

    if(encontrado == true)
    {
        if(anterior)
            *anterior = tmp;

        return ptr;
    }
    else
    {
        return NULL;
    }

}

int DeletarDaLista(int valor)
{
    struct no *anterior = NULL;
    struct no *del = NULL;

    printf("\n Deletando valor [%d] da lista\n", valor);

    del = BuscarNaLista(valor, &anterior);

    if(del == NULL)
        return -1;
    else
    {
        if(anterior != NULL)
            anterior->proximo = del->proximo;

        if(del == no_atual)
            no_atual = anterior;
        else if(del == no_raiz)
            no_raiz = del->proximo;
    }

    free(del);
    del = NULL;

    return 0;
}

void ExibirLista()
{
    struct no *ptr = no_raiz;

    printf("\n --------Comeco da exibicao da lista-------- \n");
    while(ptr != NULL)
    {
        printf("\n [%d] \n", ptr->valor);
        ptr = ptr->proximo;
    }
    printf("\n --------Fim da exibicao da lista-------- \n");

    return;
}

int main()
{

    int i = 0, retorno = 0;
    struct no *ptr = NULL;

    ExibirLista();

    for(i = 5; i<10; i++)
        AdicionarNaLista(i*2, true);

    ExibirLista();

    for(i = 4; i>0; i--)
        AdicionarNaLista(i, false);

    ExibirLista();

    for(i = 1; i<10; i+=4)
    {
        ptr = BuscarNaLista(i*2, NULL);

        if(ptr == NULL)
            printf("\n Buscar na lista [valor = %d] falhou, nenhum elemento encontrado \n", i*2);
        else
            printf("\n Busca encontrou [valor = %d] \n", ptr->valor);

        ExibirLista();

        retorno = DeletarDaLista(i*2);
        if(retorno != 0)
            printf("\n Deletar da lista [valor = %d] falhou, nenhum elemento encontrado \n", i*2);
        else
            printf("\n Deletar da lista [valor = %d], deletado com sucesso. \n", i*2);

        ExibirLista();

        return 0;
    }
    ExibirLista();
}


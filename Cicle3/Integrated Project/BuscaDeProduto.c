#include<stdlib.h>
#include<stdio.h>
#include<stdbool.h>

    typedef struct{
        char Nome[40];
        char Categoria[40];
        float Preco;
    } Produto;

    struct no{
        Produto produto;
        struct no *proximo;
    };



    //struct Produto produto
    struct no *no_raiz = NULL;
    struct no *no_atual = NULL;

struct no* CriarLista(Produto produto)
{
    printf("\n Criando lista com no_raiz com o produto: [%d]\n", produto.Nome);
    struct no *ptr = (struct no*)malloc(sizeof(struct no));

    if(ptr == NULL)
    {
        printf("\n Criacao do (no) falhou \n");
        return NULL;
    }

    ptr->produto = produto;
    ptr->proximo = NULL;

    no_raiz = no_atual = ptr;
    return ptr;
}

void CadastrarProdutos()
{
    Produto produto;
    printf("\n Digite o nome do produto \n");
    scanf("%s",produto.Nome);
    printf("\n Digite a categoria do produto \n");
    scanf("%s",produto.Categoria);
    printf("\n Digite o preco do produto \n");
    scanf("%f",produto.Preco);

}

int main()
{
    CadastrarProdutos();

}

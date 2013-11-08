#include<stdio.h>

    typedef struct{
        char* Name;
        float Price;
        int Quantity;

    } Product;

    Product _products[100];
main()
{

}

void InitializeProducts()
{
    int i = 0;
    for(i; i < 10; i++)
    {
        _products[i].Name = "Product";
    }
}

void OrderProductsByCategory()
{

}



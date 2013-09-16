main()
{
    int i = 0, findArray[] = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100}, num = 0, founded = 0;
    
    printf("Busque um numero.\n");
    scanf(" %d", &num);
    
    while(founded == 0)
    {
        if (findArray[i] == num)
        {
            founded = 1;
            printf("Achou o numero");
        }
        else
        {
            printf("Numero nao encontrado");
        }
    }

}

main()
{
    int i = 0, findArray[] = {10, 2, 30, 4, 50, 6, 70, 8, 9, 1}, orderLog = 10, changed, aux;
    
    do
    {
      changed = 0;
      for(i; i < orderLog - 1; i++)
      {
          if(findArray[i] > findArray[i + 1])
          {
              aux = findArray[i + 1];
              findArray[i + 1] = findArray[i];
              findArray[i] = aux;
              changed = 1
          }
      }
      orderLog -= 1;
      
    }while(changed != 1)
    
    for(i = 0; i < 10; i++)
    {
        printf(" %d\n", findArray[i]);
    }
}

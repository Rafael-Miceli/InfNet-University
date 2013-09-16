main()
{
    int i = 0, transMatrix[4][4], lowerNum, pos;
    
    lowerNum = findArray[i];
    pos = i;
    
    for(i = 1; i < 10; i++)
    {
        if(lowerNum > findArray[i])
        {
            lowerNum = findArray[i];
            pos = i;
        }
    }
    
    printf("Menor numero no array %d\n", lowerNum);
    printf("Posicao do menor numero no array %d", i);

}

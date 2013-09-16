#include <stdio.h>

main()
{
    int i, array2[8], array1[] = {10, 20, 30, 40, 50, 60, 70, 80};

    for(i = 0; i < 8; i++)
    {
        array2[i] = array1[i];
    }

    for(i = 0; i < 8; i++)
    {
        printf(" %d", array2[i]);
    }
}

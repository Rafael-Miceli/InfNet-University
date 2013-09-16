#include <stdio.h>

main()
{
    int i, arraySoma[8], array1[] = {1, 2, 3, 4, 5, 6, 7, 8}, array2[] = {10, 20, 30, 40, 50, 60, 70, 80};

    for (i = 0; i < 8; i++)
    {
        arraySoma[i] = array1[i] + array2[i];
    }

    for (i = 0; i < 8; i++)
    {
        printf(" %d", arraySoma[i]);
    }
}

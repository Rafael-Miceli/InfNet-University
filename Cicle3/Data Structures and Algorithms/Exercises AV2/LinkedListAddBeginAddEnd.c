#include<stdlib.h>
#include<stdio.h>
#include<stdbool.h>

    struct node{
        char val[50];
        struct node *next;
    };

    struct node *root = NULL;
    struct node *curr = NULL;

struct node* Create(char *val)
{
    printf("\n creating list with root node as [%d]\n", val);
    struct node *ptr = (struct node*)malloc(sizeof(struct node));

    if(ptr == NULL)
    {
        printf("\n Node creation failed \n");
        return NULL;
    }

    ptr->val = val;
    ptr->next = NULL;

    root = curr = ptr;
    return ptr;
}

struct node* Add(int val, bool addToEnd)
{
    if(root == NULL)
        return (Create(val));

    if(addToEnd)
        printf("\n Adding node to the end of list with value[%d]\n", val);
    else
        printf("\n Adding node to the beginning of list with value[%d]\n", val);

    struct node *ptr = (struct node*)malloc(sizeof(struct node));

    if(ptr == NULL)
    {
        printf("\n Node creation failed \n");
        return NULL;
    }

    ptr->val = val;
    ptr->next = NULL;

    if(addToEnd)
    {
        curr->next = ptr;
        curr = ptr;
    }
    else
    {
        ptr->next = root;
        root = ptr;
    }

    return ptr;
}

struct node* Find(int val, struct node **prev)
{
    struct node *ptr = root;
    struct node *tmp = NULL;
    bool found = false;

    printf("\n Searching the list for value [%d] \n", val);

    while(ptr != NULL)
    {
        if(ptr->val == val)
        {
            found = true;
            break;
        }
        else
        {
            tmp = ptr;
            ptr = ptr->next;
        }
    }

    if(found == true)
    {
        if(prev)
            *prev = tmp;

        return ptr;
    }
    else
    {
        return NULL;
    }

}

int Delete(int val)
{
    struct node *prev = NULL;
    struct node *del = NULL;

    printf("\n Deleting value [%d] from list\n", val);

    del = Find(val, &prev);

    if(del == NULL)
        return -1;
    else
    {
        if(prev != NULL)
            prev->next = del->next;

        if(del == curr)
            curr = prev;
        else if(del == root)
            root = del->next;
    }

    free(del);
    del = NULL;

    return 0;
}

void PrintList()
{
    struct node *ptr = root;

    printf("\n --------Printing list start-------- \n");
    while(ptr != NULL)
    {
        printf("\n [%d] \n", ptr->val);
        ptr = ptr->next;
    }
    printf("\n --------Printing list end-------- \n");

    return;
}

int main()
{
    int i = 0, ret = 0;
    struct node *ptr = NULL;

    PrintList();

    for(i = 5; i<10; i++)
        Add(i*2, true);

    PrintList();

    for(i = 4; i>0; i--)
        Add(i, false);

    PrintList();

    for(i = 1; i<10; i+=4)
    {
        ptr = Find(i*2, NULL);

        if(ptr == NULL)
            printf("\n Search [val = %d] failed, no element found \n", i*2);
        else
            printf("\n Search passed [val = %d] \n", ptr->val);

        PrintList();

        ret = Delete(i*2);
        if(ret != 0)
            printf("\n Delete [val = %d] failed, no element found \n", i*2);
        else
            printf("\n Delete [val = %d] passed \n", i*2);

        PrintList();

        return 0;
    }
    PrintList();
}


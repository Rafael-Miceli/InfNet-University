#include<stdlib.h>
#include<stdio.h>
#include<stdbool.h>

    struct node{
        char *val;
        struct node *next;
    };

    struct node *root = NULL;
    struct node *curr = NULL;

int main()
{
    int i = 0, ret = 0, choice = 0;
    char value[50];
    struct node *ptr = NULL;

    while(1)
    {
        printf("1.Insert\n");
        printf("2.Delete\n");
        printf("3.Display all elements of the List\n");
        printf("4.Exit\n");
        printf("Enter your choice : ");
        scanf("%d",&choice);

        switch(choice)
        {
             case 1:
                 printf("1.Add to the beginning List?\n");
                 printf("2.Add to the end List?\n");
                 scanf("%d",&choice);

                 switch(choice)
                 {
                    case 1:
                        printf("\nEnter a value to add to the List: ");
                        scanf("%s", value);
                        Add(value, false);
                        break;
                    case 2:
                        printf("\nEnter a value to add to the List: ");
                        scanf("%s", value);
                        Add(value, true);
                        break;
                    default:
                        printf("Wrong choice\n");
                 }


                 break;
             case 2:
                 printf("\nEnter a value to add to the List: ");
                 scanf("%s", value);
                 Delete(value);
                 break;
             case 3:
                 PrintList();
                 break;
             case 4:
                 exit(1);
             default:
                 printf("Wrong choice\n");
        }
    }

    /*

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

    */
}

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

struct node* Add(char *val, bool addToEnd)
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

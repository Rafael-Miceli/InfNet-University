#include<stdlib.h>
#include<stdio.h>
#include<stdbool.h>

    struct node{
        char *value;
        struct node *next;
    };

    struct node *root = NULL;
    struct node *curr = NULL;

struct node* Create(char *value)
{
    printf("\n creating list with root node as [%s]\n", value);
    struct node *new_node = (struct node*)malloc(sizeof(struct node));

    if(new_node == NULL)
    {
        printf("\n Node creation failed \n");
        free(value);
        return NULL;
    }

    new_node->value = strdup(value);
    new_node->next = NULL;

    root = curr = new_node;

    free(value);
    return new_node;
}

struct node* Add(char *value, bool addToEnd)
{
    if(root == NULL)
        return (Create(value));

    if(addToEnd)
        printf("\n Adding node to the end of list with value[%s]\n", value);
    else
        printf("\n Adding node to the beginning of list with value[%s]\n", value);

    struct node *new_node = (struct node*)malloc(sizeof(struct node));

    if(new_node == NULL)
    {
        printf("\n Node creation failed \n");
        free(value);
        return NULL;
    }

    new_node->value = strdup(value);
    new_node->next = NULL;

    if(addToEnd)
    {
        curr->next = new_node;
        curr = new_node;
    }
    else
    {
        new_node->next = root;
        root = new_node;
    }

    free(value);

    return new_node;
}

struct node* Find(char *value, struct node **prev)
{
    struct node *new_node = root;
    struct node *tmp = NULL;
    bool found = false;

    printf("\n Searching the list for value [%s] \n", value);

    while(new_node != NULL)
    {
        printf("%s\n", new_node->value);
        printf("%s\n", value);

        if(!strcmp(new_node->value,value))
        {
            found = true;
            break;
        }
        else
        {
            tmp = new_node;
            new_node = new_node->next;
        }
    }

    if(found == true)
    {
        if(prev)
            *prev = tmp;

        return new_node;
    }
    else
    {
        return NULL;
    }

}

int Delete(char *value)
{
    struct node *prev = NULL;
    struct node *del = NULL;

    printf("\n Deleting value [%s] from list\n", value);

    del = Find(value, &prev);

    if(del == NULL)
    {
        return -1;
    }

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

    free(value);
    return 0;
}

void PrintList()
{
    struct node *new_node = root;

    printf("\n --------Printing list start-------- \n");
    while(new_node != NULL)
    {
        printf("\n [%s] \n", new_node->value);
        new_node = new_node->next;
    }
    printf("\n --------Printing list end-------- \n");

    return;
}


int main()
{
    int i = 0, ret = 0, choice = 0;
    char value[50];
    struct node *new_node = NULL;

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
                 printf("\nEnter a value to delete from the List: ");
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
}


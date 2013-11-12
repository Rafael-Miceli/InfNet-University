#include<stdlib.h>
#include<stdio.h>
#include<stdbool.h>

    struct node{
        int val;
        struct node *next;
    };

    struct node *head = NULL;
    struct node *curr = NULL;

struct node* Create(int val)
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

    head = curr = ptr;
    return ptr;
}

struct node* Add(int val, bool addToEnd)
{
    if(head == NULL)
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
        ptr->next = head;
        head = ptr;
    }

    return ptr;
}

struct node* Find(int val, struct node **prev)
{

}

int main()
{
    /*

    //This is the root, the first and unchanging node
    struct node *root;

    //Now root points to a node struct
    root = (struct node *) malloc(sizeof(struct node));

    //The node root points has its next pointer equal to a null pointer set
    root -> next = 0;

    //By using the "->" operator, you can modify what the node, a pointer, (root in this case) points to
    root -> val = 5;

    */



}


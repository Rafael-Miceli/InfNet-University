#include <stdio.h>

struct Node
{
    int Data;
    struct Node *next;
}*top;

void popStack();
int isEmpty();
void push(int value);
void display();

int main()
{
     int value, choice=0;
     top=NULL;
     struct Node *temp;

     while(1)
     {
         printf("1.Push\n");
         printf("2.Pop\n");
         printf("3.Display all elements of the Stack\n");
         printf("4.Exit\n");
         printf("Enter your choice : ");
         scanf("%d",&choice);

         switch(choice)
         {
              case 1:
                  printf("\nEnter a value to push into the Stack: ");
                  scanf("%d",&value);
                  push(value);
                  break;
              case 2:
                  popStack();
                  break;
              case 3:
                  display();
                  break;
              case 4:
                  while(top!=NULL)
                  {
                       temp = top->next;
                       free(top);
                       top=temp;
                  }
                  exit(1);
              default:
                  printf("Wrong choice\n");
         }
    }
}

void popStack()
{
    if(!isEmpty())
    {
        struct Node *var=top;

        top = top->next;
        printf("\nDeleted element is  %d\n", var->Data);
        free(var);
    }
    else
    {
        printf("\nStack Empty");
    }
}

int isEmpty()
{
    if(top == NULL)
        return 1;
    else
        return 0;
}

void push(int value)
{
    struct Node *temp;
    temp=(struct Node *)malloc(sizeof(struct Node));
    temp->Data=value;

    if (top == NULL)
    {
         top=temp;
         top->next=NULL;
    }
    else
    {
        temp->next=top;
        top=temp;
    }
}

void display()
{
     struct Node *var=top;
     if(var!=NULL)
     {
        printf("\nElements are as:\n");
        while(var!=NULL)
        {
             printf("\t%d\n",var->Data);
             var=var->next;
        }
        printf("\n");
     }
     else
        printf("\nStack is Empty");
}

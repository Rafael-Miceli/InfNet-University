#include <stdio.h>

typedef struct node s_Node;
    struct node {
        int element;
        s_Node*next;
    };
    // Define the node_t structure with the element of the node and the pointer to the next node

    typedef struct{
        s_Node *top_stack;
    }stack_t; // Define the stack_t structure with a pointer to s_Node (the first element of the linked list)

    /*-------------------------- NEEDED PROTOTYPES --------------------------*/
    // Initializes a new stack and returns it
    stack_t NewStack();
    // Returns 1 if the stack is empty, 0 otherwise
    int Empty(stack_t q);
    // Returns 1 if the stack is full, 0 otherwise
    int Full(stack_t q);
    // Pushes the element e in the stack. Returns 1 if it could Push.
    int Push(int e, stack_t *q);
    // Pops an element, placing it in e. Returns 1 if it could Pop.
    int Pop(int *e, stack_t *q);
    // Search for the top element in the stack and returns it.
    int Peek (stack_t s);
    // Displays the content of the stack.
    void Printstack(const stack_t );

    /*============================ MAIN PROGRAM ============================*/
int main()
{
    char filename [20];
    int newint, val1, val2;
    FILE *file;

    stack_t stack1;
    stack_t stack2;
    stack1=NewStack(); //Initializing the stack
    stack2=NewStack();

    printf ("\n\tPlease Enter the name of the file that contains your integers: ");
    scanf ("%s", &filename);
    file = fopen (filename, "r");

    if (file!=NULL)
    {
        fscanf (file, "%d", &newint);
        while (!feof (file)&&!Full (stack1))
        {
           if ( Empty (stack1)) // Putting the first integer read from the file into the first stack.
           {
               Push (newint, &stack1);
           }
           else if (newint <= Peek(stack1)) //If the integer read from the file is less or equal to the integer in the top of the stack
           {
               Push(newint, &stack1); // Push the integer into stack1.
           }
           else
           {
               while (!Empty(stack1) && (newint > Peek (stack1)))
               {    //Repeat poping from stack1 and pushing into stack2
                   // until it the integer read from the file is bigger than the top element of stack1
                   printf ("gOT into THE WHILE LOOP\n");
                   Pop (&val1,&stack1);
                   Push (val1, &stack2);
                   Printstack (stack2);
               }

               printf ("gOT OUT OF THE WHILE LOOP\n");
               Push (newint, &stack1); //Pushing the integer read from the file into the first stack.
               Printstack (stack1);
               while (!Empty(stack2))
               { // Keep poping elements from stack2 and pushing them into stack1 until stack2 is empty
                  Pop (&val2,&stack2);
                  Push (val2, &stack1);
               }
           }

           fscanf (file, "%d", &newint);
          } // End while

        if (feof(file))
            printf ("\n\tYou have reached the end of the file: %s.\n\tThere are no more elements to read.",filename);
        else
            printf ("\n\n\tYour stack is full.\n\tYou can not enstack more elemeents");

        fclose (file);
        printf ("\nThe final result");
        Printstack (stack1);
    }
    else
        printf ("Error!!! Your file did not open successefully!\n"); // Error checking in reading the file
}


/*-------------------------- FUNCTION DEFINITIONS --------------------------*/

// Initializes a new stack and returns it
stack_t NewStack()
{
    stack_t *n_stack;
    n_stack=(stack_t*)malloc(sizeof(stack_t));
    n_stack->top_stack=NULL;
    return (*n_stack);
}

// Returns 1 if the stack is empty, 0 otherwise
int Empty(stack_t q)
{
    if(q.top_stack==NULL)
        return 1;
    else
        return 0;
}

// Returns 1 if the stack is full, 0 otherwise
int Full(stack_t q)
{
    return 0;
}

// Pushes the element e in the stack. Returns 1 if it could Push.
int Push(int e, stack_t *q)
{
    s_Node *nn;
    nn= (s_Node*)malloc(sizeof(s_Node));

    if(Full(*q))
    {
        printf("\n\t Stack is Full !! \n\n");
        return 0;   // return 0 if enstack NOT successful
    }
    else
    {
        nn->element=e;
        nn->next=q->top_stack;
        q->top_stack=nn;
        return 1;
    }
}

// Pops an element, placing it in e. Returns 1 if it could Pop.
int Pop(int *e, stack_t *q)
{
    s_Node *temp;

    if(Empty(*q))  // Check if the stack is empty
    {
        return 0;   // popping Failed
    }
    else
    {
        temp=q->top_stack;  // store the top in a temp ptr Node to free it after
        *e=q->top_stack->element; // Store the popped element in e
        q->top_stack=q->top_stack->next; // Point the top to the next element
        free(temp); // Free the popped Node
        return 1;
    }
}

void Printstack(const stack_t q)
{
    if(Empty(q))
        printf("\n\tStack is empty!!\n");
    else
    {
        s_Node *walker;
        walker = q.top_stack;
        printf("\n\t This is the content of the stack:\n");
        while(walker!=NULL)
        {
          printf("\t%d ",walker->element);
          walker=walker->next;
        }
        printf("\n");
    }
}

int Peek(stack_t s)
{
    printf ("%d\n",s.top_stack->element);
    return s.top_stack->element; // Returning the top element of the stack
}

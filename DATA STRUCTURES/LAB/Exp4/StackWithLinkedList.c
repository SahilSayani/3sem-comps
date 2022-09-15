#include <stdio.h>
#include <stdlib.h>

struct Node
{
    char data;
    struct Node* link;
};

struct Node* create ();
void push (struct Node **start, char data);
char pop (struct Node **start);
void display (struct Node* start);
void delete (struct Node **start);
char peek (struct Node* start);

struct Node* create ()
{
    struct Node* start = NULL;
    return start;
}

void push (struct Node **start, char data)
{
    struct Node *tmp, *q;
    tmp = (struct Node*) malloc (sizeof(struct Node));
    tmp->data = data;
    tmp->link = NULL;

    q = *start;
    
    if (q == NULL)      // start is null
    {
        *start = tmp;
    }
    else 
    {
        //to reach the last node
        while (q->link != NULL)     // while the current node is not the last node
        {
            q = q->link;
        }

        if (q->link == NULL)       // q is the last node
        {
            q->link = tmp;
        }
    }

    // printf ("\nThe value %d has been pushed into stack", data);
}

char pop (struct Node **start)
{
    char ch;
    struct Node *cur, *prev = NULL;
    cur = *start;

    while (cur->link != NULL)         // making p points to last node 
    {
        prev = cur;
        cur = cur->link;
    }
    if (cur->link == NULL)            // cur points to last node
    {
        ch = cur->data;
        // printf ("\nThe popped value is %d", cur->data);

        if (prev == NULL)
        {
            free (*start);
            *start = NULL;
        }
        else 
        {
            free (prev->link);
            prev->link = NULL;
        }
    }

    return ch;
}

void display (struct Node* start)
{
    struct Node *q;

    q = start;

    printf ("\nThe elements are: ");
    while (q != NULL)
    {
        printf ("%c  ", q->data);
        q = q->link;
    }
}

void delete (struct Node **start)
{
    char res;
    printf ("All the elements will be deleted");

    while (*start != NULL)
    {
        res = pop (start);
        printf ("\nThe popped element is %c", res);
        // display (*start);
    }

    *start = NULL;
}

char peek (struct Node* start)
{
    char ch;
    struct Node *cur;
    cur = start;

    while (cur->link != NULL)         // making p points to last node 
    {
        cur = cur->link;
    }
    if (cur->link == NULL)            // cur points to last node
    {
        ch = cur->data;
        // printf ("\nThe last value is %d", cur->data);
    }

    return ch;
}

// simple queue and linked list


int main1(int argc, int const *argv[])
{
    int exit = 0, ch;
    char data, res; 
    struct Node *start = create();

    do
    {
        printf ("\n\nOptions\n\n");
        printf ("1. Push into stack\n");
        printf ("2. Pop from stack\n");
        printf ("3. Display stack\n");
        printf ("4. Peek at stack\n");
        printf ("5. Delete stack\n");
        printf ("0. Exit\n\n");
        printf ("Enter your choice: ");
        scanf ("%d", &ch);

        switch (ch)
        {
        case 1:
            printf ("\nEnter the number to push: ");
            scanf ("%c", &data);
            push (&start, data);
            display (start);
            break;
        
        case 2:
            res = pop (&start);
            printf ("\nThe popped element is %c", res);
            display (start);
            break;
        
        case 3:
            display (start);
            break;

        case 4:
            printf ("\nThe top element is: %c", peek(start));
            break;

        case 5:
            delete (&start);
            display (start);
            break;
        
        case 0:
            exit = 1;
            break;

        default:
            printf ("Invalid choice, try again \n\n");
            break;
        }
    } while (exit == 0);

    return 0;
}

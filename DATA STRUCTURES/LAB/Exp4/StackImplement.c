#include <stdio.h>

int stack[10];
int top = -1;

int display()
{
    int i;

    printf ("\nThe items of the stack are: ");
    for (i = 0; i <= top; i++)
    {
        printf("%d  ", stack [i]);
    }

    return 0;
}

void push()
{
    int a;

    printf ("\nEnter the number to be pushed : ");
    scanf ("%d", &a);

    stack [top + 1] = a;
    top += 1;

    printf ("The item has been added\n");
}

int pop()
{
    int ret = stack [top];
    top -= 1;
    int x = display ();
    return ret;
}

void delete()
{
    printf ("\nThe stack will be deleted\n");
    display ();
    top = -1;
}

int main()
{
    int in = 1, x;
    while (in != 0)
    {
        printf ("\n\nEnter the number for the option you want to choose\n\n");
        printf ("1 : Push to stack\n");
        printf ("2 : Pop from stack\n");
        printf ("3 : Delete stack\n");
        printf ("4 : Display stack\n");
        printf ("0 : Exit Program\n");
        printf ("\nEnter the choice you want : ");
        scanf ("%d", &in);

        switch (in)
        {
        case 0:
            break;

        case 1:
            push ();
            break;
        
        case 2:
            x = pop ();
            printf ("\nThe element popped is : %d", x);
            break;
        
        case 3:
            delete ();
            break;

        case 4:
            display ();
            break;
        
        default:
            printf ("\nWrong input, try again");
            break;
        }
    }
    return 0;
}
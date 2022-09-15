/**
 * Steps to convert:
 * 
 * - put expression in parenthesis
 * - while (expression is not empty)
 *   - if (next char == operand): print it
 *   - if (next char == open bracket): push into stack
 *   - if (next char == operator):
 *     - if (last operator in stack HIGH/SAME precedence as new): pop previous, push new
 *     - if (last operator in stack NO/LOW precedence as new): push new
 *   - if (next char == close bracket): pop till next close bracket
 * 
 */

#include <stdio.h>
#include "StackWithLinkedList.c"

int main(int argc, char const *argv[])
{
    // highest precedence at [0] and lowest at [end]
    char precedence [] = {'*', '/', '+', '-'};

    char infix[50], postfix[50], trash;
    int i = 0, pfEnd = 0;

    printf ("Enter the expression with (no spaces please): ");
    scanf ("%[^\n]s", infix);

    struct Node* start = create ();
    push (&start, '(');
    display (start);

    while (infix[i] != 0)       // when ASCII becomes zero -> end of usable part
    {
        char ch = infix[i];
        printf ("\n%d %c", ch, ch);

        // categorize the characters
        if (ch == '(')
        {
            push(&start, '(');
        }
        else if (ch == '0' || ch == '1' || ch == '2' || ch == '3' || ch == '4' || 
                 ch == '5' || ch == '6' || ch == '7' || ch == '8' || ch == '9') 
        {
            postfix[pfEnd] = ch;
        }
        else if (ch == ')')
        {
            while (peek (start) != '(')
            {
                postfix[pfEnd] = pop (&start);
                pfEnd++;
            }
            if (peek (start) == '(')
                trash = pop (&start);
        }
        else if (ch == '+' || ch == '-')
        {
            postfix[pfEnd] = pop (&start);
            push (&start, ch);
        }
        else if (ch == '*' || ch == '/')
        {
            if (peek(start) == '*' || peek(start) == '*')
            {
                postfix[pfEnd] = pop (&start);
            }
            push (&start, ch);
        }

        i++;
        printf ("\nReached end of iterationn");
    }

    printf ("\nExited the stack loop");

    // prints the input string
    for (int i = 0; i < 50; i++)
        printf ("%d ", infix[i]);

    display (start);

    // popping all the remaining elements in the stack
    if (peek(start) != '(')
    {
        while (peek(start) != '(')
        {
            printf ("\nIn final pop loop\n");
            postfix[pfEnd] = pop(&start);
            pfEnd++;
        }
    }
    // reached end of popping useful elements
    else if (peek (start) == '(')
    {
        trash = pop (&start);
    }

    printf ("resulting expression is: %s", postfix);

    return 0;
}

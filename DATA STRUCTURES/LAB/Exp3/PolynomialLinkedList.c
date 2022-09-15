/**
 * Experiment 3: Implementation of polynomials operations (addition, subtraction) using link list
 * 
 * Functions:
 * - Create Linked Lists (for polynomials)
 *   - (Done) Add element
 *   - (Do it later) Remove element (?)
 * - Add Polynomials
 *   - (Done) Create a new linked list while traversing the existing lists
 * - Subtract Polynomials
 *   - (Done) Create a new linked list while traversing the existing lists
 * - (Done) Add menu
 */

#include <stdio.h>
#include <stdlib.h>
// #include "LinkedList.c"

/**
 * The individual node of the linked list data structure
 */
struct Node {
    int exp;
    int coef;
    struct Node *link;
};

struct Node* create ();
void addNode (struct Node **start, int exp, int coef);
void display (struct Node *start);
struct Node* subPolys (struct Node **poly1, struct Node **poly2);
struct Node* addPolys (struct Node **poly1, struct Node **poly2);

/**
 * returns a null pointer which is the start of a new linked list
 */
struct Node* create ()
{
    struct Node* start = NULL;
    return start;
}

/**
 * Adds a node with given exponent and coefficient to the given linked list pointer, sorted in descending order with regards to the exponent field of the linked list
 */
void addNode (struct Node **start, int exp, int coef)
{
    struct Node *tmp, *prev, *next;
    prev = NULL;
    next = *start;

    // stores the new node
    tmp = (struct Node*) malloc (sizeof(struct Node));
    tmp->exp = exp;
    tmp->coef = coef;
    tmp->link = NULL;

    // addition at start when exponent is greater than the one at start
    if ((!(*start)) || (exp > (*start)->exp)) {
        tmp->link = *start;
        *start = tmp;
    }
    // addition in between
    else {
        for (int i = 0; (exp < next->exp) && (next->link != NULL); i++) {
            prev = next;

            // on intermediate node
            if (next->link != NULL) {
                next = next->link;
            }
        }

        if  (exp == next->exp) {
            // for when exponent is repeated, replace
            next->exp = exp;
        } else {
            if (exp > next->exp) {
                // intermediate node only
                // link next node to new node
                tmp->link = next;
                prev->link = tmp;
            }
            else
            {
                // last node
                next->link = tmp;
            }
        }
    }
}

/**
 * displays the exponent and coefficient of the polynomial terms as stored in the linked list
 */
void display (struct Node *start)
{
    struct Node *q = start;

    printf ("\n\nThe elements are: ");
    while (q != NULL) {
        printf ("\nexp: %d  coef: %d", q->exp, q->coef);
        q = q->link;
    }
}

struct Node* addPolys (struct Node **poly1, struct Node **poly2)
{
    struct Node *sumPoly = create (), *temp1 = *poly1, *temp2 = *poly2;
    int sum, ind = 0;
    int *added = (int*) malloc (sizeof(int)*20);

    while (temp1 != NULL || temp2 != NULL)
    {
        if (temp1->exp > temp2->exp)
        {
            // go ahead in temp 1
            temp1 = temp1->link;
        }
        else if (temp1->exp < temp2->exp)
        {
            // go ahead in temp 2
            temp2 = temp2->link;
        }
        else if (temp1->exp == temp2->exp)
        {
            // add exponent
            sum = temp1->coef + temp2->coef;
            addNode (&sumPoly, temp1->exp, sum);
            *(added + ind) = temp1->exp;

            temp1 = temp1->link;
            temp2 = temp2->link;
            ind++;
        }
    }

    // move the nodes that only exist in one linked list to the sumPoly list

    int nind = 0;
    temp1 = *poly1;
    temp2 = *poly2;

    while (temp1 != NULL) {
        if (temp1->exp > *(added + nind)) {
            addNode (&sumPoly, temp1->exp, temp1->coef);
            temp1 = temp1->link;
        } else if (temp1->exp == *(added + nind)) {
            temp1 = temp1->link;
            nind++;
        }
    }

    nind = 0;
    while (temp2 != NULL) {
        if (temp2->exp > *(added + nind))  {
            addNode (&sumPoly, temp2->exp, temp2->coef);
            temp2 = temp2->link;
        } else if (temp2->exp == *(added + nind)) {
            temp2 = temp2->link;
            nind++;
        }
    }
    printf ("\nThe addition is done");
    display (sumPoly);

    return sumPoly;
}

struct Node* subPolys (struct Node **poly1, struct Node **poly2)
{
    struct Node *subPoly = create (), *temp1 = *poly1, *temp2 = *poly2;
    int sub, ind = 0;
    int *subbed = (int*) malloc (sizeof(int)*20);

    while (temp1 != NULL || temp2 != NULL)
    {
        if (temp1->exp > temp2->exp)
        {
            // go ahead in temp 1
            temp1 = temp1->link;
        }
        else if (temp1->exp < temp2->exp)
        {
            // go ahead in temp 2
            temp2 = temp2->link;
        }
        else if (temp1->exp == temp2->exp)
        {
            // add exponent
            sub = temp1->coef - temp2->coef;
            addNode (&subPoly, temp1->exp, sub);
            *(subbed + ind) = temp1->exp;

            temp1 = temp1->link;
            temp2 = temp2->link;
            ind++;
        }
    }

    // move the nodes that only exist in one linked list to the subPoly list

    int nind = 0;
    temp1 = *poly1;
    temp2 = *poly2;

    while (temp1 != NULL) {
        if (temp1->exp > *(subbed + nind)) {
            addNode (&subPoly, temp1->exp, temp1->coef);
            temp1 = temp1->link;
        } else if (temp1->exp == *(subbed + nind)) {
            temp1 = temp1->link;
            nind++;
        }
    }

    nind = 0;
    while (temp2 != NULL) {
        if (temp2->exp > *(subbed + nind))  {
            addNode (&subPoly, temp2->exp, -(temp2->coef));
            temp2 = temp2->link;
        } else if (temp2->exp == *(subbed + nind)) {
            temp2 = temp2->link;
            nind++;
        }
    }
    printf ("\nThe subtraction is done");
    display (subPoly);

    return subPoly;
}

/**
 * Adds the values to the linked list from user
 */
void setPoly (struct Node **poly) {
    int ch;
    int exp, coef;

    do
    {
        printf ("\nEnter exponent of the term: ");
        scanf ("%d", &exp);
        printf ("Enter coefficient for exponent %d: ", exp);
        scanf ("%d", &coef);
        addNode (poly, exp, coef);
        printf ("Do you want to finish the polynomial? (0 for no, 1 for yes): ");
        scanf ("%d", &ch);
    } while (ch != 1);

    display (*poly);
}

int main(int argc, char const *argv[])
{
    int ch;
    struct Node *poly1, *poly2;

    do
    {
        printf ("\n\nPolynomial addition and subtraction");
        printf ("\n\n1 - Create the polynomials");
        printf ("\n2 - Set polynomial 1");
        printf ("\n3 - Set polynomial 2");
        printf ("\n4 - Show polynomials");
        printf ("\n5 - Add polynomials");
        printf ("\n6 - Subtract polynomial 1 from 2");
        printf ("\n7 - Subtract polynomial 2 from 1");
        printf ("\n0 - Exit");
        printf ("\n\nEnter your choice: ");
        scanf ("%d", &ch);

        switch (ch)
        {
        case 0:
            break;

        case 1:
            poly1 = create ();
            poly2 = create ();
            break;

        case 2:
            setPoly (&poly1);
            break;

        case 3:
            setPoly (&poly2);
            break;

        case 4:
            display (poly1);
            display (poly2);
            break;

        case 5:
            addPolys (&poly1, &poly2);
            break;

        case 6:
            subPolys (&poly2, &poly1);
            break;

        case 7:
            subPolys (&poly1, &poly2);
            break;
        
        default:
            printf ("Invalid input, please choose according to the menu");
            break;
        }
    } while (ch != 0);
    
    return 0;
}



void test () {
    struct Node *poly1 = create ();
    // printf ("\n%p %p", &poly1, poly1);

    // Polynomial is:
    // deg  7   5   3   2   0
    // coef 4   7   10  5   3
    // addNode (&poly1, 2, 5); 
    // addNode (&poly1, 5, 7); 
    // addNode (&poly1, 3, 10); 
    // addNode (&poly1, 7, 4); 
    // addNode (&poly1, 0, 3); 
    // display (poly1);
    setPoly (&poly1);

    struct Node *poly2 = create ();

    // Polynomial is:
    // deg  6   5   4   3   1   0
    // coef 8   4   2   7   6   1
    // addNode (&poly2, 6, 8);
    // addNode (&poly2, 3, 7);
    // addNode (&poly2, 1, 6);
    // addNode (&poly2, 5, 4);
    // addNode (&poly2, 0, 1);
    // addNode (&poly2, 4, 2);
    // display (poly2);
    setPoly (&poly2);

    printf ("\n%p %p", poly1, poly2);
    struct Node *sumPoly = addPolys (&poly1, &poly2);
    struct Node *subPoly = subPolys (&poly1, &poly2);
}
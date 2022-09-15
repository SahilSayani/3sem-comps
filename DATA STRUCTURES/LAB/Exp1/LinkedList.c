/** 
 * IMPORTANT: Status - The code has been rectified, there might be some bugs but they're only the ones which happen after very special cases like printing the elements after deleting all the items in the list. Overall can consider code to be done and working.
 * 
 * Question: 
 * Menu driven program that would have provision for   create, insert, delete, search an item, display, destroy and exit menus
 * in unsorted linked list, user should be given option where to insert the element, i.e. before the first item, after the last item, general case before or after some item
 * Your topic: unsorted linked list
 * 
 * My approach:
 * Functions:
 * (all done) - Addition
 *   - In between
 *   - Start
 *   - End
 * (all done) - Deletion
 *   - In between
 *   - Start
 *   - End
 * (done) - Creation
 * - Search
 * (done) - Display all
 * - Destroy
 * 
 * for deletion:
 * - at start: free node and start = start->link
 * - in between: free node and prev->link = cur->link
 * - at end: free node and prev->link = NULL
 */

#include <stdio.h>
#include <stdlib.h>

struct Node
{
    int data;
    struct Node* link;
};

struct Node* create ();
void addNode (struct Node **start, int data, int ind);
char deleteNode (struct Node **start, int ind);
void display (struct Node* start);
void delete (struct Node **start);
int search (struct Node* start, int item);

struct Node* create ()
{
    struct Node* start = NULL;
    return start;
}

// adds the new node such that the index of the new node is the index which is passed
void addNode (struct Node **start, int data, int ind)
{
    struct Node *tmp, *prev, *next;
    prev = NULL;
    next = *start;

    // stores the new node
    tmp = (struct Node*) malloc (sizeof(struct Node));
    tmp->data = data;
    tmp->link = NULL;

    // addition at start
    if (ind == 0) {
        tmp->link = *start;
        *start = tmp;
    }
    // addition in between
    else if (ind > 0) {
        for (int i = 0; i < ind; i++) {
            prev = next;

            // on intermediate node
            if (next->link != NULL) {
                next = next->link;
            }
        }

        // intermediate node only
        if (next != prev) {
            // link next node to new node
            tmp->link = next;
        }

        // link new node to previous node
        prev->link = tmp;
    }

    printf ("\nThe value %d has been added to the linked list", data);
}

// deletion based on the index of the item to be deleted
char deleteNode (struct Node **start, int ind)
{
    char ch;
    struct Node *cur, *prev = NULL, *tofree;
    cur = *start;        // cur = ind(0)

    if (ind == 0 && (*start)->link == NULL) {
        *start = NULL;
    }
    // item to be deleted is first item
    else if (ind == 0){
        tofree = cur;
        *start = cur->link;

        free (tofree);
    }
    // item to be deleted is not the first item
    else if (ind > 0) {
        for (int i = 0; i < ind; i++) {
            prev = cur;

            // for intermediate nodes only
            if (cur->link != NULL) {
                cur = cur->link;
            }
        }

        // adjusting pointers
        // for intermediate node
        if (cur != prev) {
            prev->link = cur->link;
        }
        // for last node
        else if (cur == prev) {
            prev->link = NULL;
        }

        free(cur);
    }

    return ch;
}

void display (struct Node *start)
{
    struct Node *q = start;

    printf ("\n\nThe elements are: ");
    while (q != NULL) {
        printf ("%d  ", q->data);
        q = q->link;
    }
}

void delete (struct Node **start)
{
    printf ("All the elements will be deleted");

    while (*start != NULL) {
        deleteNode (start, 0);
    }
}

int search (struct Node *start, int item)
{
    struct Node* cur = start;
    int count;

    // go through all the nodes until the item is found
    while (cur -> link != NULL && cur -> data != item) {
        count++;
        cur = cur -> link;
    }

    if (cur -> data == item) {
        return count;
    } else {
        return -1;
    }
}

int main(int argc, char const *argv[])
{
    int ch = 1, data = 0, ind = 0, item = 0;
    struct Node *start = NULL;

    do
    {
        printf ("\n\nOperations for the Linked List");
        printf ("\n\n1. Create Linked List");
        printf ("\n2. Add new element to Linked List");
        printf ("\n3. Display the items in the Linked List");
        printf ("\n4. Remove an element from the Linked List ");
        printf ("\n5. Delete the Linked List");
        printf ("\n6. Search for an element in the Linked List");
        printf ("\n0. Exit");
        printf ("\n\nEnter your choice: ");
        scanf ("%d", &ch);

        switch (ch)
        {
        case 1:
            start = create();
            printf ("\n\nLinked List has been created successfully!");
            break;

        case 2:
            printf("\n\nEnter the character to add to the list: ");
            scanf("%d", &data);
            printf("Enter the position to where the data should be added to the list: ");
            scanf("%d", &ind);
            addNode (&start, data, ind);
            break;

        case 3:
            display (start);
            break;

        case 4:
            printf ("\n\nEnter the position of the element to be deleted: ");
            scanf ("%d", &ind);
            deleteNode (&start, ind);
            break;

        case 5:
            delete (&start);
            break;

        case 6:
            printf ("\n\nEnter the element to be searched: ");
            scanf ("%d", &item);
            ind  = search (start, item);
            
            if (ind > -1) {
                printf ("\nThe element was found at position %d", ind);
            } else if (ind = -1) {
                printf ("\nThe element was not found");
            }

            break;
        
        default:
            break;
        }
    } while (ch != 0);
    
    return 0;
}

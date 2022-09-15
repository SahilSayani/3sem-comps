/**
 * Simple Queue using Linked List
 * 
 * Functions required
 * (done) - Create
 * (done) - Enqueue
 * (done) - Dequeue
 * (done) - Display
 * - Search (if you have time)
 * - Destroy
*/

#include <iostream>
#include <conio.h>

struct Node
{
    char data;
    struct Node *link;
};

class QueueLinkedList
{
    public: struct Node **create ()
    {
        struct Node **nodes = (struct Node **)malloc(2 * sizeof(struct Node *));

        *nodes = nullptr;
        *(nodes + 1) = nullptr;

        printf ("Queue Created");

        return nodes;
    }

    public: void addNode(struct Node **nodes, int data)
    {
        // make a new temporary node
        struct Node *temp;
        temp = (struct Node *)malloc(sizeof(struct Node));
        temp->data = data;
        temp->link = nullptr;

        // change pointer values

        temp->link = *nodes; // setting previous first node as link for new first node
        *nodes = temp;       // setting new first node as *nodes
        // printf ("\nadded node");

        if (*(nodes + 1) == nullptr) {
            // if its the first node, then assign same value to rear
            *(nodes + 1) = *nodes;
            // printf ("\nset rear node");
        }
    }

    public: int deleteNode(struct Node **nodes)
    {
        struct Node *start = *nodes, *rear = *(nodes + 1);
        struct Node *q = start;

        // get data from rear node
        int data = rear->data;

        // set rear to previous node (how?)
        // setting rear as second to last node by starting from first node (I know this is cheating but i cant find a better way) (actually it's not cheating)
        if (q == rear)
        {
            // empty queue, set all pointers to nullptr
            *nodes = nullptr;
            *(nodes + 1) = nullptr;
        }
        else
        {
            while (q->link != rear)
            {
                q = q->link;
            }
            if (q->link == rear)
            {
                free(rear);
                rear = q;
                rear->link = nullptr;
            }

            *(nodes + 1) = rear;
        }
        return data;
    }

    public: void display(struct Node *start)
    {
        struct Node *q = start;

        printf("\n\nThe values in the queue are:\n");
        while (q != nullptr)
        {
            printf("%d  ", q->data);
            q = q->link;
        }
    }

    public: void destroy(struct Node **nodes)
    {
        int res;
        printf("All the elements will be deleted");

        while (*nodes != nullptr)
        {
            res = this->deleteNode(nodes);
            printf ("\nThe dequeued value is: %d", res);
        }
    }

    public: int search (struct Node **nodes, int value) {
        int pos = 0;
        struct Node *q = *nodes, *rear = *(nodes + 1);

        if (!q) {
            // queue is empty
            printf ("\nnQueue is empty, cannot search element");
            pos = -1;
        } else {
            while (q->data != value && q->link != NULL)
            {
                // printf("\nq = %p, pos = %d", q, pos);
                q = q->link;
                pos++;
            }

            if (q->data != value && q->link == NULL)
            {
                pos = -1;
                printf("\nEnd of queue reached");
            }
        }
        return pos;
    }
};

int main(int argc, char const *argv[])
{
    QueueLinkedList queue;
    struct Node **nodes = queue.create();
    // struct Node *start, *rear;

    int exit = 0, ch, data, res, value;

    do
    {
        // printf ("\n\nValues of pointers: %p %p ", *nodes, *(nodes+1));
        printf("\n\nOptions\n\n");
        printf("1. Add to queue\n");
        printf("2. Remove from queue\n");
        printf("3. Display queue\n");
        printf ("4. Search element in stack\n");
        printf ("5. Delete stack\n");
        printf("0. Exit\n\n");
        printf("Enter your choice: ");
        scanf("%d", &ch);

        switch (ch)
        {
        case 1:
            printf("\nEnter the number to enqueue: ");
            scanf("%d", &data);
            queue.addNode(nodes, data);
            queue.display(*nodes);
            break;

        case 2:
            res = queue.deleteNode(nodes);
            printf ("\nThe dequeued value is: %d", res);
            queue.display(*nodes);
            break;

        case 3:
            queue.display(*nodes);
            break;

        case 4:
            printf ("\nEnter the value to search: ");
            scanf ("%d", &value);

            res = queue.search (nodes, value);

            if (res >= 0) {
                printf ("\nThe value was found at index: %d", res);
            } else if (res == -1) {
                printf ("\nThe value was not found in the queue");
            }
            break;

        case 5:
            queue.destroy(nodes);
            queue.display(*nodes);
            break;

        case 0:
            exit = 1;
            break;

        default:
            printf("Invalid choice, try again \n\n");
            break;
        }
    } while (exit == 0);

    return 0;
}
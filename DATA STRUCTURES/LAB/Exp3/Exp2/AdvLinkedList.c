#include <stdio.h>
#include <stdlib.h>
#include <assert.h>

struct Node
{
    int data;
    struct Node *next;
};

int getCount(struct Node *head);
static void reverse(struct Node **headRef);
void push(struct Node **headRef, int newData);
void printList(struct Node *head);
struct Node *concatenate(struct Node *a, struct Node *b);
void MoveNode(struct Node **desRef, struct Node **sourceRef);
int isPresent(struct Node *head, int data);
struct Node *intersect(struct Node *head1, struct Node *head2);
void reverseF();
void intersecnF();
void mergeF();

int getCount(struct Node *head)
{
    struct Node *current = head;
    int count = 0;
    while (current != NULL)
    {
        count++;
        current = current->next;
    }
    return count;
}

static void reverse(struct Node **headRef)
{
    struct Node *prev = NULL;
    struct Node *current = *headRef;
    struct Node *next = NULL;
    while (current != NULL)
    {
        next = current->next;
        current->next = prev;
        prev = current;
        current = next;
    }
    *headRef = prev;
}

void push(struct Node **headRef, int newData)
{
    struct Node *newNode = (struct
                            Node *)malloc(sizeof(struct Node));
    newNode->data = newData;
    newNode->next = (*headRef);
    (*headRef) = newNode;
}

void printList(struct Node *head)
{
    struct Node *temp = head;
    while (temp != NULL)
    {
        printf("%d ", temp->data);
        temp = temp->next;
    }
}

struct Node *concatenate(struct Node *a, struct Node *b)
{
    struct Node demo;
    struct Node *tail = &demo;
    demo.next = NULL;
    while (1)
    {
        if (a == NULL)
        {
            tail->next = b;
            break;
        }
        else if (b == NULL)
        {
            tail->next = a;
            break;
        }
        if (a->data <= b->data)
            MoveNode(&(tail->next), &a);
        else
            MoveNode(&(tail->next), &b);
        tail = tail->next;
    }
    return (demo.next);
}

void MoveNode(struct Node **desRef, struct Node **sourceRef)
{
    struct Node *newNode = *sourceRef;
    assert(newNode != NULL);
    *sourceRef = newNode->next;
    newNode->next = *desRef;
    *desRef = newNode;
}

int isPresent(struct Node *head, int data)
{
    struct Node *t = head;
    while (t != NULL)
    {
        if (t->data == data)
            return 1;
        t = t->next;
    }
    return 0;
}

struct Node *intersect(struct Node *head1, struct Node *head2)
{
    struct Node *result = NULL;
    struct Node *t1 = head1;
    while (t1 != NULL)
    {
        if (isPresent(head2, t1->data))
            push(&result, t1->data);
        t1 = t1->next;
    }
    return result;
}

void reverseF()
{
    struct Node *head = NULL;
    printf("Enter 0 to stop giving input to this linked list\n");
    int x;
    scanf("%d", &x);
    while (x != 0)
    {
        push(&head, x);
        scanf("%d", &x);
    }
    printf("Given linked list:\n");
    reverse(&head);
    printList(head);
    reverse(&head);
    printf("\nReversed Linked list: \n");
    printList(head);
    getchar();
    printf("\n");
}

void intersecnF()
{
    struct Node *head1 = NULL;
    struct Node *head2 = NULL;
    struct Node *intersection = NULL;
    printf("Enter 0 to stop giving input to first linked list\n");
    int x;
    scanf("%d", &x);
    while (x != 0)
    {
        push(&head1, x);
        scanf("%d", &x);
    }
    printf("Enter 0 to stop giving input to second linked list\n");
    scanf("%d", &x);
    while (x != 0)
    {
        push(&head2, x);
        scanf("%d", &x);
    }
    intersection = intersect(head1, head2);
    printf("\nIntersection list is \n");
    printList(intersection);
    printf("\n");
}

void mergeF()
{
    struct Node *res = NULL;
    struct Node *a = NULL;
    struct Node *b = NULL;
    printf("Enter 0 to stop giving input to First linked list\n");
    int x;
    scanf("%d", &x);
    while (x != 0)
    {
        push(&a, x);
        scanf("%d", &x);
    }
    reverse(&a);
    printf("Enter 0 to stop giving input to Second Linked List\n");
    scanf("%d", &x);
    while (x != 0)
    {
        push(&b, x);
        scanf("%d", &x);
    }
    reverse(&b);
    res = concatenate(a, b);
    printf("Merged Linked List is: \n");
    printList(res);
    printf("\n");
}

int main()
{
    printf("Enter \n1: To reverse a linked list.\n2: To find intersection of linked lists.\n3: To concatenate linked lists.\n0: To exit\n");
    int x;
    scanf("%d", &x);
    while (x != 0)
    {
        switch (x)
        {
        case 1:
            reverseF();
            break;
        case 2:
            intersecnF();
            break;
        case 3:
            mergeF();
            break;
        }
        scanf("%d", &x);
    }
    return 0;
}
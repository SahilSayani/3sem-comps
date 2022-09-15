
/**
 * IMPORTANT: SUBMISSION ON SUNDAY (22-NOV) YOU HAVE TO RUNNNN!!!!
 * 
 * 
 */

#include <iostream>
#include <conio.h>

struct Node
{
    char data;
    struct Node *link;
};

class BFS
{
public:
    BFS();
    ~BFS();
    struct Node** create ();
    void addNode(struct Node **nodes, int data);
    int deleteNode(struct Node **nodes);
    void display(struct Node *start);
};

BFS::BFS () {}

struct Node** BFS::create() {
    struct Node **nodes = (struct Node **)malloc(2 * sizeof(struct Node *));

    *nodes = nullptr;
    *(nodes + 1) = nullptr;

    // printf("Queue Created");

    return nodes;
}

void BFS::addNode(struct Node **nodes, int data) {
    // make a new temporary node
    struct Node *temp;
    temp = (struct Node *)malloc(sizeof(struct Node));
    temp->data = data;
    temp->link = nullptr;

    // change pointer values

    temp->link = *nodes; // setting previous first node as link for new first node
    *nodes = temp;       // setting new first node as *nodes
    // printf ("\nadded node");

    if (*(nodes + 1) == nullptr)
    {
        // if its the first node, then assign same value to rear
        *(nodes + 1) = *nodes;
        // printf ("\nset rear node");
    }
}

int BFS::deleteNode(struct Node **nodes) {
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

void BFS::display(struct Node *start)
{
    struct Node *q = start;

    printf("\nThe values in the queue are:  ");
    while (q != nullptr)
    {
        printf("%d  ", q->data);
        q = q->link;
    }
}

int main(int argc, char const *argv[])
{
    /**
     * add the first node to the queue
     * while queue not empty
     * enqueue at the end, dequeue at the start
     */

    //      1    2    3    4    5    6    7
    // 1    0    1    0    0    0    0    0
    // 2    1    0    1    1    1    0    0
    // 3    0    1    0    1    0    0    0
    // 4    0    1    1    0    0    1    0
    // 5    0    1    0    0    0    0    1
    // 6    0    0    0    1    0    0    0
    // 7    0    0    0    0    1    0    0

    // int graph[7][7] = {{0, 1, 0, 0, 0, 0, 0},
    //                    {1, 0, 1, 1, 1, 0, 0},
    //                    {0, 1, 0, 1, 0, 0, 0},
    //                    {0, 1, 1, 0, 0, 1, 0},
    //                    {0, 1, 0, 0, 0, 0, 1},
    //                    {0, 0, 0, 1, 0, 0, 0},
    //                    {0, 0, 0, 0, 1, 0, 0}};

    //     a   b   c   d   e   f
    // a   0   1   1   0   0   1
    // b   1   0   1   0   1   0
    // c   1   1   0   1   0   0
    // d   0   0   1   0   1   1
    // e   0   1   0   1   0   1
    // f   1   0   0   1   1   0

    int graph[6][6] = {{0, 1, 1, 0, 0, 1},
                       {1, 0, 1, 0, 1, 0},
                       {1, 1, 0, 1, 0, 0},
                       {0, 0, 1, 0, 1, 1},
                       {0, 1, 0, 1, 0, 1},
                       {1, 0, 0, 1, 1, 0}};
    
    int rowlen = sizeof(graph[0])/sizeof(graph[0][0]);
    int collen = sizeof(graph)/sizeof(graph[0]);
    int status [rowlen] = {0};
    int BFSorder [rowlen] = {0};
    int bfsind = 0;

    BFS *bfs = new BFS;
    struct Node **nodes = bfs->create ();
    int firstNode = 0;
    int curNode;

    printf ("\n\nThe graph is:\n\n");
    for (int i = 0; i < rowlen; i++)
    {
        printf ("%d ", i);
    }
    printf ("\n\n");
    for (int i = 0; i < collen; i++)
    {
        for (int j = 0; j < rowlen; j++)
        {
            printf ("%d ", graph[i][j]);
        }
        printf ("  %d\n", i);
    }

    printf ("\n\nBFS Traversal");
    bfs->addNode (nodes, firstNode);

    while (*nodes != nullptr) {
        // get current node from queue
        curNode = bfs->deleteNode (nodes);
        while (status[curNode] == 1) {
            curNode = bfs->deleteNode (nodes);
        }

        // changing status to visited 
        status[curNode] = 1;
        printf ("\n\ncurrent node: %d", curNode);

        // find neighbours and push them on stack
        for (int i = 0; i < rowlen; i++)
        {
            // neighbour condition         unvisited condition
            if (graph [curNode][i] == 1 && status[i] == 0) {
                bfs->addNode (nodes, i);
                // printf ("\n%d added to the BFS sequence", i);
            }
        }

        bfs->display(*nodes);
        BFSorder[bfsind] = curNode;
        bfsind++;

        printf ("\nBFS Sequence: ");
        for (int i = 0; i < bfsind; i++)
        {
            printf ("%d  ", BFSorder[i]);
        }
    }

    return 0;
}

void test () {
    BFS *bfs = new BFS;
    struct Node **nodes = bfs->create();

    bfs->addNode (nodes, 3);
    bfs->display (*nodes);
    bfs->addNode (nodes, 7);
    bfs->display (*nodes);
    bfs->deleteNode (nodes);
    bfs->display (*nodes);
    bfs->addNode (nodes, 6);
    bfs->display (*nodes);
    bfs->addNode (nodes, 10);
    bfs->display (*nodes);
    bfs->deleteNode (nodes);
    bfs->display (*nodes);
    bfs->addNode (nodes, 4);
    bfs->display (*nodes);
    bfs->deleteNode (nodes);
    bfs->display (*nodes);
    bfs->deleteNode (nodes);
    bfs->display (*nodes);
}
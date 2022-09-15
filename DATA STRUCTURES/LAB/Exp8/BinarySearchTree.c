// DATA STRUCTURES LAB 
// (aka the bane of my existance for semester 3)

// BSD IMPLEMENTATION
// Implement
// - Insertion
// - Traversal
//   - Inorder
//   - Postorder
//   - Preorder
// - Search

#include <stdio.h>
#include <stdlib.h>

struct Node
{
    int data;
    struct Node *left, *right;
};

struct Node* create ();
void insert (struct Node **start, int data);
void inorder (struct Node* tree);
void postorder (struct Node* tree);
void preorder (struct Node* tree);

struct Node* create () {
    struct Node* start = NULL;
    return start;
}

void insert (struct Node **start, int data) {
    printf ("\nEntered insert function");

    struct Node* temp = (struct Node*) malloc (sizeof(struct Node*));
    struct Node* q = *start;
    temp -> data = data;
    temp -> left = NULL;
    temp -> right = NULL;

    if (*start == NULL) {
        printf ("\nfirst time here!");
        *start = temp;
        printf ("    %d", temp->data);
    } else {
        printf ("\nReturning customer :D");

        // checking for leaf node
        while (q -> left == NULL && q -> right == NULL) {
            printf ("%d  ", q->data);
            if (data == q->data) {
                break;
            }
            // moving to left node
            else if (data < q->data) {
                q = q->left;
            }
            // moving to right node
            else if (data > q->data) {
                q = q->right;
            }
        }

        // adding to left of leaf
        if (data < q->data) {
            q->left = temp;
            printf ("\nAdded %d to left child\n", q->left->data);            
        }
        // adding to right of leaf
        else if (data > q->data) {
            q->right = temp;
            printf ("\nAdded %d to right child\n", q->right->data);
        }
    }
}

void inorder (struct Node *tree) {
    printf ("\nInorder: ");
    if (tree != NULL) {
        inorder(tree->left);
        printf("%d  ", tree->data);
        inorder(tree->right);
    }
}

void preorder(struct Node *tree) {
    printf ("\nPreorder: ");
    if (tree != NULL) {
        printf("%d  ", tree->data);
        preorder(tree->left);
        preorder(tree->right);
    }
}

void postorder(struct Node *tree) {
    printf ("\nPostorder: ");
    if (tree != NULL) {
        postorder(tree->left);
        postorder(tree->right);
        printf("%d  ", tree->data);
    }
}

int main(int argc, char const *argv[]) {
    int ch, temp;
    struct Node* tree = create ();
    // int *data = (int*) malloc (20*sizeof(int));
    
    do
    {
        printf ("\nBinary Search Tree\n");
        printf ("\n1. Insert the numbers");
        printf ("\n2. Traversing the Tree");
        printf ("\n3. Search the Tree");
        printf ("\n0. Exit\n");
        printf ("\nEnter your choice: ");
        scanf ("%d", &ch);

        switch (ch)
        {
        case 1:
            printf ("\nEnter the number. Enter -1 after last number\n");
            while (1) {
                scanf ("\n%d", &temp);
                printf ("  %d  ", temp);
                if (temp == -1) {
                    break;
                }
                insert(tree, temp);
            }
            break;
        
        case 2:
            inorder (tree);
            postorder (tree);
            preorder (tree);
            break;

        default:
            break;
        }
    } while (ch != 0);
    
    return 0;
}

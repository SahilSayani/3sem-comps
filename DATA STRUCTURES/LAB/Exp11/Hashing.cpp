/** 
 * Linear Probing Single Hashing
 * 
 * Input: Series of Keys
 * Output: The location it is stored at
 * 
 * - Input % (no. of spaces) = index
 * - If collision: move to the next space
 * - Show the entire array
 */

#include <iostream>
#include <conio.h>

int array [20] = {0};
int len = sizeof(array)/sizeof(array[0]);

int main(int argc, char const *argv[])
{
    int newkey, newind;

    for (int i = 0; i < len; i++)
    {
        printf("\n\nEnter the next index: ");
        scanf("%d", &newkey);

        newind = newkey % len;

        // if there is a collision
        while (array[newind] != 0) {
            newind++;
        }

        array[newind] = newkey;

        printf ("\nArray keys:\n");
        for (int j = 0; j < len; j++)
        {
            printf ("%d  ", array[j]);
        }
    }
    return 0;
}

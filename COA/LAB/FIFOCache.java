// package Lab;

import java.util.Scanner;
import java.util.Vector;

/**
 * Steps:
 * - make data structure for Cache (I prefer vector) - cache
 * - make data structure for storing the earliest entry - firstin
 * - Additon function
 *   - check entire array for empty place, if not only then proceed
 *   - check if there's hit
 *   - if not then check firstin for the entry to remove
 *   - remove the entry
 *   - add new entry
 *   - ta-da
 */

public class FIFOCache {
    int cache[] = new int[3];
    // Vector<Integer> cache = new Vector<Integer> (3);
    Vector<Integer> firstin = new Vector<Integer> (10);
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        FIFOCache obj = new FIFOCache ();
        int inp, remInd = 0;
        boolean isfound = false;

        do {
            isfound = false;

            System.out.println("\n\nEnter the numbers for the cache, enter -1 at the end");
            inp = sc.nextInt();
            
            if (inp == -1) {
                break;
            }

            for (int i = 0; i < obj.cache.length; i++) {
                if (obj.cache[i] == inp) {
                    // when there is a hit
                    isfound = true;
                    System.out.println ("There was a hit!");
                    break;
                } 
            }

            if (!isfound) {
                for (int i = 0; i < obj.cache.length; i++){
                    if (obj.cache[i] == 0) {
                        // cache is empty
                        obj.cache[i] = inp;
                        obj.firstin.addElement(inp);
                        isfound = true;
                        System.out.println("adding to empty");
                        break;
                    }
                }   
            }

            if (!isfound) {
                int toRemove = obj.firstin.elementAt(remInd);
                toRemove++;

                for (int i = 0; i < obj.cache.length; i++) {
                    // remove the item which is present at the position 'remInd' in the vector
                    if (obj.cache[i] == toRemove) {
                        obj.cache[i] = inp;
                        obj.firstin.addElement(inp);
                        isfound = true;
                        System.out.println("replacing an item");
                        break;
                    }
                }
            }

            System.out.println("Items in the cache: ");
            for (int i = 0; i < obj.cache.length; i++) {
                System.out.print (obj.cache[i] + "  ");
            }

            System.out.println("\nItems in firstin: ");
            for (int i = 0; i < obj.firstin.size(); i++) {
                System.out.print (obj.firstin.elementAt(i) + "  ");
            }
            System.out.println("\nremInd: " + remInd);
        } while (inp != -1);

        sc.close();
    }
}

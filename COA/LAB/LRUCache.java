// package Lab;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class LRUCache {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        HashMap<Integer, Integer> history = new HashMap<Integer, Integer> ();
        Vector<Integer> cache = new Vector<Integer> ();
        int inp, i = 0, minpos, toRemove = 0;

        do {
            System.out.println("\n\nEnter the numbers for the cache, enter -1 at the end");
            inp = sc.nextInt();

            // if hit then print hit and skip
            if (inp == -1) {
                break;
            } else if (cache.contains(inp)) {
                System.out.println ("There was a hit!");
            } else {
                // if cache.size < 3 then push new element directly
                if (cache.size() < 3) {
                    cache.add(inp);
                    System.out.println (inp + " was added to cache successfully");
                }
                // id cache.size == 3 - remove the element with earliest position
                else if (cache.size() == 3) {
                    minpos = i;
                    for (int j = 0; j < cache.size(); j++) {
                        if (history.get(cache.elementAt(j)) < minpos) {
                            minpos = history.get(cache.elementAt(j));
                            toRemove = j;
                        }
                    }

                    cache.removeElementAt(toRemove);
                    cache.add(inp);
                    System.out.println (inp + " was added to cache successfully");
                }
            }

            // record position of latest element in all cases
            history.put(inp, i);
            i++;

            System.out.println("The cache is: " + cache.toString());
            // System.out.println("The history is: " + history.toString());
        }
         while (inp != -1);
    }
}

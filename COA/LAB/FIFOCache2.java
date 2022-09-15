// package Lab;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FIFOCache2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int inp = 0;
        
        Queue<Integer> cache = new LinkedList<> ();

        do {
            System.out.println("\n\nEnter the numbers for the cache, enter -1 at the end");
            inp = sc.nextInt();

            // if hit then print hit and skip
            if (inp == -1) {
                break;
            } else if (cache.contains(inp)) {
                System.out.println ("There was a hit!");
            } else {
                // if no hit

                    // if cache.size < 3 then push new element directly
                    if (cache.size() < 3) {
                        cache.add(inp);
                        System.out.println (inp + " was added to cache successfully");
                    }
                    // if cache.size = 3 then pop and push new element
                    else if (cache.size() == 3) {
                        cache.remove();
                        cache.add(inp);
                        System.out.println (inp + " was added to cache successfully");
                    }
            }
            
            System.out.println ("The cache is: " + cache.toString());
        } while (inp != -1);

        sc.close ();
    }    
}
/**
 * enigmaround1
 */

// package Lab;
import java.util.*;
public class enigmaround1 {

    public static void main(String[] args) {
        String encrypted, decrypt = "";
        Scanner scanner = new Scanner (System.in);

        System.out.println ("Enter String: ");
        encrypted = scanner.nextLine ();

        for (int i = 0; i < encrypted.length(); i++) {
            decrypt += (char)(encrypted.charAt(i) - 8);
        }

        System.out.println (decrypt);
    }
}
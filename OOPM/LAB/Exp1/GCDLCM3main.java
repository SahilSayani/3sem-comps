package Lab.Exp1;
import java.util.*;

public class GCDLCM3main {
    public static void main(String[] args) {
        GCDLCM3 obj = new GCDLCM3();
        Scanner scanner = new Scanner (System.in);

        System.out.println("Enter the numbers");
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int gcd = GCDLCM3.GCD(a, b);
        int lcm = obj.LCM(a, b);

        System.out.println("GCD is " + gcd + " and the LCM is " + lcm);

        scanner.close();
    }
}
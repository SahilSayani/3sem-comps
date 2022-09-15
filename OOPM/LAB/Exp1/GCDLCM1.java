package Lab.Exp1;
import java.util.*;

// Calculates the GCD recursively and LCM for 2 numbers using non-static functions

public class GCDLCM1 {

    int GCD (int a, int b)
    {
        int gcd = 0;

        if (a == 0 && b == 0);
        else if (a == 0)
            gcd = b;
        else if (b == 0)
            gcd = a;
        else if (a>b)
        {
            a = a % b;
            gcd = GCD(a, b);
        }
        else if (b>a)
        {
            b = b % a;
            gcd = GCD(a, b);
        }

        return gcd;
    }

    int LCM (int a, int b)
    {
        int gcd = GCD(a, b);
        int lcm = (a * b)/gcd;

        return lcm;
    }

    public static void main(String[] args) {
        GCDLCM1 obj = new GCDLCM1();
        Scanner scanner = new Scanner (System.in);

        System.out.println("Enter the numbers");
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int gcd = obj.GCD(a, b);
        int lcm = obj.LCM(a, b);

        System.out.println("GCD is " + gcd + " and the LCM is " + lcm);

        scanner.close();
    }
}
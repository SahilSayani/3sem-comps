package Lab.Exp1;
import java.util.*;

public class GCDLCM4main {
    public static void main(String[] args) {
        GCDLCM4 obj = new GCDLCM4();
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
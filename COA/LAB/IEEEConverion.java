// package Lab;

/**
 * Order of operations:
 * - convert whole number to binary
 * - convert fraction to binary
 * - merge the numbers
 * - convert to scientific notation (number that looks like 1.xxx * 2^x)
 * - convert exponent to binary
 * - assemble IEEE conversion by adding extra digits
 */

import java.util.Scanner;

// import sun.security.util.PropertyExpander.ExpandException;


public class IEEEConverion {
    String integerToBinary (int n)
    {
        String binary = Integer.toBinaryString(n);
        return binary;
    }

    String decimalToBinary (double n)
    {
        double deci = n;
        int digits = 0;
        String binary = "";

        while (deci % 1 > 0.0000001)
        {
            digits++;
            deci *= 10;
        }

        int div = (int) Math.pow(10, digits);
        int og = (int)deci;
        int decimal = (int)deci;
        boolean firstone = false;
        System.out.println (decimal);

        do
        {
            decimal = decimal * 2;
            int r = (int)(decimal / div);
            if (r == 1) {
                firstone = true;
            }

            decimal %= div;

            if (firstone) {
                binary = binary + r;
            }
 
            // System.out.println (r + "  " + decimal);
        } while (!(decimal == og || decimal == 0 || binary.length() == 52) && decimal >= 0);

        return binary;
    }

    int getExp (double n)
    {
        int exp = 0;
        double pow = 1;

        if (n > 1) {
            while (pow < n) {
                pow *= 2;
                exp++;
            }
        } else if (n < 1) {
            while (pow > n) {
                pow /= 2;
                exp--;
            }
        }

        return exp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        IEEEConverion number = new IEEEConverion();

        System.out.print ("Enter the number to convert: ");
        double n = scanner.nextDouble();

        scanner.close();

        String sign = n > 0 ? "0" : "1";
        n = n > 0 ? n : Math.abs(n);

        int whole = (int)(n / 1);
        double decimal = n - whole;
        System.out.println(decimal);

        String bindeci = number.decimalToBinary(decimal);
        if (whole != 0)
        {
            bindeci = number.integerToBinary(whole) + bindeci;
        }

        int exp = number.getExp(Math.abs(n));
        int doubexp = 1023 + exp;
        int singexp = 127 + exp;

        String dexpBin = number.integerToBinary(doubexp);
        String sexpBin = number.integerToBinary(singexp);

        while (dexpBin.length() < 11)
            dexpBin = "0" + dexpBin;
        while (sexpBin.length() < 8)
            sexpBin = "0" + sexpBin;

        String dbindeci = bindeci.length() > 52 ? bindeci.substring(0, 52) : bindeci;
        String sbindeci = bindeci.length() > 23 ? bindeci.substring(0, 23) : bindeci;

        System.out.println("\nSign\tExponent\tBinary");
        System.out.println(sign + "\t" + dexpBin + "\t" + dbindeci);
        // System.out.println("\nSign\tExponent\tBinary");
        System.out.println(sign + "\t" + sexpBin + "\t" + sbindeci);
        // System.out.println(exp);
    }
}

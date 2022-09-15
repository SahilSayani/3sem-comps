package Lab.Exp2;

/**
 * MyMathMain
 */

import java.util.Scanner;

public class MyMathMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        double result;

        System.out.print("Enter Choice:\n1 - sin\t\t2 - cos\nchoice: ");
        int ch = scanner.nextInt();

        if (ch == 1 || ch == 2)
        {
            System.out.print("Enter value of angle (in degrees): ");
            double deg = scanner.nextDouble();

            System.out.print("Enter number of terms: ");
            int terms = scanner.nextInt();

            if (ch == 1)
            {
                result = MyMath.sin(deg, terms);
                System.out.println("sin(" + deg + ") = " + result);
            }
            else if (ch == 2)
            {
                result = MyMath.cos(deg, terms);
                System.out.println("cos(" + deg + ") = " + result);
            }
        }
        else
            System.out.println ("Invalid Input");

        scanner.close();
    }
}
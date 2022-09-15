/*

sin and cos using taylor's series
take number of terms and angle from user

static methods
- first: calculate power
- second: calculate factorial

restrictions
- no inbuilt functions (no java.lang.Math class)
- define class MyMath which has all the math functions

Output:

Enter Choice
1 - sin		2 - cos
choice: 2

Enter value of angle (in degrees): 45
Enter number of terms: 5
cos (45) = ___

*/

package Lab.Exp2;

public class MyMath {
    static long fact (int n)
    {
        int i;
        long fact = 1;

        for (i = 1; i <= n; i++)
        {
            fact *= i;
        }

        return fact;
    }

    static double pow (double base, int exp)
    {
        int i;
        double pow = 1.0; 

        for (i = 1; i <= exp; i++)
        {
            pow *= base;
        } 

        return pow;
    }

    static double sin (double deg, int terms)
    {
        int i, n;
        double rad, result = 0;
        rad = deg*(Math.PI/180);

        for (i = 1; i <= terms; i++)
        {
            n = 2*i - 1;

            if (i % 2 == 1)
                result += (pow(rad, n)/fact(n));
            else if (i % 2 == 0)
                result -= (pow(rad, n)/fact(n));
        }
        return result;
    }

    static double cos (double deg, int terms)
    {
        int i, n;
        double rad, result = 1;
        rad = deg*(Math.PI/180);

        for (i = 1; i <= terms; i++)
        {
            n = 2*i;

            if (i % 2 == 1)
                result -= (pow(rad, n)/fact(n));
            else if (i % 2 == 0)
                result += (pow(rad, n)/fact(n));
        }
        return result;
    }
}
package Lab.Exp1;

public class GCDLCM4 {
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
}
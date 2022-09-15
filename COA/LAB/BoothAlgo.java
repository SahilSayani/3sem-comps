// package Lab;

// phone a friend: https://repl.it/@hbs2/Booths#main.c

/*
Structure

- function to shift right
- function to add
- convert to binary
- convert to decimal
- convert to negative
- main
  - toBinary ()
  - calculates -M and sets M, -M
  - sets A, Q, Q-1 and n
  - shiftRight () and binaryAdd() as required till n = 0
  - merge A and Q to get binary result
  - toDecimal ()
*/

import java.util.*;

public class BoothAlgo {
    int ONE[];
    int A[];
    int M[];
    int Q[];
    int negM[];
    int q, bits;

    BoothAlgo (int bits)
    {
        this.A = new int[bits];
        this.M = new int[bits];
        this.Q = new int[bits];
        this.negM = new int[bits];
        this.ONE = new int[bits];
        this.ONE [0] = 1;
        this.q = 0;
        this.bits = bits;
    }

    void toBinary (int num, char flag)      // flag - to choose which array
    {
        int temp[] = new int[this.bits];
        String binary = Integer.toBinaryString (num);
        int len = binary.length (), i;

        for (i = 0;i < len; i++)
        {
            // LSB is stored in temp[0] and MSB is stored in temp[7]
            temp [i] = Character.getNumericValue(binary.charAt (len - 1 - i));
        }

        switch (flag) {
            case 'M':
                this.M = temp.clone();
                break;

            case 'Q':
                this.Q = temp.clone();
                break;
        
            default:
                break;
        }
    }

    int toDecimal (int[] convert)
    {
        int result = 0, multiplier = 1;
        int temp[] = convert.clone();

        for (int i = 0; i < temp.length; i++)
        {
            result += (multiplier * temp[i]);
            multiplier *= 2;
        }

        return result;
    }

    void binaryAdd (int[] add1, int[] add2, char flag)
    {
        int temp1 [] = add1.clone();
        int temp2 [] = add2.clone();
        int tempSum [] = new int [this.bits];
        int sum = 0, carry = 0, i;

        for (i = 0; i < temp1.length; i++)
        {
            sum = (temp1[i] ^ temp2[i]) ^ carry;
            carry = (temp1[i] & temp2[i]) | (temp1[i] & carry) | (carry & temp2[i]);

            tempSum[i] = sum;
        }

        switch (flag) {
            case 'A':
                this.A = tempSum.clone();
                break;

            case 'm':
                this.negM = tempSum.clone();
                break;
        
            default:
                break;
        }
    }

    void shiftRight ()
    {
        // start from LSB(Q) -> MSB(Q) -> LSB(A) -> MSB(A)
        this.q = this.Q [0];

        for (int i = 0; i < (Q.length-1); i++) {
            this.Q[i] = this.Q[i+1];
        }

        this.Q [bits-1] = this.A [0];

        for (int i = 0; i < (A.length-1); i++) {
            this.A[i] = this.A[i+1];
        }
    }
    
    void calcNegM ()
    {
        int i;

        // flip all the bits
        for (i = 0; i < this.M.length; i++) {
            if (this.M[i] == 0)
                this.negM [i] = 1;
            if (this.M[i] == 1)
                this.negM [i] = 0;
        }
        // call the binary add
        binaryAdd(this.negM, this.ONE, 'm');
    }

    void displayArr (int[] arr)
    {
        int len = arr.length;
        for (int i = len-1; i >= 0; i--)
        {
            System.out.print(arr[i]);
        }
    }

    public static void main (String[] args) {
        int i, bits = 0;
        Scanner scanner = new Scanner (System.in);

        System.out.println ("Enter two numbers to multiply using Booth's Algorithm");
        int n1 = scanner.nextInt ();
        int n2 = scanner.nextInt ();

        int max = n1 > n2 ? n1 : n2;

        for (i = 1; i <= 8; i++)
        {
            if (Math.abs(max) < Math.pow(2, i))
            {
                bits = i + 1;
                break;
            }
        }

        System.out.println("bits : " + bits);
        BoothAlgo booth = new BoothAlgo (bits);

        scanner.close();

        booth.toBinary(n1, 'M');
        booth.toBinary(n2, 'Q');
        booth.calcNegM();

        System.out.print(" Q: ");
        booth.displayArr(booth.Q);
        System.out.print("\n M: ");
        booth.displayArr(booth.M);
        System.out.print("\n-M: ");
        booth.displayArr(booth.negM);
        System.out.println();

        for (i = bits; i >= 1; i--)
        {
            if (booth.Q[0] == 1 && booth.q == 0)
            {
                booth.binaryAdd(booth.A, booth.negM, 'A');

                booth.displayArr(booth.A);
                System.out.print("   ");
                booth.displayArr(booth.Q);
                System.out.println("   " + booth.q + "   " + i);
            }
            else if (booth.Q[0] == 0 && booth.q == 1)
            {
                booth.binaryAdd(booth.A, booth.M, 'A');

                booth.displayArr(booth.A);
                System.out.print("   ");
                booth.displayArr(booth.Q);
                System.out.println("   " + booth.q + "   " + i);
            }

            booth.shiftRight();

            booth.displayArr(booth.A);
            System.out.print("   ");
            booth.displayArr(booth.Q);
            System.out.println("   " + booth.q + "   " + i);
        }

        int result[] = new int [(2*bits)];

        // result: Q(lsb) -> Q(msb) -> A(lsb) -> A(msb)
        for (i = 0; i < (2*bits); i++)
        {
            if (i < bits)
                result [i] = booth.Q [i];
            else 
                result [i] = booth.A [i-bits];
        }

        int res = booth.toDecimal(result);

        System.out.print("\nResult in binary: ");
        booth.displayArr(result);
        System.out.println("\nResult in decimal: " + res);
    }
}
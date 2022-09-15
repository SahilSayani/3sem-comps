// package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class RestoringDiv {
    int ONE[];
    int A[];
    int M[];
    int Q[];
    int negM[];
    int bits;

    // constructor
    RestoringDiv (int bits)
    {
        this.A = new int[bits];
        this.M = new int[bits];
        this.Q = new int[bits];
        this.negM = new int[bits];
        this.ONE = new int[bits];
        this.ONE [0] = 1;
        this.bits = bits;
    }

    // WORKING
    void toBinary (int num, char flag)      // flag - to choose which array
    {
        int temp[] = new int[this.bits];
        String binary = Integer.toBinaryString (num);
        int len = binary.length (), i;

        // converts binary string to array (easier for binary operations)
        for (i = 0;i < len; i++)
        {
            // LSB is stored in temp[0] and MSB is stored in temp[lastPos]
            temp [i] = Character.getNumericValue(binary.charAt (len - 1 - i));
        }

        // assigns binary number according to the flag
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

    // WORKING
    void binaryAdd (int[] add1, int[] add2, char flag)
    {
        int temp1 [] = add1.clone();
        int temp2 [] = add2.clone();
        int tempSum [] = new int [this.bits];
        int sum = 0, carry = 0, i;

        // loops over all the bits 
        for (i = 0; i < temp1.length; i++)
        {
            // add the bits
            sum = (temp1[i] ^ temp2[i]) ^ carry;
            carry = (temp1[i] & temp2[i]) | (temp1[i] & carry) | (carry & temp2[i]);

            // store the added bit
            tempSum[i] = sum;
        }

        // assigns the sum to the array according to the flag 
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

    // WORKING
    void shiftLeft ()
    {
        int i;

        // start from MSB(A) -> LSB(A) -> MSB(Q) -> LSB(Q)
        for (i = (this.bits-1); i > 0; i--)
        {
            this.A [i] = this.A [i-1];
        }

        this.A [0] = this.Q [this.bits-1];

        for (i = (this.bits-1); i > 0; i--)
        {
            this.Q [i] = this.Q [i-1];
        }

        this.Q [0] = 0;
    }
    
    // WORKING
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

    // WORKING 
    void displayArr (int[] arr)
    {
        int len = arr.length;
        for (int i = len-1; i >= 0; i--)
        {
            System.out.print(arr[i]);
        }
    }

    public static void main(String[] args) {
        int bits = 6, i;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the dividend: ");
        int dividend = scanner.nextInt();

        System.out.print("Enter the divisor: ");
        int divisor = scanner.nextInt();

        for (i = 1; i <= 8; i++)
        {
            if (Math.abs(dividend) < Math.pow(2, i))
            {
                bits = i + 1;
                break;
            }
        }

        RestoringDiv div = new RestoringDiv(bits);

        div.toBinary(divisor, 'M');
        div.toBinary(dividend, 'Q');
        div.calcNegM();

        System.out.print ("\n M: ");
        div.displayArr(div.M);
        System.out.print (" -M: ");
        div.displayArr(div.negM);
        System.out.print (" Q: ");
        div.displayArr(div.Q);
        System.out.println ("\n");

        while (bits > 0)
        {
            // WORKING
            div.shiftLeft();
            div.binaryAdd(div.A, div.negM, 'A');

            div.displayArr(div.A);
            System.out.print("   ");
            div.displayArr(div.Q);
            System.out.println("   " + bits);

            if (div.A[div.bits-1] == 0)
            {
                div.Q [0] = 1;
            }
            if (div.A[div.bits-1] == 1)     // if A is negative
            {
                div.Q [0] = 0;
                div.binaryAdd(div.A, div.M, 'A');
            }

            div.displayArr(div.A);
            System.out.print("   ");

            div.displayArr(div.Q);
            System.out.println("   " + bits);

            bits--;
        }

        System.out.print("\nIn Binary:");
        System.out.print("\nQuotient: ");
        div.displayArr(div.Q);
        System.out.print("\nRemainder: ");
        div.displayArr(div.A);

        System.out.print("\n\nIn Decimal:");
        System.out.print("\nQuotient: " + div.toDecimal(div.Q));
        System.out.print("\nRemainder: " + div.toDecimal(div.A));

        scanner.close();
    }
}
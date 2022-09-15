// package Lab;

import java.util.*;

public class VaniBoothAlgo {

    static int digits = 0;

    static String Initialise(String tempM, char negM[]) {
        String complement = complement(tempM);
        for (int x = 0; x < digits; x++)
            negM[x] = complement.charAt(x);
        // Negative M is initialised into array.
        return complement;

    }

    static char flip(char c) {
        char ch;
        if (c == '0')
            ch = '1';
        else
            ch = '0';

        return ch;
    }

    public static String complement(String bin) {
        int n = bin.length();
        int i;

        String ones = "", twos = "";
        ones = twos = "";

        // for ones complement flip every bit
        for (i = 0; i < n; i++) {

            if (i >= 0)
                ones += flip(bin.charAt(i));
        }

        String temp = ones;
        int j = -1;

        for (int x = n - 2; x >= 0; x--) {
            if (ones.charAt(x) == '0') {
                j = x;
                break;
            }

        }

        if (j == -1) {
            twos += '1';
            for (int x = 0; x <= (n - 1); x++)
                twos += '0';

        } else if (temp.charAt(n - 1) == '1') {
            for (int x = 0; x < n; x++) {
                if (x < j)
                    twos += temp.charAt(x);
                else if (x == j)
                    twos += '1';
                else
                    twos += '0';

            }
        }

        else {
            for (int x = 0; x < n; x++) {
                if (x < n - 1)
                    twos += temp.charAt(x);
                else
                    twos += '1';
            }
        }

        // for two's complement go from right to left in
        // ones complement and if we get 1 make, we make
        // them 0 and keep going left when we get first
        // 0, make that 1 and go out of loop

        return twos;
    }

    static char Shift(char A[], char Q[], char Q0) {
        char tempA[] = new char[digits - 1];
        char tempQ[] = new char[digits - 1];
        char temp1 = A[digits - 1], tempQ0 = Q[digits - 1];

        for (int i = 0, j = 0; i < digits - 1 && j <= digits - 1; i++, j++) {

            tempA[i] = A[j];
            tempQ[i] = Q[j];
        }

        for (int i = 0, j = 1; i < digits - 1 && j <= digits - 1; i++, j++) {
            A[j] = tempA[i];
            Q[j] = tempQ[i];

        }
        Q[0] = temp1;

        return tempQ0;

    }

    static void Addition(char A[], char M[]) {
        char carry = '0';
        System.out.println(digits);
        for (int i = digits - 1; i >= 0; i--) {
            if ((A[i] == '1') && (M[i] == '1')) {
                if (carry == '1') {
                    A[i] = '1';
                    carry = '1';
                } else {
                    A[i] = '0';
                    carry = '1';
                }

            } else if ((A[i] == '0') && (M[i] == '0')) {
                if (carry == '1')
                    A[i] = '1';
                else
                    A[i] = '0';
            } else {
                if (carry == '1') {
                    A[i] = '0';
                    carry = '1';
                } else
                    A[i] = '1';
            }
        }

        for (int x = 0; x < A.length; x++) {
            System.out.print(A[x]);
        }
        System.out.println();
        for (int x = 0; x < M.length; x++) {
            System.out.print(M[x]);
        }

    }

    static void compare(char Q0, char Q[], char M[], char negM[], char A[]) {
        int count = digits;
        System.out.println("count          " + "  A        " + "    Q       " + "Q0       " + " Initial Stage");
        System.out.println("--------------------------------------------------------------------------");
        System.out.print(count + "               ");
        for (int i = 0; i < digits; i++) {
            System.out.print(A[i]);
        }
        System.out.print("         ");
        for (int i = 0; i < digits; i++) {
            System.out.print(Q[i] + "");
        }
        System.out.print("     ");
        System.out.println(Q0);
        System.out.println("***************************");
        for (; count > 0;) {
            if ((Q0 == Q[digits - 1])) {
                char Q01 = Shift(A, Q, Q0); // Shifts Right
                Q0 = Q01;
                System.out.println("count          " + "  A        " + "    Q       " + "Q0       " + " Shift Right");
                System.out.println("--------------------------------------------------------------------------");
                System.out.print(count + "               ");
                for (int i = 0; i < digits; i++) {
                    System.out.print(A[i]);
                }
                System.out.print("         ");
                for (int i = 0; i < digits; i++) {
                    System.out.print(Q[i] + "");
                }
                System.out.print("     ");
                System.out.println(Q0);
                System.out.println("***************************");

                count--;
            } else if ((Q0 == '0') && (Q[digits - 1] == '1')) {
                Addition(A, negM); // Does Addition of A and -M
                System.out.println("count          " + "  A        " + "    Q       " + "Q0       " + " A=A-M");
                System.out.println("--------------------------------------------------------------------------");
                System.out.print(count + "               ");
                for (int i = 0; i < digits; i++) {
                    System.out.print(A[i]);
                }
                System.out.print("         ");
                for (int i = 0; i < digits; i++) {
                    System.out.print(Q[i] + "");
                }
                System.out.print("     ");
                System.out.println(Q0);
                System.out.println("***************************");
                char Q01 = Shift(A, Q, Q0); // Shifts Right
                Q0 = Q01;
                System.out.println("count          " + "  A        " + "    Q       " + "Q0       " + " Shift Right");
                System.out.println("--------------------------------------------------------------------------");
                System.out.print(count + "               ");
                for (int i = 0; i < digits; i++) {
                    System.out.print(A[i]);
                }
                System.out.print("         ");
                for (int i = 0; i < digits; i++) {
                    System.out.print(Q[i] + "");
                }
                System.out.print("     ");
                System.out.println(Q0);
                System.out.println("***************************");
                count--;

            } else {
                Addition(A, M); // Does Addition of A and M
                System.out.println("count          " + "  A        " + "    Q       " + "Q0       " + " A=A+M");
                System.out.println("--------------------------------------------------------------------------");
                System.out.print(count + "               ");
                for (int i = 0; i < digits; i++) {
                    System.out.print(A[i]);
                }
                System.out.print("         ");
                for (int i = 0; i < digits; i++) {
                    System.out.print(Q[i] + "");
                }
                System.out.print("     ");
                System.out.println(Q0);
                System.out.println("***************************");
                char Q01 = Shift(A, Q, Q0); // Shifts Right
                Q0 = Q01;
                System.out.println("count          " + "  A        " + "    Q       " + "Q0       " + " Shift Right");
                System.out.println("--------------------------------------------------------------------------");
                System.out.print(count + "               ");
                for (int i = 0; i < digits; i++) {
                    System.out.print(A[i]);
                }
                System.out.print("         ");
                for (int i = 0; i < digits; i++) {
                    System.out.print(Q[i] + "");
                }
                System.out.print("     ");
                System.out.println(Q0);
                System.out.println("***************************");
                count--;
            }

        }
        String ans = "";
        for (int a = 0; a < digits; a++)
            ans += A[a];
        for (int a = 0; a < digits; a++)
            ans += Q[a];
        int answer = Integer.parseInt(ans, 2);
        System.out.println("Final Answer: " + ans + " = " + answer);

    }

    public static void main(String args[]) {
        Scanner s1 = new Scanner(System.in);
        System.out.println("Enter a number(Q)");
        int QIn = s1.nextInt();

        String Qtemp = Integer.toBinaryString(QIn);
        String QIntTemp = '0' + Qtemp;
        String QInt = "", MInt = "";
        System.out.println("Enter a number to be multiplied.(M)");// Integer input change to
        int MIn = s1.nextInt();
        String Mtemp = Integer.toBinaryString(MIn);
        String MIntTemp = '0' + Mtemp;
        int diff = MIntTemp.length() - QIntTemp.length();
        diff = Math.abs(diff);

        if (MIntTemp.length() > QIntTemp.length()) {
            MInt = MIntTemp;
            for (int i = 1; i <= diff; i++)
                QInt += '0';

            QInt = QInt + QIntTemp;

        } else {
            QInt = QIntTemp;
            for (int i = 1; i <= diff; i++)
                MInt += '0';

            MInt = MInt + MIntTemp;

        }

        digits = QInt.length();

        char Q0 = '0';
        int i = 0;

        char M[] = new char[digits];
        char Q[] = new char[digits];
        char A[] = new char[digits];
        char negM[] = new char[digits + 1];// need to change things for NegM

        for (i = 0; i < digits; i++) {

            Q[i] = QInt.charAt(i);
            M[i] = MInt.charAt(i);
            A[i] = '0';

        } // All values are initialised

        String negTemp = Initialise(MInt, negM);

        System.out.println("Q: " + QInt);
        System.out.println("M: " + MInt);
        System.out.println("Negative M: " + negTemp);
        System.out.print("A: ");
        for (int x = 0; x < (A.length); ++x)
            System.out.print(A[x]);
        System.out.println();
        compare(Q0, Q, M, negM, A);// compare Q0 and Q1 and count checking
    }

}

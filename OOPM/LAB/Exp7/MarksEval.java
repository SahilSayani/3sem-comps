package Lab.Exp7;
/**
 * Write a program which accepts marks of a student (between 1 and 100) and checks whether it is within he range then it displays "marks entered successfuly", if not then it throws the exception of user defined class "MarksOutOfRangeException" The class should contain appropriate toString method to describe the object with the out of range marks entered by the user. 
 */

import java.util.Scanner;

public class MarksEval {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int marks [] = new int [4];

        for (int i = 0; i < 4; i++) {
            System.out.println("Enter marks for subject " + (i + 1));

            marks[i] = scanner.nextInt();

            try {
                if (marks[i] > 100 || marks[i] < 0) {
                    throw new MarksOutOfRangeException();
                }
            } catch (MarksOutOfRangeException e) {
                System.out.println(e.toString());
                i--;
            }
        }

        System.out.println("\nMarks entered successfully\nThe marks are: ");
        for (int i = 0; i < marks.length; i++) {
            System.out.print (marks[i] + "  ");
        }

        scanner.close();
    }
}

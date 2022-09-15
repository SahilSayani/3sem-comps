package Lab.Exp9;

/**
 * Write a program that ask the user to enter the name of the file, and then asks the user to enter a
character. The program should count and display the number of times that the specified
character appears in the file.
 * 
 * BufferedReader (FileWriter)
 * PrintWriter (BufferedWriter (FileWriter))
 */

import java.io.File;
// import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class FindInFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Finding frequency of character in a file");
        System.out.println("The file should be in the same folder as code");
        System.out.print("Enter the name of the file (with extention) for searching: ");
        String name = scanner.nextLine();

        File file = new File(name);

        if (!(file.exists())) {
            System.out.println("\nAdd text to input to the file");
            String text = scanner.nextLine();

            PrintWriter pw;

            try {
                file.createNewFile();
                pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));

                pw.println(text);
                pw.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }

        System.out.print ("Enter the character for which the frequency must be found: ");
        char toSearch = scanner.next().charAt(0);
        
        if ((int)toSearch >= 97 && (int)toSearch <= 122) {
            toSearch -= 32;
        }
        
        int read, count = 0;
        char ch;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            
            while ((read = br.read()) != -1) {
                ch = (char)read;

                if ((int)ch >= 97 && (int)ch <= 122) {
                    ch -= 32;
                }

                if (ch == toSearch) {
                    count++;
                }
            }

            br.close ();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        System.out.println (toSearch + " is present in the file " + name + " " + count + " number of times");

        scanner.close ();
    }
}

// package Lab.Multithreading;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * ReadFile
 */
public class ReadFile implements Runnable {
    public void run () {
        //
    }

    public static void main(String[] args) {
        String file1 = "C:\\Users\\ashuk\\Documents\\Semester 3\\Object Oriented Programming\\Lab\\Multithreading\\Personal_Record.txt";
        String file2 = "Academic_Record.txt";
        File personal = new File (file1);
        File academic = new File (file2);

        // try {
        // BufferedReader br1 = new BufferedReader(new FileReader(file1));
        // BufferedReader br2 = new BufferedReader(new FileReader (file2));
        // }
        Thread m = new Thread (new ReadFile());

        m.run();
    }
}
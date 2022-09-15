import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

class PersonalDetails extends Thread {

    public void run() {
        try {
            String s1;
            File file = new File("Personal_Record.txt");

            if (file.createNewFile()) {
                System.out.println("\nFile created successfully " + file.getAbsolutePath() + " !!");
                if (file.length() == 0) {
                    try {
                        FileWriter fw = new FileWriter(file);
                        fw.write("Personal Records:\na)Name:Mugdha \nb)DOB:18/09/2001 \nc)Hobbies:Music");
                        fw.close();
                    } catch (Exception e) {
                        System.out.println("Error1 : " + e.getMessage());
                    }
                }
            }
            Scanner read1 = new Scanner(file);

            while (read1.hasNextLine()) {
                synchronized (read1) {
                    s1 = read1.nextLine();
                }
                Thread.sleep(500);
                System.out.println("Thread " + getId() + "- Personal Details : " + s1 + " " + getPriority());
            }
            read1.close();

        } catch (Exception e) {
            System.out.println("\nError2 :" + e.getMessage());
        }
    }
}

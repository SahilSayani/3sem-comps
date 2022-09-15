import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class AcademicDetails extends Thread {
    public synchronized void run() {
        try {
            File file1 = new File("Academic_Record.txt");

            if (file1.createNewFile())
            {
                System.out.println("File created successfully " + file1.getAbsolutePath() + " !!\n");
                if (file1.length() == 0)
                {
                    try
                    {
                        FileWriter fw = new FileWriter(file1);
                        fw.write("Academic Records:\n1)Year:SY \n2)College:Kj Somaiya \n3)Branch:COMPS ");
                        fw.close();
                    }
                    catch (Exception e)
                    {
                        System.out.println("Error :" + e.getMessage());
                    }
                }
            }
                Scanner read2 = new Scanner(file1);
                while (read2.hasNextLine())
                {
                    Thread.sleep(500);
                    System.out.println("Thread " + getId() + "- Academic Details : " + read2.nextLine()+" "+getPriority());
                }
                read2.close();
        }
        catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }

    }
}

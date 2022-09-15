package Lab.Exp5;

/**
 * VectorEmployee
 * 
 * Create a class Employee which stores E-Name, E-Id and E-Salary of an Employee. Use class Vector to maintain an array of Employee with respect to the E-Salary. Provide the following functions
 * (done) 1) Create (): this function will accept the n Employee records in any order and will arrange them in the sorted order.
 * (done) 2) Insert (): to insert the given Employee record at appropriate index in the vector depending upon the E-Salary.
 * (done) 3) delete ByE-name( ): to accept the name of the Employee  and delete the record having given name
 * (done) 4) deleteByE-Id ( ): to accept the Id of the Employee and delete the record having given E-Id.
 * (done) 5) display (): This function displays all the accounts stored in the database sorted according to Salary
 */

import java.util.Vector;
import java.util.Scanner;

public class VectorEmployee {
    Vector <Employee> vect = new Vector <> (10);
    Scanner scanner = new Scanner (System.in);

    void create ()
    {
        int i, j;
        boolean added = false;

        System.out.print("Enter the number of employees for which data is being entered: ");
        int n = scanner.nextInt();
        Employee temp[] = new Employee[n];

        for (i = 0; i < n; i++) {
            temp[i] = new Employee ();
            System.out.println("\nData for Employee " + (i+1));

            System.out.print ("Enter ID: ");
            temp[i].eID = scanner.nextInt();
            String trash = scanner.nextLine();

            System.out.print ("Enter Name: ");
            temp[i].eName = scanner.nextLine();

            System.out.print ("Enter Salary: ");
            temp[i].eSalary = scanner.nextInt();
        }

        // vect.add(temp[0]);

        for (i = 1; i < temp.length; i++)
        {
            for (j = 0; j < vect.size(); j++) 
            {
                if (temp[i].eSalary < vect.elementAt(j).eSalary)
                {
                    vect.add(j, temp[i]);
                    added = true;
                    break;
                }
            }

            if (!added) 
            {
                vect.add(temp[i]);
            }
        }
    }

    void insert ()
    {
        Employee temp = new Employee ();
        int j;
        boolean added = false;

        System.out.print ("Enter ID: ");
        temp.eID = scanner.nextInt();
        String trash = scanner.nextLine();

        System.out.print ("Enter Name: ");
        temp.eName = scanner.nextLine();

        System.out.print ("Enter Salary: ");
        temp.eSalary = scanner.nextInt();

        for (j = 0; j < vect.size(); j++) {
            if (temp.eSalary < vect.elementAt(j).eSalary) {
                vect.add(j, temp);
                added = true;
                break;
            }
        }

        if (!added) 
        {
            vect.add(temp);
        }
    }

    void display ()
    {
        Employee temp;
        for (int i = 0; i < vect.size(); i++) 
        {
            temp = vect.elementAt(i);
            System.out.println("\nEmployee " + (i+1));
            System.out.println("Employee ID: " + temp.eID);
            System.out.println("Employee Name: " + temp.eName);
            System.out.println("Employee Salary: " + temp.eSalary);
        }
    }

    void deleteByName ()
    {
        String tempName;
        Employee temp = new Employee();
        boolean found = false;

        System.out.print ("Enter Name to be Searched: ");
        String trash = scanner.nextLine();
        String sName = scanner.nextLine();

        for (int i = 0; i < vect.size(); i++) { 
            tempName = vect.elementAt(i).eName;

            if (sName.equalsIgnoreCase(tempName))
            {
                temp = vect.remove(i);
                found = true;
                break;
            }
        }
        
        if (found) {
            System.out.println("\nEmployee to be removed from the database:");
            System.out.println("Employee ID: " + temp.eID);
            System.out.println("Employee Name: " + temp.eName);
            System.out.println("Employee Salary: " + temp.eSalary);
        }
        else{
            System.out.println("Employee with given name was not found");
        }

        // vect.
    }

    void deleteByID ()
    {
        int tempID;
        Employee temp = new Employee();
        boolean found = false;

        System.out.print ("Enter ID to be Searched: ");
        int sID = scanner.nextInt();

        for (int i = 0; i < vect.size(); i++) { 
            tempID = vect.elementAt(i).eID;

            if (sID == tempID)
            {
                temp = vect.remove(i);
                found = true;
                break;
            }
        }
        
        if (found) {
            System.out.println("\nEmployee to be removed from the database:");
            System.out.println("Employee ID: " + temp.eID);
            System.out.println("Employee Name: " + temp.eName);
            System.out.println("Employee Salary: " + temp.eSalary);
        }
        else{
            System.out.println("Employee with given ID was not found");
        }
    }

    public static void main(String[] args) 
    {
        Scanner scannerMain = new Scanner (System.in);
        VectorEmployee obj = new VectorEmployee();
        int ch = 0;

        do {
            System.out.println ("\n\nEmployee Database\n");
            System.out.println ("1. Create database and add employees");
            System.out.println ("2. Add new employee records");
            System.out.println ("3. Display employee information");
            System.out.println ("4. Delete employee record by E-Name");
            System.out.println ("5. Delete employee record by E-ID");
            System.out.println ("0. Exit");
            System.out.print ("\nEnter your choice: ");
            ch = scannerMain.nextInt();

            switch (ch) {
                case 1:
                    obj.create ();
                    break;

                case 2:
                    obj.insert();
                    break;

                case 3:
                    obj.display();
                    break;

                case 4:
                    obj.deleteByName();
                    break;
            
                case 5:
                    obj.deleteByID();
                    break;

                default:
                    break;
            }

            // for (int i = 0; i < obj.vect.size(); i++) {
            //     System.out.println(obj.vect.elementAt(i).eName);   
            // }
        } while (ch != 0);

        scannerMain.close();
    }
}
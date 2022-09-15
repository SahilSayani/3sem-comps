package Lab.Exp4;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int ch = 1, newInd = 0, tempID, i;

        System.out.print("Enter the number of accounts : ");;
        int n =  scanner.nextInt();

        Account array[] = new Account [n];

        do {
            System.out.println("\nMenu");
            System.out.println("1. Create new acoount");
            System.out.println("2. Display account details");
            System.out.println("3. Delete account");
            System.out.println("0. Exit");
            System.out.print("\nEnter your choice : ");
            ch = scanner.nextInt();

            switch (ch) {
                case 1:
                    if (newInd < n) 
                    {
                        System.out.print("Enter account ID: ");
                        int accID = scanner.nextInt();
                        String trash = scanner.nextLine();

                        System.out.print("Enter account holder\'s name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter balance of account: ");
                        int balance = scanner.nextInt();

                        array[newInd] = new Account(name, accID, balance);
                        newInd++;
                    }
                    else 
                    {
                        System.out.println ("The array is filled, please delete an account to proceed");
                    }
                    break;

                case 2:
                    System.out.print("Enter ID of the account: ");
                    tempID = scanner.nextInt();

                    for (i = 0; i < n; i++)
                    {
                        try {
                            if (array[i].accID == tempID)
                                break;
                        } catch (NullPointerException e) {
                            i = n;
                            break;
                        }
                    }

                    if (i < n)
                        array[i].display();
                    else if (i == n) {
                        System.out.println("Account not found");
                    }
                    break;

                case 3:
                    System.out.print("Enter ID of the account: ");
                    tempID = scanner.nextInt();
                    
                    for (i = 0; i < n; i++)
                    {
                        try {
                            if (array[i].accID == tempID)
                                break;
                        } catch (NullPointerException e) {
                            i = n;
                            break;
                        }
                    }
                    
                    if (i < n) 
                    {
                        for (int j = i; j < (n - 1); j++)
                            array[j] = array[j + 1];

                        array[n - 1] = null;
                        System.out.println ("Account has been successfully deleted");
                    }
                    else if (i == n)
                    {
                        System.out.println ("Account not found");
                    }
                    break;
            
                default:
                    break;
            }
        } while (ch != 0);

        scanner.close ();
    }
}
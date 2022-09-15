/**
 * THIS IS VANI'S CODE DON'T TOUCH IT OKAY?!?!?!
 */

package Lab.Exp4;

import java.util.*;

class Bank1 {
    public static void main(String args[]) {
        Scanner s1 = new Scanner(System.in);
        System.out.println("Enter the total number of customers");
        int n = s1.nextInt();
        Details[] arr = new Details[n];
        int f = 1;
        System.out.println("Enter the number of records you wish to input");
        int a = s1.nextInt();

        for (int i = 0; i < a; i++) {
            System.out.println("Enter the account ID");
            int id = s1.nextInt();
            System.out.println("Enter the name of the customer");
            String s = s1.next();
            System.out.println("Enter the balance of the customer");
            double m = s1.nextDouble();
            arr[i] = new Details(s, id, m);
        }

        while (f == 1) {
            System.out.println("MENU");
            System.out.println("1. Add a customer details");
            System.out.println("2. Delete a customer's details");
            System.out.println("3. Display all the customers' details");
            System.out.println("4. Exit");
            int x = s1.nextInt();

            switch (x) {
                case 1: {
                    System.out.println("Enter the number of records you wish to input");
                    int b = s1.nextInt();

                    for (int i = (x + 1); i < (x + 1 + b); i++) {
                        System.out.println("Enter the account ID");
                        int id = s1.nextInt();
                        System.out.println("Enter the name of the customer");
                        String s = s1.next();
                        System.out.println("Enter the balance of the customer");
                        double m = s1.nextDouble();
                        arr[i] = new Details(s, id, m);
                    }
                }
                    break;
                case 2: {
                    System.out.println("Enter the account ID of the customer whose details needs to be deleted.");
                    int y = s1.nextInt();
                    int pos = -1;
                    y = y - 1;

                    for (int i = 0; i < arr.length; i++) {
                        System.out.println(i);
                        if (arr[i].account_id == y)
                            pos = i;
                    }
                    if (pos >= 0) {
                        for (int k = pos; k < arr.length; k++) {
                            arr[k] = arr[k + 1];
                        }
                    } else
                        System.out.println("There isn't any record by the given account id");
                }
                    break;
                case 3: {

                    System.out.println("Customers' details are as follows:");
                    for (int i = 0; arr[i] != null; i++) {
                        System.out.println("Name: " + arr[i].name + ", Account ID: " + arr[i].account_id + ", Balance: "
                                + arr[i].balance);
                    }
                }
                    break;
                case 4:
                    f = 0;
                    break;
                default:
                    System.out.println("Please enter a valid option from 1-4.");
            }
        }
    }

}

class Details {
    public String name;
    public double balance;
    public int account_id;

    public Details(String n, int a_id, double bal) {
        name = n;
        account_id = a_id;
        balance = bal;
    }

}

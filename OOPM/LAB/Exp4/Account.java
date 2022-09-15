package Lab.Exp4;

/**
 * Write a program which accepts information about n number of customers from user. Create an array of objects to store account_id, name, balance.
 * 
 * Your program should provide following functionalities
 * 1. To add account
 * 2. To delete account details
 * 3. To display account details
 */

public class Account 
{
    String name;
    int accID;
    int balance;

    Account (String name, int accID, int balance)
    {
        this.name = name;
        this.accID = accID;
        this.balance = balance;
        System.out.println("\nAccount details saved successfully");
    }

    void display ()
    {
        System.out.println("\nAccount ID : " + this.accID);
        System.out.println("Account Holder Name : " + this.name);
        System.out.println("Balance : " + this.balance);
    }
}
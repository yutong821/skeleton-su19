/**
 * This class represents a bank account whose current balance is a nonnegative
 * amount in US dollars.
 */
public class Account {

    public static void main(String[] args) {
        System.out.println("liu yutong shi gou");
        Account christine = new Account(500);
        Account matt = new Account(100, christine);
        int test = matt.balance;
        System.out.println(test);
        matt.withdraw(50);
        int test2 = matt.balance;
        System.out.println(test2);
        matt.withdraw(300);
        System.out.println(christine.balance);
    }

    public int balance;
    public Account parentAccount;

    /** Initialize an account with the given balance. */
    public Account(int balance) {
        this.balance = balance;
        this.parentAccount = null;
    }

    // add two argument Account
    public Account(int balance, Account parentAccount) {
        this.balance = balance;
        this.parentAccount = parentAccount;
    }


    /** Deposits amount into the current account. */
    public void deposit(int amount) {
        if (amount < 0) {
            System.out.println("Cannot deposit negative amount.");
        } else {
            balance += amount;
        }
    }

    /**
     * Subtract amount from the account if possible. If subtracting amount
     * would leave a negative balance, print an error message and leave the
     * balance unchanged.
     */
    public boolean withdraw(int amount) {
        // TODO
        if (amount < 0) {
            System.out.println("Cannot withdraw negative amount.");
            return false;
        } else if (balance < amount) {
            // System.out.println("Insufficient funds");
            if (this.parentAccount != null && amount - this.balance < this.parentAccount.balance) {
                this.parentAccount.balance = this.parentAccount.balance - amount + this.balance;
                this.balance = 0;
                return true;
            } else if (this.parentAccount != null && amount - this.balance > this.parentAccount.balance) {
                System.out.println("Insufficient funds");
                return false;
            }else {
                return false;
            }
        } else {
            this.balance -= amount;
            return true;
        } 
    }

    /**
     * Merge account other into this account by removing all money from other
     * and depositing it into this account.
     */
    public void merge(Account other) {
        this.deposit(other.balance);
        other.withdraw(other.balance);
    }
}

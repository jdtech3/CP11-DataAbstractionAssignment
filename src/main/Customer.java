package main;

import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private int accountNumber;
    private ArrayList<Deposit> deposits = new ArrayList<>();
    private ArrayList<Withdraw> withdraws = new ArrayList<>();
    private double checkBalance;
    private double savingBalance;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;

    /**
     * Default constructor - sets name to "Undefined" and all numerical values to 0
     */
    public Customer(){
        // Set all to 0 or "undefined" because user didn't specify anything
        this.name = "Undefined";
        this.accountNumber = 0;
        this.checkBalance = 0;
        this.savingBalance = 0;
    }

    /**
     * Creates a new main.Customer with name, account number, checking account initial deposit,
     * and saving account initial deposit.
     *
     * @param name customer's name
     * @param accountNumber account number of customer
     * @param checkDeposit checking acct. initial deposit
     * @param savingDeposit saving acct. initial deposit
     */
    public Customer(String name, int accountNumber, double checkDeposit, double savingDeposit){
        // Name and account #
        this.name = name;
        this.accountNumber = accountNumber;

        // Assuming checkDeposit and savingDeposit means the initial deposit to the account
        this.checkBalance = checkDeposit;
        this.savingBalance = savingDeposit;
    }

    /**
     * Records deposit in specified account
     *
     * @param amt amount of deposit
     * @param date date of deposit
     * @param account account to deposit to
     */
    /* RME:
     * - Requires: double amt >= 0, Date date, String account -> "Checking" / "Saving"
     * - Modifies: this, deposits
     * - Effects: creates a new main.Deposit object and adds to ArrayList of deposits;
     *            changes balance to reflect deposit
     */
    public void deposit(double amt, Date date, String account){
        // Create the main.Deposit object with the given amount, date, and account
        Deposit depositObj = new Deposit(amt, date, account);
        deposits.add(depositObj);

        // Adds to balance depending on which account chosen
        if (account.equals(CHECKING)) {
            checkBalance += amt;
        }
        else if (account.equals(SAVING)) {
            savingBalance += amt;
        }
    }

    /**
     * Records withdrawal in specified account
     *
     * @param amt amount to withdraw
     * @param date date of withdrawal
     * @param account account to withdraw from
     */
    /* RME:
     * - Requires: double amt >= 0, Date date, String account -> "Checking" or "Saving"
     * - Modifies: this, withdraws
     * - Effects: creates a new main.Withdraw object and adds to ArrayList of withdraws;
     *            changes balance to reflect withdrawal
     */
    public void withdraw(double amt, Date date, String account){
        // Create the main.Withdraw object with the given amount, date, and account
        Withdraw withdrawObj = new Withdraw(amt, date, account);
        withdraws.add(withdrawObj);     // Add to ArrayList of withdraws

        // Check for overdraft
        boolean overdraft = checkOverdraft(amt, account);

        // Deplete balance depending on which account chosen
        if (account.equals(CHECKING) && !overdraft) {
            checkBalance -= amt;
        }
        else if (account.equals(SAVING) && !overdraft) {
            savingBalance -= amt;
        }
    }

    /**
     * Function to check for overdraft
     *
     * @param amt amount of withdrawal
     * @param account account of withdrawal
     * @return whether this is an overdraft: true if it is, false if it isn't
     */
    private boolean checkOverdraft(double amt, String account) {
        // If specified account is the checking account, and there's not enough balance in the
        // checking account to do the withdrawal, return overdraft: true
        if (account.equals(CHECKING) && amt > (checkBalance - OVERDRAFT)) {
            return true;
        }
        // Same as above, except it's for the saving account
        else if (account.equals(SAVING) && amt > (savingBalance - OVERDRAFT)) {
            return true;
        }

        // Otherwise, it means we have enough balance, so return overdraft: false
        else {
            return false;
        }
    }

    /**
     * Getter function for savingBalance and checkBalance
     *
     * @param account account to get balance
     * @return balance of account
     */
    public double getBalance(String account) {
        if (account.equals(CHECKING)) {
            return checkBalance;
        }
        else if (account.equals(SAVING)) {
            return savingBalance;
        }
        else {
            return 0.0;
        }
    }

    // do not modify
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }
    // do not modify
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }
}

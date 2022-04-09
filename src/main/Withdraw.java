package main;

import java.util.Date;

public class Withdraw {
    private double amount;
    private Date date;
    private String account;

    public Withdraw(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    /* RME:
     * - Requires: none
     * - Modifies: none
     * - Effects: this returns a String representation of the Withdraw object
     */
    public String toString(){
        //your code here
        return String.format("Withdrawal of: $%.2f Date: %s from account: %s", amount, date.toString(), account);
    }
}

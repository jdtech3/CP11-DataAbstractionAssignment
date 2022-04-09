package main;

import java.util.Date;

public class Deposit {
    private double amount;
    private Date date;
    private String account;

    public Deposit(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    /* RME:
     * - Requires: none
     * - Modifies: none
     * - Effects: this returns a String representation of the Deposit object
     */
    @Override
    public String toString(){
        //your code here
        return String.format("Deposit of: $%.2f Date: %s into account: %s", amount, date.toString(), account);
    }
}

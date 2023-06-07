package org.atm.machine;

public class ATM {
    private double balance; //variable
    private  double depositAmount;
    private double  wtihdrawAmount;

   // defautl constructor
    public ATM() {
    }


    //getter and setter
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public double getWtihdrawAmount() {
        return wtihdrawAmount;
    }

    public void setWtihdrawAmount(double wtihdrawAmount) {
        this.wtihdrawAmount = wtihdrawAmount;
    }
}

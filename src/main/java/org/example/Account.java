package org.example;

public class Account {
    protected double balance;
    protected int numConsignations;
    protected int numWithdrawals;
    protected double yearlyRate;
    protected double monthlyComission;

    public Account (double balance, double yearlyRate){
        this.balance = balance;
        this.yearlyRate = yearlyRate;
        this.numConsignations = 0;
        this.numWithdrawals = 0;
        this.monthlyComission = 0.0;
    }

    public void record (double value){
        if (value > 0){
            balance += value;
            numConsignations++;
        }
    }

    public boolean withdrawal (double value){
        if (value > 0 && value <= balance){
            balance -= value;
            numWithdrawals++;
            return true;
        }
        return false;
    }

    public void calculateMonthlyInterest(){
        double monthlyInterest = balance * (yearlyRate / 12 / 100);
        balance += monthlyInterest;
    }

    public void monthlyStatement(){
        balance -= monthlyComission;
        calculateMonthlyInterest();
        numConsignations = 0;
        numWithdrawals = 0;
    }

    public String print(){
        return String.format(
                "Balance: %2f, Yaearly rate: %2f, " +
                "Consignations: %d, Withdrawal: %d. " +
                "Yearly comissions: 2f",
                balance, yearlyRate, numConsignations,
                numWithdrawals, monthlyComission
        );
    }

    public double getBalance(){
        return balance;
    }

    public int getNumConsignations(){
        return numConsignations;
    }

    public int getNumWithdrawals() {
        return numWithdrawals;
    }
}

package org.example;

public class savingAccount extends Account{
    private static boolean active;

    public savingAccount(double balance, double yearlyRate) {
        super(balance, yearlyRate);
        this.active = balance >= 10000;
    }

    @Override
    public void consignate (double value){
        if (active){
            super.consignate(value);
        }
    }

    @Override
    public boolean deposit(double amount){
        if (this.active && amount > 0) {
            return super.deposit(amount);
        }
        return false;
    }

    @Override
    public boolean withdrawal (double value){
        if (active) {
            return super.withdrawal(value);
        }
        return false;
    }

    @Override
    public void monthlyExtract (){
        if (numWithdrawals > 4) {
            monthlyComission += (numWithdrawals - 4) * 1000;
        }
        super.monthlyStatement();
        active = balance >= 10000;
    }

    @Override
    public String print(){
        return String.format(
                "Balance: %.2f, Monthly commission: %2.f, " + "Transactions: %d ",
                balance, monthlyComission, numConsignations + numWithdrawals
        );

    }
     public static boolean isActive(){
        return active;
     }
}

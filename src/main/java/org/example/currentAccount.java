package org.example;

public abstract class currentAccount extends Account {
    private double overDraft;

    public currentAccount(double balance, double yearlyRate){
        super(balance, yearlyRate);
        this.overDraft = 0.0;
    }

    @Override
    public boolean withdrawal(double value){
        if (value <= balance){
            return super.withdrawal(value);
        }
        else {
            overDraft += value - balance;
            balance = 0;
            numWithdrawals++;
            return true;
        }
    }

    @Override
    public void consignate(double value){
        if (overDraft > 0){
            if (value >= overDraft){
                value -= overDraft;
                overDraft = 0;
            }
        }   else {
            overDraft -= value;
            value = 0;
        }
        super.consignate(value);
    }

    @Override
    public String print(){
        return String.format(
                "Balance: %.2f, Monthly commission: %.2f " + "Transactions: %d, Overdraft: %.2f",
                balance, monthlyComission,
                numConsignations + numWithdrawals, overDraft
        );
    }
    public double getOverDraft(){
        return overDraft;
    }
}

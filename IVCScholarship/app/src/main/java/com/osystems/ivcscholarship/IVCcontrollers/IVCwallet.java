package com.osystems.ivcscholarship.IVCcontrollers;

public class IVCwallet {
    //Do all calculations in the server
    private int wallet_balance;

    private void deduct(int amount){
        this.wallet_balance = this.wallet_balance - amount;
        // change the server balance
    }

    private void deposit(int amount){
        this.wallet_balance = this.wallet_balance + amount;
        // change the server balance
    }

    public boolean isInsufficient(int amount){
        return amount < wallet_balance;
    }

    public String getWallet_Balance(){
        return this.wallet_balance + "";
    }

    public void updateBalance(boolean deposit, int amount){
        if(deposit){
            deposit(amount);
        }else{
            deduct(amount);
        }
    }
}

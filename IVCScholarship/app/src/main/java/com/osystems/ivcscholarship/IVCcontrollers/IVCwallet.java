package com.osystems.ivcscholarship.IVCcontrollers;

public class IVCwallet {
    private int wallet_balance;

    private void deduct(int amount){
        this.wallet_balance = this.wallet_balance - amount;
        // change the server balance and the shared pref manger instance of wallet_balance
    }

    private void deposit(int amount){
        this.wallet_balance = this.wallet_balance + amount;
        // change the server balance and the shared pref manger instance of wallet_balance
    }

    boolean isInsufficient(int amount){
        return amount < wallet_balance;
    }

    String getWallet_Balance(){
        return this.wallet_balance + "";
    }

    void updateBalance(boolean deposit, int amount){
        if(deposit){
            deposit(amount);
        }else{
            deduct(amount);
        }
    }
}

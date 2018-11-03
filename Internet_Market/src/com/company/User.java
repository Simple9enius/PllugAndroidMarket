package com.company;

import java.util.ArrayList;

public class User extends Person{
    private int spentMoney = 0;

    public User(String fullName){
        super(fullName);
    }

    public User(String _fullName, ArrayList<Purchase> _purchases, int _spentMoney){
        super(_fullName, _purchases);
        spentMoney = _spentMoney;
    }

    public int getSpentMoney() {
        return spentMoney;
    }

    public void setSpentMoney(int spentMoney) {
        this.spentMoney = spentMoney;
    }

    @Override
    public void setPurchases(ArrayList<Purchase> purchases) {
        this.purchases = purchases;
        for (Purchase p : purchases) {
            spentMoney += p.getSum();
        }
    }

    @Override
    public void addPurchase(Purchase _purchase){
        purchases.add(_purchase);
        spentMoney += _purchase.getSum();
    }

    @Override
    public String toString() {
        return super.toString() + "spend money on this market: " + spentMoney + "\n";
    }

}

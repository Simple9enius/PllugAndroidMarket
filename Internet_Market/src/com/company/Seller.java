package com.company;

import java.util.ArrayList;

public class Seller extends Person {
    private int earnedMoney = 0;

    public Seller(String fullName){
        super(fullName);
    }

    public Seller(String _fullName, ArrayList<Purchase> _purchases, int _earnedMoney){
        super(_fullName, _purchases);
        earnedMoney = _earnedMoney;
    }

    public int getSpentMoney() {
        return earnedMoney;
    }

    public void setSpentMoney(int earnedMoney) {
        this.earnedMoney = earnedMoney;
    }

    @Override
    public void setPurchases(ArrayList<Purchase> purchases) {
        this.purchases = purchases;
        for (Purchase p : purchases) {
            earnedMoney += (int)0.95*p.getSum();
        }
    }

    @Override
    public void addPurchase(Purchase _purchase){
        purchases.add(_purchase);
        earnedMoney += (int)0.95*_purchase.getSum();
    }

    @Override
    public String toString() {
        return super.toString() + "spend money on this market: " + earnedMoney + "\n";
    }
}

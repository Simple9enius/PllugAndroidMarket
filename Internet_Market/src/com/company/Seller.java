package com.company;

import java.util.ArrayList;

public class Seller extends Person {
    private int earnedMoney = 0;

    public Seller(String fullName){
        super(fullName);
    }

    public Seller(String _fullName, ArrayList<Purchase> _purchases){
        super(_fullName, _purchases);
        for (Purchase p : purchases) {
            earnedMoney += p.getSum()*0.95;
        }
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
            earnedMoney += p.getSum()*0.95;
        }
    }

    @Override
    public void addPurchase(Purchase _purchase){
        purchases.add(_purchase);
        earnedMoney += _purchase.getSum()*0.95;
    }

    @Override
    public String toString() {
        return super.toString() + "Earned money on this market: " + earnedMoney + "\n";
    }
}

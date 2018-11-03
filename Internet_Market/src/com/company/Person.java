package com.company;

import java.util.ArrayList;

public class Person {
    protected String fullName;
    protected ArrayList<Purchase> purchases;

    public Person(String _fullName){
        fullName = _fullName;
    }

    public Person(String _fullName, ArrayList<Purchase> _purchases){
        fullName = _fullName;
        purchases = _purchases;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public ArrayList<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(ArrayList<Purchase> purchases) {
        this.purchases = purchases;
    }

    public void addPurchase(Purchase _purchase){
        purchases.add(_purchase);
    }

    @Override
    public String toString() {
        String purchases = "";
        for (Purchase p : this.purchases) {
            purchases += p.toString();
        }
        return "Full name: " + fullName + ".\nPurchases:\n" + purchases;
    }
}

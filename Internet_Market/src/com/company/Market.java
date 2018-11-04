package com.company;

import java.util.ArrayList;

public class Market {
    private String name;
    private ArrayList<User> users = new ArrayList<User>();
    private ArrayList<Seller> sellers = new ArrayList<Seller>();
    private ArrayList<Purchase> purchases = new ArrayList<Purchase>();
    private int earnedMoney = 0;

    public Market(String _name){
        name = _name;
    }

    public Market(String _name, ArrayList<User> _users, ArrayList<Seller> _sellers){
        name = _name;
        users = _users;
        sellers = _sellers;
    }

    public Market(String _name, ArrayList<User> _users, ArrayList<Seller> _sellers, ArrayList<Purchase> _purchases){
        name = _name;
        users = _users;
        sellers = _sellers;
        purchases = _purchases;
        for (Purchase p : purchases) {
            earnedMoney += (int)(0.05)*p.getSum();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<Seller> getSellers() {
        return sellers;
    }

    public void setSellers(ArrayList<Seller> sellers) {
        this.sellers = sellers;
    }

    public ArrayList<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(ArrayList<Purchase> purchases) {
        this.purchases = purchases;
        for (Purchase p : purchases) {
            earnedMoney += (int)(0.05)*p.getSum();
        }
    }

    public int getEarnedMoney() {
        return earnedMoney;
    }

    @Override
    public String toString(){
        String sUsers = "", sSellers = "", sPurchases = "";

        for (Purchase p : purchases) {
            sPurchases += p.toString();
        }
        for (User u : users){
            sUsers += u.toString();
        }
        for (Seller s : sellers){
            sSellers += s.toString();
        }

        return "Name: " + name + ".\n" + (sUsers.isEmpty() ? "We haven't got users.\n" : "Users:\n" + sUsers + ".\n") +
                (sSellers.isEmpty() ? "We haven't got sellers.\n" : "Sellers:\n" + sSellers + ".\n") +
                (sPurchases.isEmpty() ? "We haven't got purchases.\n" : "Purchases:\n" + sPurchases + ".\n") +
                "Earned money: " + earnedMoney + ".\n";
    }
}

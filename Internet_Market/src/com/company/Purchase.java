package com.company;

import java.util.ArrayList;

public class Purchase {
    private String productName;
    private User user;
    private Seller seller;
    private int sum = 0;
    public Purchase(String _productName, int _sum, User _user, Seller _seller){
        productName = _productName;
        sum = _sum;
        user = _user;
        seller = _seller;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public String getPurchaseName() {
        return productName;
    }

    public void setPurchaseName(String productName) {
        this.productName = productName;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public String toString(){
        return "Product name: " + productName + ".\nCustomer: " + user +
                ".\nSeller: " + seller + ".\n";
    }
}

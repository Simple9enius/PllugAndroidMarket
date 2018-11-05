package com.company;

import java.util.ArrayList;

public class Purchase {
    private String productName;
    private String userName;
    private String sellerName;
    private int sum = 0;

    public Purchase(String _productName, int _sum, String _userName, String _sellerName){
        productName = _productName;
        sum = _sum;
        userName = _userName;
        sellerName = _sellerName;
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
        return "Product name: " + productName + ".\nCustomer: " + userName +
                ".\nSeller: " + sellerName + ".\n";
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }
}

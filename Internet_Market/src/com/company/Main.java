package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<User> users = new ArrayList<User>();
    private static ArrayList<Seller> sellers = new ArrayList<Seller>();
    private static ArrayList<Purchase> purchases = new ArrayList<Purchase>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countPurchases, earnedMoney;
        System.out.println("Input count purchases:");
        countPurchases = scanner.nextInt();
        purchases = inputPurchases(countPurchases);
        Market amazon = new Market("Amazon", users, sellers, purchases);
        System.out.println(amazon);
    }

    public static ArrayList<Purchase> inputPurchases(int countPurchases) {
        ArrayList<Purchase> purchases = new ArrayList<Purchase>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < countPurchases; i++) {
            String userName, productName, sellerName;
            int sum, check = 1;

            System.out.println("Product name of purchase №" + (i+1) + ":");
            productName = scanner.nextLine();

            System.out.println("Sum of purchase №" + (i+1) + ":");
            sum = scanner.nextInt();

            System.out.println("Full name customer of purchase №" + (i + 1) + ": ");
            userName = scanner.nextLine();

            System.out.println("Full name seller of purchase №" + (i + 1) + ": ");
            sellerName = scanner.nextLine();

            User userTmp = new User(userName);
            Seller sellerTmp = new Seller(sellerName);
            Purchase purchaseTmp = new Purchase(productName, sum, userTmp, sellerTmp);
            purchases.add(purchaseTmp);

            for(int j = 0; j < users.size(); j++){
                if(users.get(i).getFullName().equals(userName)){
                    users.get(i).addPurchase(purchaseTmp);
                    check = 0;
                    break;
                }
            }
            if (check == 1){
                users.add(userTmp);
                users.get(users.size()-1).addPurchase(purchaseTmp);
            }

            for(int j = 0; j < sellers.size(); j++){
                if(sellers.get(i).getFullName().equals(sellerName)){
                    sellers.get(i).addPurchase(purchaseTmp);
                    check = 0;
                    break;
                }
            }
            if (check == 1){
                sellers.add(sellerTmp);
                sellers.get(sellers.size()-1).addPurchase(purchaseTmp);
            }
        }
        return purchases;
    }
}

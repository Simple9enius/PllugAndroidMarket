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
            String tmp = scanner.nextLine();

            System.out.println("Full name customer of purchase №" + (i + 1) + ": ");
            userName = scanner.nextLine();

            System.out.println("Full name seller of purchase №" + (i + 1) + ": ");
            sellerName = scanner.nextLine();

            Purchase purchaseTmp = new Purchase(productName, sum, userName, sellerName);
            purchases.add(purchaseTmp);

            for(int j = 0; j < users.size(); j++){
                if(users.get(j).getFullName().equals(userName)){
                    User userTmp = users.get(j);
                    userTmp.addPurchase(purchaseTmp);
                    users.set(j, userTmp);
                    check = 0;
                    break;
                }
            }
            if (check == 1){
                User userTmp = new User(userName);
                userTmp.addPurchase(purchaseTmp);
                users.add(userTmp);
            }

            for(int j = 0; j < sellers.size(); j++){
                if(sellers.get(j).getFullName().equals(sellerName)){
                    Seller sellerTmp = sellers.get(j);
                    sellerTmp.addPurchase(purchaseTmp);
                    sellers.set(j, sellerTmp);
                    check = 0;
                    break;
                }
            }
            if (check == 1){
                Seller sellerTmp = new Seller(sellerName);
                sellerTmp.addPurchase(purchaseTmp);
                sellers.add(sellerTmp);
            }
        }
        return purchases;
    }
}

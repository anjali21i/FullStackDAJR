package com.core.fullstack.md.vendingmachine;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {
	
	Map<Product, Integer> productList;
	private int totalMoney;
	
	public VendingMachine() {
		super();
		productList = new HashMap<Product, Integer>();
	}

	public VendingMachine(Map<Product, Integer> productList, int totalMoney) {
		super();
		this.productList = productList;
		this.totalMoney = totalMoney;
	}
	
	public Map<Product, Integer> getProductList() {
		return productList;
	}

	public void setProductList(Product product, Integer count) {
		productList.put(product, count);
		this.productList = productList;
	}

	public int getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}
	public void addProducts(Product product, Integer counts) {
		productList.put(product, counts);
	}
	
	public void removeProduct(Product product, Integer counts) {
		productList.remove(product, counts);
	}
	
	public void displayItems() {
		System.out.println("Available Items:");
//        for (String item : productList.keySet()) {
//            int price = productList.get(item);
//            System.out.println(item + " - Price: " + price);
//        }
	}
	
	public void insertMoney(int amount) {
		totalMoney += amount;
	}
	
	public void vendItem(String name) {
		
		
	}
	
	public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        Item prod = new Item(87L, "soda", 786L);
        
        vendingMachine.setProductList(prod, 3);
      
//        Product
//        vendingMachine
        
       
        System.out.println("\nMenu:");
        System.out.println("1. Display Items");
        System.out.println("2. Insert Money");
        System.out.println("3. Select Item");
        System.out.println("4. Check Balance");
        System.out.println("5. Quit");
        
        
        
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                vendingMachine.displayItems();
                break;
            case 2:
                System.out.print("Enter amount to insert: ");
                int amount = scanner.nextInt();
                vendingMachine.insertMoney(amount);
                System.out.println("Money inserted: " + amount);
                break;
            case 3:
                System.out.print("Enter item name: ");
                String itemName = scanner.nextLine();
                vendingMachine.vendItem(itemName);
                break;
            case 4:
//                int balance = vendingMachine.getRemainingBalance();
//                System.out.println("Remaining balance: " + balance);
                break;
            case 5:
                scanner.close();
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
	}

}

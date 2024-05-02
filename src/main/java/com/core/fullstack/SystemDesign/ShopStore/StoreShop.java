package com.core.fullstack.SystemDesign.ShopStore;

import java.util.ArrayList;
import java.util.List;

public class StoreShop {

	public static void main(String[] args) {
		Store store = new Store();
		Product prod1 = new Book("aa", 548, "book data");

		store.addProduct(prod1);
		store.addProduct(new Box("ba", 428, "box data"));

		store.printProduct();
	}
}

class Store {
	private List<Product> prodList = new ArrayList<Product>();

	public void addProduct(Product product) {
		if (product != null)
			prodList.add(product);
	}

	public void printProduct() {
		for (var product : prodList) {
			System.out.println("Product:");
			product.getProductDetail(product);
		}
	}
}

abstract class Product {
	private String type;
	private double price;
	private String description;

	public Product(String type, int price, String description) {
		super();
		this.type = type;
		this.price = price;
		this.description = description;
	}

	public double getSalePrice(int quantity) {
		return quantity * price;
	}

	public void printPricedItem(int quantity) {
		System.out.println("item:" + type + "QUANTITY: " + quantity + " of Price: " + price);
	}

	abstract void getProductDetail(Product product);

	abstract void showDetail();
}

class Box extends Product {
	public Box(String type, int price, String description) {
		super(type, price, description);
	}

	@Override
	public void getProductDetail(Product product) {
		System.out.println("product type:" + product);
	}

	@Override
	void showDetail() {
	}
}

class Book extends Product {

	public Book(String type, int price, String description) {
		super(type, price, description);
	}

	@Override
	void getProductDetail(Product product) {
		System.out.println("product:" + product);
	}

	@Override
	void showDetail() {
	}
}

class Orders {
	private int quantity;
}

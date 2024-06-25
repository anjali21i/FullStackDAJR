package com.core.fullstack.J2SE.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class ProductData {

    int val;
    double price;
    String item, Type;


    ProductData() {

    }

    ProductData(int val, String item, double price, String Type) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    

}

public class CollTest {
    
     public static void main(String[] args) {
        // Create a list of ProductData objects
        List<ProductData> products = new ArrayList<>();
        products.add(new ProductData(1, "Laptop", 1200.0, "Electronics"));
        products.add(new ProductData(2, "Smartphone", 800.0, "Electronics"));
        products.add(new ProductData(3, "Headphones", 100.0, "Electronics"));
        products.add(new ProductData(4, "T-shirt", 25.0, "Clothing"));
        products.add(new ProductData(5, "Jeans", 50.0, "Clothing"));
        products.add(new ProductData(6, "Shoes", 80.0, "Footwear"));

        // Example 1: Filter products by category
        List<ProductData> electronicsProducts = products.stream()
                                        .filter(p -> p.getType().equals("Electronics"))
                                        .collect(Collectors.toList());
        System.out.println("Electronics Products:");
        electronicsProducts.forEach(System.out::println);

        // Example 2: Find the average price of products
        double averagePrice = products.stream()
                                    .mapToDouble(ProductData::getPrice)
                                    .average()
                                    .orElse(0.0);
        System.out.println("Average Price of Products: $" + averagePrice);

        // Example 3: Group products by category
        Map<String, List<ProductData>> productsByCategory = products.stream()
                                        .collect(Collectors.groupingBy(ProductData::getType));
        System.out.println("Products Grouped by Category:");
        productsByCategory.forEach((category, productList) -> {
            System.out.println(category + ":");
            productList.forEach(System.out::println);
        });
    }
}

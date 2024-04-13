package com.core.fullstack.J2SE;

public class Assertion {
    public Assertion() {
    }
    
    public static void withdraw(double amount) {
        assert amount > 0.0 : "Withdrawal amount must be positive";
        // Withdrawal logic   java -ea Assertion    java -da Assertion
    }


    public static void main(String[] args) {

        System.out.println(">>>:");
        withdraw(20.0);
    }
}

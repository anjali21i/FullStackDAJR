package com.core.fullstack.J2SE.exceptionhandling;

public class RethrowException {
    public static void main(String[] args) {
        try {
            someMethod();
        } catch (CustomException e) {
            System.out.println("Caught custom exception: " + e.getMessage());
        }
    }

    public static void someMethod() throws CustomException {
        try {
            // Some operation that might throw an exception
            int result = divide(10, 0);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            // Perform some handling/logging
            System.out.println("Caught arithmetic exception: " + e.getMessage());

            // Rethrow the exception
            // throw new CustomException(e);
        }
    }

    public static int divide(int a, int b) {
        return a / b;
    }
}

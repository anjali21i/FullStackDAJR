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
            throw new CustomException("Error occurred in someMethod", e);
        }
    }

    public static int divide(int a, int b) {
        return a / b;
    }
}

// Custom checked exception
class CustomException extends Exception {
    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }
}
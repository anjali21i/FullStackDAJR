package com.core.fullstack.J2SE.exceptionhandling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ExceptionsPractice {

	public static void throwingExcMethod() throws CustomException {
		
	}
	public static void main(String[] args) {
		try {
			// Example 1: Handling checked exception - FileNotFound
			BufferedReader reader = new BufferedReader(new FileReader("nonexistent-file.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + e.getMessage());
		}

		try {
			// Example 2: Handling checked exception - IOException
			FileWriter writer = new FileWriter("readonly-file.txt");
			writer.write("Hello, world!");
			writer.close();
		} catch (IOException e) {
			System.out.println("IO exception: " + e.getMessage());
		}

		// Example 3: Handling multiple exceptions with a single catch block
		try {
			int[] arr = new int[5];
			System.out.println(arr[10]);
		} catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
			System.out.println("Array index out of bounds or null pointer: " + e.getMessage());
		}

		// Example 4: Handling unchecked exception - ArithmeticException
		try {
			int result = divide(10, 0);
			System.out.println("Result: " + result);
		} catch (ArithmeticException e) {
			System.out.println("Arithmetic exception: " + e.getMessage());
		}

		// Example 5: Using finally block for cleanup
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("sample-file.txt"));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			System.out.println("IO exception: " + e.getMessage());
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				System.out.println("Error closing reader: " + e.getMessage());
			}
		}

		// Example 6: Rethrowing an exception
		try {
			throwingExcMethod();
		} catch (CustomException e) {
			System.out.println("Custom exception: " + e.getMessage());
		}

		// Example 7: Using try-with-resources for automatic resource management
		try (FileWriter writer = new FileWriter("auto-closed-file.txt")) {
			writer.write("Hello, world!");
		} catch (IOException e) {
			System.out.println("IO exception: " + e.getMessage());
		}

		// Example 8: Runtime IllegalArgumentException
		try {
			int age = -5;
			if (age < 0) {
				throw new IllegalArgumentException("Age cannot be negative");
			}
		} catch (IllegalArgumentException e) {
			System.out.println("Illegal argument: " + e.getMessage());
		}

		// Example 9: Compile-time IllegalArgumentException
		try {
			divide(-10, 2);
		} catch (IllegalArgumentException e) {
			System.out.println("Illegal argument: " + e.getMessage());
		}

		// Example 10: Compile-time exception - Syntax error
		// Uncomment the following line to see the compile-time error
		// int x = 10 /;
	}

	// Method to demonstrate rethrowing an exception
	public static void someMethod() throws CustomException {
		try {
			// Simulate an exception
			throw new CustomException("Exception thrown from someMethod");
		} catch (CustomException e) {
			// Perform some handling and rethrow
			System.out.println("Handling exception: " + e.getMessage());
			throw e;
		}
	}

	// Method to demonstrate unchecked exception
	public static int divide(int a, int b) {
		if (a < 0) {
			throw new IllegalArgumentException("First argument cannot be negative");
		}
		return a / b;
	}
}

class CustomException extends Throwable{

	CustomException() {

	}

	CustomException(String ex) {
		
	}

}
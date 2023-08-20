package com.core.fullstack.J2SE;

abstract class Car {
	public abstract String model();
	public String engine() {
		return "40cc";
	}	
}

class SUV extends Car {
	@Override
	public String model() {
		return "67-Cs";	
	}
}

class Maruti extends Car {
	@Override
	public String model() {
		return "roger-yutg";
	}
}

public class AbstractClassMethods {
	
	public static void main (String args[]) {
		SUV d1 = new SUV();
		System.out.println("d1 model:"+ d1.model());
		System.out.println("d1 eng:"+ d1.engine());
	}

}

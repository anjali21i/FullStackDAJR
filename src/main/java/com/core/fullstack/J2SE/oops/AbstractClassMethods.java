package com.core.fullstack.J2SE.oops;

abstract class Vehicle {
	public abstract String noOfWheel();
}

abstract class Car extends Vehicle {
	public abstract String model();
	public String engine() {
		return "40cc";
	}	
	
	@Override
	public String noOfWheel() {
		// TODO Auto-generated method stub
		return "4";
	}
}

class SUV extends Car {
	@Override
	public String model() {
		return "67-Cs";	
	}

//	@Override
//	public String noOfWheel() {
//		// TODO Auto-generated method stub
//		return "4";
//	}
}

class Maruti extends Car {
	@Override
	public String model() {
		return "roger-yutg";
	}

	@Override
	public String noOfWheel() {
		// TODO Auto-generated method stub
		return null;
	}
}

public class AbstractClassMethods {
	
	public static void main (String args[]) {
		SUV d1 = new SUV();
		System.out.println("d1 model:"+ d1.model());
		System.out.println("d1 eng:"+ d1.engine());
	}

}

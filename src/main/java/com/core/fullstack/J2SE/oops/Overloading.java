package com.core.fullstack.J2SE.oops;

public class Overloading {
	
	public static void main(String arg[]) {
//		getDetail(9L);
		
//		getDetail(null); give CTE
		
	}
	
	private static void getDetail(Long val) {
		System.out.println("Long: "+ val);
	}
	
	private static void getDetail(String val) {
		System.out.println("String: "+ val);
	}
	
	private static void getDetail(Object val) {   //not give error
		System.out.println("Obj: "+ val);
	}
	

}

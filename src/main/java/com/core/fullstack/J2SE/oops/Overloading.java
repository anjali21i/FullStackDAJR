package com.core.fullstack.J2SE.oops;

class PO {
	public static void getDetail(int val) {
		System.out.println("int obj: "+ val);
	}
}

class CO extends PO {
	public static void getDetailChild(int val) {
		System.out.println("int obj: "+ val);
	}
}
class Overload {
	/////////////////////////////////////
	
	public static void getDetail(int val) {
		System.out.println("int obj: "+ val);
	}
	
	public static void getDetail(float val) {
		System.out.println("float obj: "+ val);
	}

	//////////////////////////////////////
	
	public static void getDetail(Long val) {             //1
		System.out.println("Long obj: "+ val);
	}
	
	public static void getDetail(String val) {
		System.out.println("String obj: "+ val);
	}
	
	public static void getDetail(Object val) {   //not give error
		System.out.println("Object Obj: "+ val);
	}
	
	public static void getDetail(StringBuffer val) {   //not give error
		System.out.println("StringBuffer Obj: "+ val);
	}
	
	///////////////////////////////////////////
	public static void getDetail(int val, float f) {   //not give error
		System.out.println("int float ver");
	}
	
	public static void getDetail(float f, int val) {   //not give error
		System.out.println("float int ver");
	}
	
	///////////////////////////////////////////////////
	
	public static void getDetailVal(int val) {   //
		System.out.println("int ver");
	}
	
	public static void getDetailVal(int... val) {   //var arg   least priority  act as default case
		System.out.println("var arg ver");
	}
	
	
	public static void getDetailD(PO val) {   //var arg   least priority  act as default case
		System.out.println("PO ver");
	}
	
	public static void getDetailD(CO val) {   //var arg   least priority  act as default case
		System.out.println("CO ver");
	}
	
}
public class Overloading {
	
	public static void main(String arg[]) {
		Overload ov = new Overload();
		ov.getDetail(9L);
		ov.getDetail(9);
//		ov.getDetail(null); //give CTE
		
		
//		ov.getDetail(2,2.2);	//cannt find for double
//		ov.getDetail(2.3,2);	//cannt find for double
		
		ov.getDetail(2,2.2f);
		ov.getDetail(2.3f,2);
//		ov.getDetail(2,2);   // ce ambiguous
		
		
		///////////////////////////////
		 
		ov.getDetailVal(9);  //
		ov.getDetailVal();  //var arg
		ov.getDetailVal(9, 0, 7);  //var arg 
		
		
		PO ob1 = new PO();
		ov.getDetailD(ob1);		//PO
		CO ob2 = new CO();
		ov.getDetailD(ob2);		//CO
		PO ob3 = new CO();
		ov.getDetailD(ob3);   //PO
		
	
		
		
	}

}

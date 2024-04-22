package com.core.fullstack.J2SE.oops;

import java.io.EOFException;
import java.io.IOException;

/*
 * covariant return allowed after java 5
 * in overriding return type must be same till java 4 fter that
 * child class method return type need not be same as parent method type;
 * its child type return type is also allowed
 * refer String com.core.fullstack.J2SE.oops.COD.covariantEx2(int val)
 * 
 * covarient return type valid only for non primitives
 * 
 * private method are not be overriden and if child implement exactly same
 * method then it is not overriding
 * final method cannot be overriden in child; it will give CE with: overriden
 * method is final
 * 
 * while overriding we cannot reduce the scope of access modifier to child
 * we can increase the scope
 * 
 * private < default < protected < public
 * public => public
 * protected => protected / public
 * default => default/ protected / public
 * private => no overriding
 * 
 */
class POD {
	public void getDetail(int val) {
		System.out.println("parent int obj: " + val);
	}

	public String covariantEx(int val) {
		System.out.println("parent int obj: " + val);
		return String.valueOf(val);
	}

	public Object covariantEx2(int val) {
		System.out.println("parent int obj: " + val);
		return String.valueOf(val);
	}

	public double primitive(int val) { // covarient primit
		System.out.println("parent int obj: " + val);
		return val;
	}
}

class COD extends POD {

	public void getDetail(int val) {
		System.out.println("child int obj: " + val);
	}

	// public Object covariantEx(int val) { // CE parent cannt be return type
	// in overriding // faulty covarint
	// System.out.println("parent int obj: "+ val);
	// return String.valueOf(val);
	// }

	public String covariantEx2(int val) { // covarient
		System.out.println("parent int obj: " + val);
		return String.valueOf(val);
	}

	// public int primitive(int val) { //covarient primit CE return type must
	// same only valid for non primitive
	// System.out.println("parent int obj: "+ val);
	// return val;
	// }

}

/*
 * 
 * abstract method of parent class should be overriden 
 * to restrict overriding abstract method you can make child class as abstact
 * 
 * final -> non final 									/\	p
 * non final -> final 									\/ np
 * strictfp <-> non strictfb  							\/ np
 * abstract <-> non abstract							\/ np
 * synchronised <-> non synchronised					\/ np	synchronised not put any restriction on overriding
 * native <-> non native								\/ np
 * 
 */

 abstract class InnerOverriding1 {
	abstract void m1();
 }
 class ChABsCall extends InnerOverriding1 {
	@Override
	void m1() {
		throw new UnsupportedOperationException("Unimplemented method 'm1'");
	}
 }
 abstract class ChABsCall2 extends InnerOverriding1 {
	// @Override					//optional
	// void m1() {
	// 	throw new UnsupportedOperationException("Unimplemented method 'm1'");
	// }
 }

 class an {
	public String abc() {
		return "parent";
	}
 }
 class ab extends an {
	public String abc() {
		return "child";
	}
 }

/*
 * if child class method throws any checked exception 
 * 		=> parent should throw same checked exception or its parent otherwise we will get CE
 * 
 * but there is no any restriction for unchecked exception
 * 
 */

 class ExceptionParent {

	//case 1
	public String abc() throws Exception {
		return "";
	}

	//case 2 : 		needs throw exception to remove CE
	// public String abcd() {
	// 	return "";
	// }

	//case 3
	public String abcde() throws Exception {
		return "";
	}

	//case 4
	public String abcdef() {
		return "";
	}

	//case 5  add Exception for incrementAL to remove CE
	// public String abbb() throws IOException{
	// 	return "";
	// }


 }


 class ExceptionChild extends ExceptionParent {
	
	//case 1
	public String abc(){
		return "";
	}

	//case 2: 		will give CE
	// public String abcd() throws Exception{
	// 	return "";
	// }

	//case 3			//child
	public String abcde() throws IOException {
		return "";
	}

	//case 4			no CE as it is unchecked exceptions
	public String abcdef() throws ArithmeticException, NullPointerException {
		return "";
	}

	//case 5      CE
	// public String abbb() throws EOFException, InterruptedException {
	// 	return "";
	// }

 }

//////////////////////////***********************/////////////////////

/**
 * static
 * we cannt override static method  ; cannot override; overriden method is static
 */
class StaticOver {
	//case 1
	public static void m1() {
		System.out.println("parent");
	}

	//case 2 
	public void m2() {
		System.out.println("parent");
	}

	//case 3		method hiding
	public static void m3() {
		System.out.println("parent m3");
	}

	//case 4     method overriding
	public void m4() {
		System.out.println("parent m3");
	}

	
}

/*
	* method overriding - non-statics, JVM is responsible for method resolution based on runtime obj, late binding, runt time poly
	* method hiding - static-static, compiler is responsible for method resolution based on reference type, early binding, Compile time poly, static poly
	* 
*/
class ChildStatic extends StaticOver {

	//case 1 overridden method should same as parent  ; CE-> overriden method is static 
 	// public void m1() {
		
	// }
	
	//case 2 cannt override nonstatic method as static; CE overriding method is static
	// public static void m2() {

	// }

	// case 3 static method in Parent and in child with static method oot; method hiding not overriding
	//case 3		method hiding
	public static void m3() {
		System.out.println("child m3");
	}

	//case 4     method overriding
	public void m4() {
		System.out.println("child m4");
	}

}



class VarParent {

	public void m1(int... i) {
		System.out.println("parent m1");
	}

	public void m2(int i) {
		System.out.println("parent m2");
	}

	public void m3(int... i) {
		System.out.println("parent m3");
	}
}


class VarChild extends VarParent {
	public void m1(int... i) {
		System.out.println("child m1");
	}

	public void m2(int... i) {
		System.out.println("child m2");
	}

	public void m3(int i) {
		System.out.println("child m3");
	}

}

/**
 * InnerOverriding
 */
interface Inter {

	public static void name() {
		System.out.println("intrf");
	}
	
	public default void namedef() {
		System.out.println("intrf");
	}
}

interface InterB {
	
	public static void namedef() {
		System.out.println("intrf");
	}
}

/**
 * InnerOverriding
 */
class Interf implements Inter, InterB {
	public void name2() {
		Inter.name();
	}
	
}

public class Overriding {

	public static void main(String arg[]) {
		// <RHS> compile time obj
	 	// <LHS> run time object
		POD obp = new POD();
		obp.getDetail(0);

		COD cob = new COD();
		cob.getDetail(0);

		POD obpc = new COD(); // method resolution is based on run time object ie new COD()
		obpc.getDetail(1);

		an ob = new an();
		System.out.println(ob.abc());

		StaticOver ob1 = new StaticOver();
		ChildStatic ob2 = new ChildStatic();


		StaticOver ob3 = new ChildStatic();
		ob3.m4();	//method overriding
		ob3.m3();  //method hiding


		VarChild obje = new VarChild();
		obje.m1(9, 7);
		VarParent obje2 = new VarChild();
		obje2.m1(9,6); 	// child m1   //override    
		obje2.m1(4);		//child m1		 //override 
		obje2.m2(6);			//parent m2
		obje2.m3(3);		//parent m3    //not
		obje2.m3(6,7); 	//parent m3		//not

		Interf in = new Interf();
		in.name2();
	}


	/*
	 * covariant return allowed after java 5
	 * variable resolution based on compiler value always same with respect to reference
	 */

}

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
	public static void getDetail(int val) {
		System.out.println("parent int obj: " + val);
	}

	public static String covariantEx(int val) {
		System.out.println("parent int obj: " + val);
		return String.valueOf(val);
	}

	public static Object covariantEx2(int val) {
		System.out.println("parent int obj: " + val);
		return String.valueOf(val);
	}

	public static double primitive(int val) { // covarient primit
		System.out.println("parent int obj: " + val);
		return val;
	}
}

class COD extends POD {

	public static void getDetail(int val) {
		System.out.println("child int obj: " + val);
	}

	// public static Object covariantEx(int val) { // CE parent cannt be return type
	// in overriding // faulty covarint
	// System.out.println("parent int obj: "+ val);
	// return String.valueOf(val);
	// }

	public static String covariantEx2(int val) { // covarient
		System.out.println("parent int obj: " + val);
		return String.valueOf(val);
	}

	// public static int primitive(int val) { //covarient primit CE return type must
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
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'm1'");
	}
 }
 abstract class ChABsCall2 extends InnerOverriding1 {
	// @Override					//optional
	// void m1() {
	// 	// TODO Auto-generated method stub
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
public class Overriding {

	public static void main(String arg[]) {

		POD obp = new POD();
		obp.getDetail(0);

		COD cob = new COD();
		cob.getDetail(0);

		POD obpc = new COD(); // method resolution is based on run time object ie new COD()
		obpc.getDetail(1);

		an ob = new an();
		System.out.println(ob.abc());

	}

	// covariant return allowed after java 5

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



/**
 * we cannt override static method  ; cannot override; overriden method is static
 */
class StaticOver {
  
	
}

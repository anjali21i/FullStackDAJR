package com.core.fullstack.J2SE;
public class ExceptionHandlingPractice {

	public static void main(String args[]) {

		System.out.println("inside main arguments:: " + args.toString());
		Excep1 cls1 = new Excep1();
		cls1.getDataExcep1();

	}

}

class Excep1 {
	
	public String getDataExcep1() {
		System.out.println("inside getDataExcep1:: ");
		ExceptionContainer excc = new ExceptionContainer();
		
		excc.getDataExcep4();
		
		try {
			excc.getDataExcep40();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		excc.getDataExcep41();
		
		try {
			excc.getDataExcep42();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		excc.getDataExcep43();
		
		try {
			excc.getDataExcep44();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

class ExceptionContainer {

	public int getDataExcep4() {
		System.out.println("inside Excep3.getDataExcep3:: ");
		ExceptionWaliClass exc = new ExceptionWaliClass();
		return exc.getDataExcep5();
	} 
	
	public int getDataExcep40() throws Exception {
		System.out.println("inside Excep3.getDataExcep3:: ");
		ExceptionWaliClass exc = new ExceptionWaliClass();
		return exc.getDataExcep5();
	}

	public int getDataExcep41() {
		try {
			System.out.println("inside Excep4.getDataExcep41:: ");
			ExceptionWaliClass exc = new ExceptionWaliClass();
			exc.getDataExcep5();
			return 0;
		} catch (Exception e) {
			System.out.println("inside Excep4.getDataExcep41 catch:: ");
			throw e;
		}
	}

	public int getDataExcep42() throws Exception {
		try {
			System.out.println("inside Excep4.getDataExcep41:: ");
			ExceptionWaliClass exc = new ExceptionWaliClass();
			exc.getDataExcep5();
			return 0;
		} catch (Exception e) {
			System.out.println("inside Excep4.getDataExcep41 catch:: ");
			throw e;
		}
	}

	public int getDataExcep43() {
		try {
			ExceptionWaliClass exc = new ExceptionWaliClass();
			exc.getDataExcep5();
		} catch (Exception e) {
			System.out.println("inside Excep5.getDataExcep42 catch:: ");
			e.printStackTrace();
		}
		return 0;
	}

	public int getDataExcep44() throws Exception {
		try {
			ExceptionWaliClass exc = new ExceptionWaliClass();
			exc.getDataExcep5();
		} catch (Exception e) {
			System.out.println("inside Excep5.getDataExcep44 catch:: ");
			e.printStackTrace();
		}
		return 0;
	}
}

class ExceptionWaliClass {
	int i = 0;

	public int getDataExcep5() {
		System.out.println("inside Excep5.getDataExcep5:: ");
		i = 5;
		i = i / 0;
		return i;
	}
}

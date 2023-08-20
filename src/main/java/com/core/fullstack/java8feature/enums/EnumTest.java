package com.core.fullstack.java8feature.enums;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public enum EnumTest {

	SMALL, MEDIUM, LARGE, EXTRALARGE;
	
	public String getSize() {
		switch(this) {
		  case SMALL:
		    return "small";
		  case MEDIUM:
		    return "medium";
		  case LARGE:
		    return "large";
		  case EXTRALARGE:
		    return "extra large";
	    default:
	      return null;
		}
	}
	
	public static void main(String[] args) {

		 System.out.println("The size of the pizza is 1" + EnumTest.SMALL.getSize());
		 System.out.println("The size of the pizza is 2 " + EnumTest.SMALL.compareTo(EnumTest.MEDIUM));
		 System.out.println("The size of the pizza is 3 " + EnumTest.SMALL.compareTo(EnumTest.MEDIUM));
		 System.out.println("The size of the pizza is 4 " + EnumTest.SMALL.toString());
		 System.out.println("The size of the pizza is 5 " +  EnumTest.valueOf(SMALL.toString()));
		 System.out.println("The size of the pizza is 6 " +  EnumTest.values().toString());
		 System.out.println("The size of the pizza is 7 " +  EnumTest.MEDIUM.ordinal());
    
		 EnumTest[] enumArray = EnumTest.values();
		 System.out.println("The size of the pizza is 8 " +  enumArray.toString());		
	}
}

package com.core.fullstack.java8feature.enums;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public enum EnumPractice {

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

		 System.out.println("The size of the pizza is 1" + EnumPractice.SMALL.getSize());
		 System.out.println("The size of the pizza is 2 " + EnumPractice.SMALL.compareTo(EnumPractice.MEDIUM));
		 System.out.println("The size of the pizza is 3 " + EnumPractice.SMALL.compareTo(EnumPractice.MEDIUM));
		 System.out.println("The size of the pizza is 4 " + EnumPractice.SMALL.toString());
		 System.out.println("The size of the pizza is 5 " +  EnumPractice.valueOf(SMALL.toString()));
		 System.out.println("The size of the pizza is 6 " +  EnumPractice.values().toString());
		 System.out.println("The size of the pizza is 7 " +  EnumPractice.MEDIUM.ordinal());
    
		 EnumPractice[] enumArray = EnumPractice.values();
		 System.out.println("The size of the pizza is 8 " +  enumArray.toString());		
	}
}

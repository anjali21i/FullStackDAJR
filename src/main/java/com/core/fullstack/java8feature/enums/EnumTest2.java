package com.core.fullstack.java8feature.enums;

enum EnumTest2 {
	SMALL("The size is small."),
	MEDIUM("The size is medium."),
	LARGE("The size is large."),
	EXTRALARGE("The size is extra large.");

	private final String pizzaSize;

	private EnumTest2(String pizzaSize) {
		this.pizzaSize = pizzaSize;
	}

	public String getSize() {
		return this.pizzaSize;
	}
	
	public static void main(String[] args) {
		EnumTest2 size = EnumTest2.SMALL;
		System.out.println(size.getSize());
	}
}

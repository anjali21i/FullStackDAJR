package com.core.fullstack.java8feature.enums;

enum EnumPractice2 {
	SMALL("The size is small."),
	MEDIUM("The size is medium."),
	LARGE("The size is large."),
	EXTRALARGE("The size is extra large.");

	private final String pizzaSize;

	private EnumPractice2(String pizzaSize) {
		this.pizzaSize = pizzaSize;
	}

	public String getSize() {
		return this.pizzaSize;
	}
	
	public static void main(String[] args) {
		EnumPractice2 size = EnumPractice2.SMALL;
		System.out.println(size.getSize());
	}
}

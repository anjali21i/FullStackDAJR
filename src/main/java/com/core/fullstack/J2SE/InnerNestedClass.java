package com.core.fullstack.SCJP;

public class InnerNestedClass {
	public static void main(String args[]) {
		CPU cpu = new CPU();
		CPU.Processor processor = cpu.new Processor();
		CPU.RAM ram = cpu.new RAM();
		System.out.println(processor.getCache(4.2));
		System.out.println(ram.getClockSpeed(3.7));
	}
}

class CPU {
	double price;
	CPU(){};
	CPU (double price) {
		this.price = price;
	}
	double getPrice() {
		return this.price;
	} 
	
	void setPrice(double price) {
		this.price = price;
	}
	class Processor {
		double cores;
		String manufacturer;
		double getCache(double val) {
			return val;
		}
	}
	
	class RAM {
		double memory;
		String manufacturer;
		double getClockSpeed(double val) {
			return val;
		}
	}
}
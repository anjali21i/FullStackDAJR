package com.core.fullstack.J2SE;

public class Inheritance {
  Child objCh = new Child();
  Child objCh2 = new Child("ss","ssr", "ew", 8);
  
}

class Parent {
  String name;
	int sss;
	Parent(String name) {
		this.name=name;
	}

	Parent(String ab, int ss) {
		this.name=ab;
		sss=ss;
	}
	
	public void aaa() {
		name = "aa";
	}
}

class Child extends Parent {
  String me;
  String deo;
	Child(){
		super("ab");
	}
	Child(String me, String deo, String ab, int age){
		super("ab", 8);
    this.me=me;
    this.deo=deo;
	}
}

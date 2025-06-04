package com.core.fullstack.J2SE.basics;
/*
* final keyword learning
*/
public class Basics {
    private final int test;
    private static final int test2;
    {
        test = 10;
    }

    static {
        test2 = 10;
    }

    public int getTestVal() {
        return test;
    }
    public static void main(String[] args) {
        System.out.println("test2:"+ test2);
        Basics basics = new Basics();
        System.out.println("Number is greater than 5"+ basics.test);
        System.out.println("Number is greater than 5"+ basics.getTestVal());
    }
}

final class NonOverrideNonExtendable {
    public void test() {
        System.out.println("This is a final method");
    }
}

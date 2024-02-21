package com.core.fullstack.J2SE;

public class StringPractice {

    public static void main(String arg[]) {
        String ddd = "Hello";

        System.out.println(ddd.toString());
        System.out.println(ddd.hashCode());
        String abc = new String("Hello");
        System.out.println(abc.toString());
        System.out.println(abc.hashCode());
        String bcd = new String("Hello");
        System.out.println(bcd.toString());
        System.out.println(bcd.hashCode() ==abc.hashCode());

        abc = new String("Hello");
        System.out.println(abc.toString());
        System.out.println(abc.hashCode());
        
        
        String eee = "Hello";
        System.out.println(eee.toString());
        System.out.println(eee.hashCode());

    }

}

package com.core.fullstack.J2SE;

interface InterfaceVerietyA{

    static String conSts() {           //jdk 8
        return "I am static method of interface";
    }

    default String defSts() {           //jdk 8
        return "I am static method of interface";
    }

    private String prvCon() {        //jdk 9
        return "I am private method of interface";
    }

    private static String pvtdefSts() {   //jdk 9
        return "I am private static method of interface";
    }

    String display2();       //same as abstract String display3(); 
    abstract String display3(); 

}

interface InterfaceVerietyB{

    static String conSts() {           //jdk 8
        return "I am static method of interface";
    }

    default String defSts() {           //jdk 8
        return "I am static method of interface";
    }

    private String prvCon() {        //jdk 9
        return "I am private method of interface";
    }

    private static String pvtdefSts() {   //jdk 9
        return "I am private static method of interface";
    }

    String display2();       //same as   abstract String display3(); 

}
class ClassInVarietyA implements InterfaceVerietyA{
    @Override
    public String display2() {
        throw new UnsupportedOperationException("Unimplemented method 'display2'");
    }

    @Override
    public String display3() {
        throw new UnsupportedOperationException("Unimplemented method 'display3'");
    }
}

class ClassInVarietyB implements InterfaceVerietyA, InterfaceVerietyB {

    @Override
    public String display2() {
        throw new UnsupportedOperationException("Unimplemented method 'display2'");
    }

    public String defSts() {           //jdk 8
        return "I am static method of interface";
    }
    @Override
    public String display3() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'display3'");
    }
}
/*
 * either add overriding method impl for default method or remove one of the duplicate method from interfaces which is not possible
 * so; we have to provide the definition for default method in child class
 */
// class ClassInVarietyC implements InterfaceVerietyA, InterfaceVerietyB {

//     @Override
//     public String display2() {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'display2'");
//     }

//     // public String defSts() {           //jdk 8
//     //     return "I am static method of interface";
//     // }
// }

@FunctionalInterface
interface FunctInterf{

    String display();                   //only one abstract method
    static String display2(){
        return "";
    }
    default String display3(){
        return "";
    }

    private String display4(){
        return "";
    }

    private static String display5(){
        return "";
    }
}


public class InterfaceVariety {

    public static void main(String[] args) {
        ClassInVarietyA clA = new ClassInVarietyA();
    }
}

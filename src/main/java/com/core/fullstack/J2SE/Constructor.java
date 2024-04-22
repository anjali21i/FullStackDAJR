package com.core.fullstack.J2SE;

public class Constructor {

    // Constructor() {            //recursive method call error in a class
    //     this(7);
    // }
    // Constructor(int a) {
    //     this();
    // }
    
   public static void main(String[] args) {
    
   }
}

class ConstructorA {
    ConstructorA(){}
}

class ConstructorB {
    public ConstructorB(){}
}
class ConstructorC {
    protected ConstructorC(){}
}

class ConstructorD {
    private ConstructorD(){}
}

abstract class ConstructorE {
    private ConstructorE(){} 
}

abstract class ConstructorF {
    protected ConstructorF(){} 
}


class P {
    P(){}       //recommended
    P(int i) {}
}
class C extends P{

    C(int i) {
        super(i);
    }
}

class PEX {
    PEX() {}       //recommended
    PEX(int i) throws Exception {}
}
class CEX extends PEX{

    CEX(int i) throws Exception {

        // try {            //try catch cannt be added in constructor as first line should be super/this
            super(i);
        // } catch (Exception e) {
        //     // TODO: handle exception
        // }
        
    }

}

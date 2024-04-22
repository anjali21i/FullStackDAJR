package com.core.fullstack.J2SE;


/**
 * InnerFunctInterPactice
 */

@FunctionalInterface
interface InnerFunctInterf{

    String var  = "IND";            // public static final String var = "IND";

    String display(String msg);            // public abstract String display();
    static String display2(){
        return "";
    }
    default String display3(){
        return "";
    }
}

interface FunctInterf{

    String display();
    static String display2(){
        return "";
    }
    default String display3(){
        return "";
    }
}

abstract interface FunctInterfc{

    String display();
    static String display2(){
        return "";
    }
    default String display3(){
        return "";
    }
}

interface InnerFunctInte {
    String var  = "IND";            // public static final String var = "IND";
    String display();               // public abstract String display();
    String display2();

    abstract String display3();
    interface InnerInterfc {
        String display2();
    }
    public interface InnerInterfc2 {            //public, protected, private, abstract, static
        String display2();
    }

    static interface InnerInterfc3 {
        String display2();
    }

    abstract interface InnerInterfc4 {
        String display2();
    }

    public static abstract interface InnerInterfc5 {
        String display2();
    }

    class NestedClass {
        String display2() {
            return "NestedClass display2";
        }
    }
}

/**
 * InnerFunctInterPactice
 */
class FunctInterPactice implements InnerFunctInterf {

    public String display(String msg) {
        return msg;
    }
}



public class FunctionalIPractice {
    public static void main(String[] args) {
        //normal method call by creating object and calling method
        FunctInterPactice nn = new FunctInterPactice();
        nn.display("Hello");

        //class obj creation with body
        FunctInterPactice nn2 = new FunctInterPactice() { 
            public String display(String msg) {
                return msg;
            }
        };
        nn2.display("Hello");

        /////////////////////////////////////////////////////////////////
        //functiona; method call by creating object and calling method
        InnerFunctInterf im = new InnerFunctInterf() {
            public String display(String msg) {
                return msg;
            }
        };
        im.display("hha");

        InnerFunctInterf im2 = (String msg) -> {
            return msg;
        };
        im2.display("oio");


        InnerFunctInterf im3 = (msg) -> {return msg;};
        im3.display("oio");

        InnerFunctInterf im4 = (msg) -> msg;
        im3.display("oio");

        // public abstract String display();
   

    }
}

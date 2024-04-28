package com.core.fullstack.java8feature;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Supplier<Boolean> supp = () -> getData("ha");
        supp.get();

        Predicate<String> TESTVAL = (val) -> testVal(val);
        TESTVAL.test("akkak");
        TESTVAL.negate();
        TESTVAL.or(TESTVAL);
        TESTVAL.and(TESTVAL);

        Consumer<String> cons = (val) -> getDataCon(val);
        cons.accept("uiuiu");
        cons.andThen(cons);

        // Create a supplier that produces a random integer
        Supplier<Integer> supplier = () -> (int) (Math.random() * 100);

        Predicate<Integer> TESTIntVAL = (val) -> (val!=null);
        TESTIntVAL.test(supplier.get());

        // Create a consumer that prints the integer to the console
        Consumer<Integer> consumer = (integer) -> System.out.println(integer);
        // Consume the value produced by the supplier
        consumer.accept(TESTIntVAL.test(supplier.get()) ?supplier.get() : null);
    }

    public static Boolean getData(String abc) {
        return true;
    }

    public static String getDataCon(String abc) {
        return abc;
    }

    public static Boolean testVal(String abc) {
        return true;
    }
}

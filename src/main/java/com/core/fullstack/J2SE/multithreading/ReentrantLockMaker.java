package com.core.fullstack.J2SE.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockMaker {
    ReentrantLock lockA = new ReentrantLock();
    private static List<Integer> intVals;

    public String safeMethodA() {
       
        lockA.lock();
        System.out.println("inside safeMethodA");
        try {
            int i = 4;
            intVals = new ArrayList<>();
            while (intVals.size()<10){
                intVals.add(8*i);
                if (intVals.size() > 5) {
                    intVals.add(2*i);
                }
                i++;
                System.out.println("inside safeMethodA :"+intVals);
            }

        } finally {
            System.out.println("inside unlock safeMethodA");
            lockA.unlock();
        }

        return null;
    }

    public String safeMethodB() {
        
        lockA.lock();
        System.out.println("inside safeMethodB");
        try {
            int i = 4;
            intVals = new ArrayList<>();
            while (intVals.size()<10){
                intVals.add(8*i);
                if (intVals.size() > 5) {
                    intVals.add(2*i);
                }
                i++;
                System.out.println("inside safeMethodB::"+intVals);
            }

        } finally {
            System.out.println("inside unlock safeMethodB");
            lockA.unlock();
        }

        return null;
    }

   
}
class ReentrantLockCall {

    public static void main(String[] args) {
        ReentrantLockMaker maker = new ReentrantLockMaker();
        maker.safeMethodA(); 
        maker.safeMethodA();
        maker.safeMethodB();
    }
}

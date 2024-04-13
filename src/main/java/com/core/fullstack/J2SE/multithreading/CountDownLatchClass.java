package com.core.fullstack.J2SE.multithreading;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchClass {

    public static void main(String[] args) {
   
        int i=10;
        CountDownLatch latch = new CountDownLatch(i);
     
        // Thread 1
        new Thread(() -> {
            // Do some work
            int j = i+10;
            latch.countDown(); // Signal that work is done
        }).start();

        // Thread 2
        new Thread(() -> {
            try {
                latch.await(); // Wait for work to be done
                // Continue with dependent work
               
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();

    }

}
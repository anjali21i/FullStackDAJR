package com.core.fullstack.J2SE.multithreading;

public class VolatileThreadComm {

    private volatile boolean flag = false;

    public void setFlag(boolean value) {
        flag = value;
    }

    public void waitForFlag() {
        while (!flag) {
            // Wait until the flag is set by another thread
        }
        System.out.println("Flag is set!");
    }

    public static void main(String[] args) {
        VolatileThreadComm communication = new VolatileThreadComm();

        // Thread 1: Sets the flag
        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(2000);
                communication.setFlag(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Thread 2: Waits for the flag to be set
        Thread thread2 = new Thread(() -> {
            communication.waitForFlag();
        });

        // Start both threads
        thread1.start();
        thread2.start();
    }
    
}

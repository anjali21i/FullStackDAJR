package com.core.fullstack.J2SE.multithreading;

class ThreadStates {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("Thread state: " + thread.getState()); //NEW
        thread.start();
        System.out.println("Thread state: " + thread.getState()); // RUNNABLE
        Thread.sleep(500);
        System.out.println("Thread state: " + thread.getState()); // TIMED_WAITING
        thread.join();
        System.out.println("Thread state: " + thread.getState()); // TERMINATED
    }
}

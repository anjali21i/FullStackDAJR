package com.core.fullstack.J2SE.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MyThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class MyRunnable implements Runnable {
    public void run() {
        // Task to be performed by the thread
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class MyCallable implements Callable<String> {
    public String call() {
        // Task to be performed by the thread
        return "Result";
    }
}

public class Multithread {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        // Start both threads
        t1.start();
        t2.start();

        // Create an instance of the Runnable implementation
        MyRunnable myRunnable = new MyRunnable();

        // Create and start the thread
        Thread thread = new Thread(myRunnable);
        thread.start();

        Thread threadLam = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
                try {
                    Thread.sleep(1000); // Sleep for 1 second
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        });
        threadLam.start();

        // Create an ExecutorService
        try {
            ExecutorService executor = Executors.newSingleThreadExecutor();

            // Submit the Callable and get a Future object
            Future<String> future = executor.submit(new MyCallable());

            // Perform other tasks...

            // Get the result of the Callable
            String result = future.get();

            // Shutdown the ExecutorService
            executor.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
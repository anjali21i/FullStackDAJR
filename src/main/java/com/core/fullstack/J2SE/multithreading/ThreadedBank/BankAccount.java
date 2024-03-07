package com.core.fullstack.J2SE.multithreading.ThreadedBank;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount {
    private double balance;
    private final Lock lock;
    private final Condition sufficientFundsCondition;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
        lock = new ReentrantLock();
        sufficientFundsCondition = lock.newCondition();
    }

    public void deposit(double amount) {
        lock.lock();
        try {
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " deposited $" + amount + ". New balance: $" + balance);
            sufficientFundsCondition.signalAll(); // Notify waiting threads
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(double amount) throws InterruptedException {
        lock.lock();
        try {
            while (balance < amount) {
                System.out.println(Thread.currentThread().getName() + " waiting for sufficient funds...");
                sufficientFundsCondition.await(); // Wait until sufficient funds available
            }
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew $" + amount + ". New balance: $" + balance);
        } finally {
            lock.unlock();
        }
    }
}

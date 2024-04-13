package com.core.fullstack.J2SE.multithreading.ThreadedBank;

public class BankTransaction {
    public static void main(String[] args) {
    	BankAccount account = new BankAccount(1000);

        Runnable depositor = () -> {
            for (int i = 0; i < 5; i++) {
                account.deposit(200);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable withdrawer = () -> {
            for (int i = 0; i < 5; i++) {
                try {
                    account.withdraw(300);
                    Thread.sleep(700);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread depositorThread1 = new Thread(depositor, "Depositor 1");
        Thread depositorThread2 = new Thread(depositor, "Depositor 2");
        Thread withdrawerThread1 = new Thread(withdrawer, "Withdrawer 1");
        Thread withdrawerThread2 = new Thread(withdrawer, "Withdrawer 2");

        depositorThread1.start();
        depositorThread2.start();
        withdrawerThread1.start();
        withdrawerThread2.start();
    }
}

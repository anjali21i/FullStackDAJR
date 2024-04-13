package com.core.fullstack.J2SE.multithreading;

class ChildT {

    int num;

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}

class Producer implements Runnable {

    ChildT threadChild;

    public Producer(ChildT threadChild) {
        this.threadChild = threadChild;
        Thread t = new Thread(this, "Producer");
        t.start();
    }

    @Override
    public void run() {
        int i=0;
        while (true) {
            threadChild.setNum(i++);
        }
    }
}

class Consumer implements Runnable {

    ChildT threadChild;

    public Consumer(ChildT threadChild) {
        this.threadChild = threadChild;
        Thread t = new Thread(this, "Consumer");
        t.start();
    }

    @Override
    public void run() {
        while (true) {
            threadChild.getNum();
            
        }
    }
}

public class InterThreadComm {
    public static void main(String[] args) {
        
    }
}

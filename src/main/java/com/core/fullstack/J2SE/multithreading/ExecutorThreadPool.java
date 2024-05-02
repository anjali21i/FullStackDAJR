package com.core.fullstack.J2SE.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PrintJobs implements Runnable {

    String jobName;
    PrintJobs(String jobName) {
        this.jobName = jobName;
    }

    @Override
    public void run() {
        System.out.println("Thread jobs"+Thread.currentThread().getName());
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }
}
public class ExecutorThreadPool {


    public static void main(String[] args) {
        PrintJobs job1 = new PrintJobs("Anjali");
        PrintJobs job2 = new PrintJobs("Ram");   
        PrintJobs job3 = new PrintJobs("Seta");    
        PrintJobs job4 = new PrintJobs("Popo");
        PrintJobs job5 = new PrintJobs("gwwtuy");
        PrintJobs job6 = new PrintJobs("der");
        PrintJobs job7 = new PrintJobs("erer");   
        PrintJobs job31 = new PrintJobs("rrff");    
        PrintJobs job66 = new PrintJobs("tyui");
        PrintJobs job71 = new PrintJobs("weee");
        PrintJobs job9 = new PrintJobs("oiuyt");
        PrintJobs [] jobarr = {job1, job2, job3, job4, job5, job6, job7, job66, job9, job71 };
        
        ExecutorService service = Executors.newFixedThreadPool(4);

        for (PrintJobs printJob : jobarr) {
            service.submit(printJob);
        }
        service.shutdown();
    }
    
}

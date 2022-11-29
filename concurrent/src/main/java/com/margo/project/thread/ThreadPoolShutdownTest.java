package com.margo.project.thread;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolShutdownTest {

    private ExecutorService executorService;


    private AtomicInteger atomicInteger=new AtomicInteger(0);

    @Before
    public void init() {
        executorService= Executors.newFixedThreadPool(2);
    }

    @Test
    public void cachedThreadPool() throws InterruptedException {
        int count=1000;
        while(count>0) {
            executorService.submit(()->{
                System.out.println(atomicInteger.incrementAndGet());
                try {
                    while(true){
                        System.out.println("sleep.......");
                        Thread.sleep(3000);
                    }
                } catch (InterruptedException e) {
                    System.out.println("shutdown ....");
                }
                for(int i=0;i<100;i++){
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(atomicInteger.incrementAndGet());
                }

            });
            count--;
        }
        executorService.shutdown();
        System.out.println(executorService.isShutdown());
        // shutdown
        try {
            executorService.execute(()->{
                for(int i=0;i<100;i++){
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        System.out.println("shutdown ....");
                    }
                    System.out.println(atomicInteger.incrementAndGet());
                }
            });
        }catch(RejectedExecutionException e){
            System.out.println("shutdown then rejected...");
        }

        //executorService.shutdownNow(); // InterruptedException
        while(true) {
            Thread.sleep(60000);
        }
    }
}

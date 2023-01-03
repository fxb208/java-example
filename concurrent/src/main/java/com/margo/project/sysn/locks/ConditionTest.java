package com.margo.project.sysn.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Thread thread1 = new Thread(()->{
            try {
                lock.lock();
                System.out.println("thread1 get lock");
                System.out.println("thread1 wait");
                condition.await();
                System.out.println("thread1 signal");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });
        thread1.start();
        Thread thread2 = new Thread(()->{
            try {
                lock.lock();
                System.out.println("thread2 get lock");
                System.out.println("thread2 signal");
                condition.signal();
                System.out.println("thread2 exit");
            } finally {
                lock.unlock();
            }
        });
        thread2.start();
        thread1.join();
        thread2.join();
    }
}

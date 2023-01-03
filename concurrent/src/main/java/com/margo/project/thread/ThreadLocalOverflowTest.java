package com.margo.project.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadLocalOverflowTest {
    public static void main(String[] args) throws InterruptedException {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<>());

        for (int i = 0; i < 10; ++i) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("创建对象：");
                    ThreadLocal<TianLuoClass> tianLuoThreadLocal = new ThreadLocal<>();
                    TianLuoClass tianLuoClass = new TianLuoClass();
                    tianLuoThreadLocal.set(tianLuoClass);
                    //tianLuoClass = null; //将对象设置为 null，表示此对象不在使用了
                    // tianLuoThreadLocal.remove();
                }
            });
            Thread.sleep(1000);
        }
    }

    static class TianLuoClass {
        // 100M
        private byte[] bytes = new byte[100 * 1024 * 1024];
    }
}

package com.margo.project.sysn.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Before;
import org.junit.Test;


/**
 *  1，默认的拒绝策略
 *  private static final RejectedExecutionHandler defaultHandler = new AbortPolicy();
 *  
 *  1，阻塞队列 DelayedWorkQueue
 * @author fxb20
 *
 */
public class ScheduledExecutorServiceDemo {
	
	private AtomicInteger atomicInteger=new AtomicInteger(0);
	
    private ScheduledExecutorService pool = null;

    @Before
    public void initSchedulerIfNeeded() {
        if (pool == null) {
        	pool=Executors.newScheduledThreadPool(2);
            pool = new ScheduledThreadPoolExecutor(2,
                new DiscardOldestPolicy());
        }
    }
    
    @Test
    public void submit() throws InterruptedException {
    	long l=System.currentTimeMillis();
    	pool.scheduleAtFixedRate(()->{
    		System.out.println(System.currentTimeMillis()-l+":"+atomicInteger.incrementAndGet());
    		try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	},5000, 2000, TimeUnit.MILLISECONDS);
    	while(true) {
    		Thread.sleep(6000);	
    	}
    }
}

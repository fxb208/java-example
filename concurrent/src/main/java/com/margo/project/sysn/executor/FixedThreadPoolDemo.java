package com.margo.project.sysn.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Before;
import org.junit.Test;

/**
 * 1,阻塞队列为 LinkedBlockingQueue
 * 2,核心线程数和最大线程数相同
 * @author fxb20
 *
 */
public class FixedThreadPoolDemo {
	private ExecutorService fixedThreadPool;
	
	private AtomicInteger atomicInteger=new AtomicInteger(0);
	
	@Before
	public void init() {
		fixedThreadPool=Executors.newFixedThreadPool(2);
	}
	
	@Test
	public void cachedThreadPool() throws InterruptedException {
		int count=1000;
		while(count>0) {
			fixedThreadPool.submit(()->{
				System.out.println(atomicInteger.incrementAndGet());
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});	
			count--;
		}
		while(true) {
    		Thread.sleep(60000);	
    	}
	}
}

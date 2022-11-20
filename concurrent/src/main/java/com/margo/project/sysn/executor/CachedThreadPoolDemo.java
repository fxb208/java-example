package com.margo.project.sysn.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Before;
import org.junit.Test;

/**
 * 1，核心线程数为0，最大线程数为Integer.MAX_VALUE
 * 2，阻塞队列为SynchronousQueue
 *  所以该线程会不断的创建线程，空闲线程存活时间为 60L, TimeUnit.SECONDS
 * @author fxb20
 *
 */
public class CachedThreadPoolDemo {

	private ExecutorService cachedThreadPool;
	
	private AtomicInteger atomicInteger=new AtomicInteger(0);
	
	@Before
	public void init() {
		cachedThreadPool=Executors.newCachedThreadPool();
	}
	
	@Test
	public void cachedThreadPool() throws InterruptedException {
		int count=1000;
		while(count>0) {
			cachedThreadPool.submit(()->{
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

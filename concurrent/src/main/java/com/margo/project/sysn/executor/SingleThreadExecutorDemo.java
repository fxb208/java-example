package com.margo.project.sysn.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Before;
import org.junit.Test;

/**
 * 1,阻塞队列为 LinkedBlockingQueue
 * 2,核心线程数和最大线程数相同,为1
 * @author fxb20
 *
 */
public class SingleThreadExecutorDemo {
	private ExecutorService singleThreadExecutor;
	
	private AtomicInteger atomicInteger=new AtomicInteger(0);
	
	@Before
	public void init() {
		singleThreadExecutor=Executors.newSingleThreadExecutor();
	}
	
	@Test
	public void cachedThreadPool() throws InterruptedException {
		int count=10;
		while(count>0) {
			singleThreadExecutor.submit(()->{
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
		singleThreadExecutor.shutdown();
		while(!singleThreadExecutor.isTerminated()) {
    		Thread.sleep(3000);	
    	}
	}
}

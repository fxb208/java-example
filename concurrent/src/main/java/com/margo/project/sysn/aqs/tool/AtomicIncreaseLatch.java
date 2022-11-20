package com.margo.project.sysn.aqs.tool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * CountDownLatch
 * @author fxb208
 *
 */
public class AtomicIncreaseLatch {
	
	private static AtomicInteger race=new AtomicInteger(0);
	
	public static void increase() {
		race.incrementAndGet();
	}
	
	private static final int THREADS_COUNT=20;
	
	private static CountDownLatch latch=new CountDownLatch(THREADS_COUNT);
	
	public static void main(String[] args) throws InterruptedException {
		Thread[] arrThread=new Thread[THREADS_COUNT];
		for(int i=0;i<arrThread.length;i++) {
			arrThread[i]=new Thread(new Runnable() {
				@Override
				public void run() {
					for(int i=0;i<1000;i++) {
						increase();
					}
					latch.countDown();
				}
			});
			arrThread[i].start();
		}
		latch.await();
		System.out.println(race.get());
	}
}

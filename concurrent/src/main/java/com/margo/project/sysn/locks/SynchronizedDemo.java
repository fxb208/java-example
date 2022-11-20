package com.margo.project.sysn.locks;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

public class SynchronizedDemo {
	
	private AtomicInteger atomicInteger=new AtomicInteger(0);
	
	private CountDownLatch latch=new CountDownLatch(1);

	/**
	 * jstack
	 * "Thread-5" #25 prio=5 os_prio=0 tid=0x00000000220c5800 nid=0x1ad5c waiting for monitor entry [0x000000002381f000]
	 * java.lang.Thread.State: BLOCKED (on object monitor)
	 * at com.margo.project.sysn.locks.SynchronizedDemo$1.run(SynchronizedDemo.java:20)
	 * - waiting to lock <0x000000076d209c88> (a java.lang.Class for com.margo.project.sysn.locks.SynchronizedDemo)
	 * at java.lang.Thread.run(Thread.java:748)
	 * @throws InterruptedException
	 */
	@Test
	public void lock() throws InterruptedException {
		Runnable task=new Runnable() {
			public void run() {
				synchronized (SynchronizedDemo.class) {
					System.out.println(atomicInteger.incrementAndGet());
					try {
						TimeUnit.SECONDS.sleep(20);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		int i=5;
		while(i>0) {
			Thread thread=new Thread(task);
			thread.start();
			i--;
		}
		latch.await();
	}
}

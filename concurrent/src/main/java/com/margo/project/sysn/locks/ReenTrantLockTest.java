package com.margo.project.sysn.locks;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

public class ReenTrantLockTest {

	int state=10;
	
	private CountDownLatch latch=new CountDownLatch(5);
	
	
	/**
	 * jstack 
	 * @throws InterruptedException
	 */
	@Test
	public void reentrantLock() throws InterruptedException {
		ReentrantLock lock=new ReentrantLock();
		for(int i=0;i<5;i++) {
			new Thread(()-> {
				lock.lock();
				try {
					state++;
					System.out.println("共享线程操作");
					Thread.sleep(60000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
				latch.countDown();
			}).start();
		}
		latch.await();
		System.out.println(state);
	}
}

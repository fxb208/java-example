package com.margo.project.sysn.locks;

import java.util.concurrent.locks.LockSupport;

import org.junit.Test;

/**
 * 1)LockSupport.park不会改变中断标志状态
 * 2)可以先unpark,然后park
 * @author fxb208
 *
 */
public class LockSupportTest {
	
	/**
	 * jstack信息   LockSupport.park();
	 * 
	 * "fxb20" #21 prio=5 os_prio=0 tid=0x0000000022125800 nid=0x132c4 waiting on condition [0x00000000236bf000]
	 * java.lang.Thread.State: WAITING (parking)
	 * at sun.misc.Unsafe.park(Native Method)
	 * at java.util.concurrent.locks.LockSupport.park(LockSupport.java:304)
	 * at com.margo.project.sysn.locks.LockSupportTest$1.run(LockSupportTest.java:22)
	 * at java.lang.Thread.run(Thread.java:748)
	 * @throws InterruptedException
	 */
	//@Test
	public void test() throws InterruptedException {
		Thread thread=new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("执行方法");
				LockSupport.park();
				System.out.println("继续执行方法");
			}
		},"fxb20");
		thread.start();
		Thread.sleep(15000);
		System.out.println(thread.isInterrupted());  //false  LockSupport.park不会改变中断标志
		Thread.sleep(15000);
		System.out.println("调用unpark");
		LockSupport.unpark(thread);
	}
	
	@Test
	public void test2() throws InterruptedException {
		Thread thread=new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("执行方法");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("调用park");
				LockSupport.park();
				System.out.println("继续执行方法");
			}
		});
		thread.start();
		System.out.println("调用unpark");
		LockSupport.unpark(thread);
		thread.join();
		System.out.println("主线程继续执行");
	}
}

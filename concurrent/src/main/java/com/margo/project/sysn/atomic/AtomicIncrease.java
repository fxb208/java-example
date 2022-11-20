package com.margo.project.sysn.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * atomic自增运算
 * @author fxb208
 *
 */
public class AtomicIncrease {
	private static AtomicInteger race=new AtomicInteger(0);
	
	public static void increase() {
		race.incrementAndGet();
	}
	
	private static final int THREADS_COUNT=20;
	
	public static void main(String[] args) {
		Thread[] arrThread=new Thread[THREADS_COUNT];
		for(int i=0;i<arrThread.length;i++) {
			arrThread[i]=new Thread(new Runnable() {
				@Override
				public void run() {
					for(int i=0;i<1000;i++) {
						increase();
					}
					
				}
			});
			arrThread[i].start();
		}
		while(Thread.activeCount()>1) {
			/**
			 * yield()方法：暂停当前正在执行的线程对象，并执行其他线程。
			 * 结论：yield()从未导致线程转到等待/睡眠/阻塞状态。
			 * 在大多数情况下，yield()将导致线程从运行状态转到可运行状态，但有可能没有效果。
			 */
			Thread.yield();
		}
		System.out.println(race.get());
	}
}

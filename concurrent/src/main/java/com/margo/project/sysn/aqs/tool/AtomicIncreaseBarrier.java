package com.margo.project.sysn.aqs.tool;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1,Java中CyclicBarrier 和 CountDownLatch有什么不同？
 * 1)CyclicBarrier 和 CountDownLatch 都可以用来让一组线程等待其它线程
 * 2)CyclicBarrier加数，CountDownLatch减数方式
 * 3)CyclicBarrier达到初始值可以重置复用，CountDownLatch不可以复用
 * 
 * 2,CyclicBarrier原理
 * https://blog.csdn.net/qq_39241239/article/details/87030142
 * @author fxb208
 *
 */
public class AtomicIncreaseBarrier {
	private static AtomicInteger race=new AtomicInteger();
	
	public static void increase() {
		race.incrementAndGet();
	}
	
	public static final int THREADS_COUNT=20;
	
	private static CyclicBarrier cyclicBarrier=new CyclicBarrier(THREADS_COUNT);
	
	public static void main(String[] args) {
		Thread[] arrThread=new Thread[THREADS_COUNT];
		for(int i=0;i<THREADS_COUNT;i++) {
			arrThread[i]=new Thread(new Runnable() {
				@Override
				public void run() {
					for(int j=0;j<1000;j++) {
						increase();
					}
					try {
						cyclicBarrier.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (BrokenBarrierException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(race.get());
				}
			});
			arrThread[i].start();
		}
		
	}
	
	
}

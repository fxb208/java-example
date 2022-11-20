package com.margo.project.sysn.atomic;

public class UnSafeIncrease {
	
	private static volatile int race=0;
	
	public static void increase() {
		race+=1;
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
			Thread.yield();
		}
		System.out.println(race);
	}
}

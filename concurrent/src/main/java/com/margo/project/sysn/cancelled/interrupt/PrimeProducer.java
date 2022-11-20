package com.margo.project.sysn.cancelled.interrupt;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

public class PrimeProducer extends Thread{
	private final BlockingQueue<BigInteger> queue;
	
	public PrimeProducer(BlockingQueue<BigInteger> queue) {
		this.queue=queue;
	}
	
	public void run() {
		try {
			BigInteger p=BigInteger.ONE;
			while(!Thread.currentThread().isInterrupted()) {
				System.out.println(Thread.currentThread().isInterrupted());
				queue.put(p=p.nextProbablePrime());
			}
		} catch (InterruptedException  e) {
			System.out.println("中断了");
			/* 允许线程退出*/
			e.printStackTrace();
		}
	}
	
	public void cancel() {
		System.out.println("调用interrupt");
		interrupt();
	}
}

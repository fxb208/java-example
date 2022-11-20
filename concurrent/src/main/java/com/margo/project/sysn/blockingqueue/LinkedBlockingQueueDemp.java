package com.margo.project.sysn.blockingqueue;

import java.util.concurrent.LinkedBlockingQueue;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author fxb20
 *
 */
public class LinkedBlockingQueueDemp {
	
	private LinkedBlockingQueue<Integer> queue;
	
	@Before
	public void init() {
		queue=new LinkedBlockingQueue<Integer>();
	}
	
	//@Test
	public void offer() {
		queue.offer(12);
	}
	
	//@Test
	public void poll() {
		queue.poll();
	}
	
	@Test
	public void put() throws InterruptedException {
		queue.put(1); 
		queue.put(2); 
		System.out.println("***");
		queue.put(3);  //无线队列
		System.out.println("###");
	}
	
	//@Test
	public void take() throws InterruptedException {
		queue.take();
	}
}

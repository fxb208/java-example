package com.margo.project.sysn.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author fxb20
 *
 */
public class ArrayBlockingQueueDemo {
	
	private ArrayBlockingQueue<Integer> queue;
	
	@Before
	public void init() {
		queue=new ArrayBlockingQueue<Integer>(2);
	}
	
	//@Test
	public void offer() {
		System.out.println(queue.offer(1)); //true
		System.out.println(queue.offer(2)); //true
		System.out.println(queue.offer(3)); //false
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
		queue.put(3);  //阻塞
		System.out.println("###");
	}
	
	//@Test
	public void take() throws InterruptedException {
		queue.take();
	}
	
	//@Test
	public void pollTimeOut() throws InterruptedException {
		Integer result=queue.poll(5,TimeUnit.SECONDS);
		System.out.println("result:"+result);
	}
	
	//@Test
	public void offerTimeOut() throws InterruptedException {
		queue.put(1); 
		System.out.println(queue.offer(2)); //true
		System.out.println("***");
		queue.offer(3,5,TimeUnit.SECONDS);  //阻塞
		System.out.println("###");
	}
}

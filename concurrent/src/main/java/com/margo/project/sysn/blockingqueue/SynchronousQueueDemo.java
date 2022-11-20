package com.margo.project.sysn.blockingqueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;

/**
 * @Test 单线程执行
 * @author fxb20
 *
 */
public class SynchronousQueueDemo {
	
	private SynchronousQueue<Integer> queue;
	
	
	@Before
	public void init() {
		queue=new SynchronousQueue<Integer>();
	}

	//@Test
	public void offer() throws InterruptedException {
		System.out.println(Thread.currentThread().getId());
		while(true) {
			Thread.sleep(1000);
			queue.offer(12);
		}
		
	}
	
	//Test
	public void poll() throws InterruptedException {
		System.out.println(Thread.currentThread().getId());
		while(true) {
			Thread.sleep(1000);
			queue.poll();
		}
		
	}
	
    @Test
    public void useSynchronousQueue() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        SynchronousQueue<Integer> synchronousQueue=new SynchronousQueue<Integer>();


		Runnable producer = () -> {
			Integer object=12;
            try {
                synchronousQueue.put(object);
            } catch (InterruptedException ex) {
            	System.out.println(ex);
            }
            System.out.println("produced {}:"+object);
        };

        Runnable consumer = () -> {
            try {
            	Integer object = synchronousQueue.take();
                System.out.println("consumed {}:"+object);
            } catch (InterruptedException ex) {
            	System.out.println(ex);
            }
        };

        executor.submit(producer);
        executor.submit(consumer);

        executor.awaitTermination(50000, TimeUnit.MILLISECONDS);
        executor.shutdown();
    }

}

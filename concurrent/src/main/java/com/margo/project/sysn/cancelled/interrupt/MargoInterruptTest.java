package com.margo.project.sysn.cancelled.interrupt;

import org.junit.Test;

/**
 * 1)
 * isInterrupted 对象方法   return boolean
 * interrupt 对象方法  void
 * interrupted static方法  返回中断状态，并清除中断状态(第一次调用返回true，再次调用会返回false)
 * 
 * 2)
 * InterruptedException 会清除中断状态
 * @author fxb208
 *
 */
public class MargoInterruptTest {
	
	//@Test
	public void isInterrupted() {
		Thread thread=new Thread(new MargoThread());
		thread.start();
		System.out.println(thread.isInterrupted());
	}
	
	//@Test
	public void interrupt() {
		Thread thread=new Thread(new MargoThread());
		thread.start();
		thread.interrupt();
	}
	
	@Test
	public void interrupted() throws InterruptedException {
		Thread thread=new Thread(new MargoInterruptedThread());
		thread.start();
		Thread.sleep(1000); //休眠
		thread.interrupt();
		thread.join();
	}

	static class MargoThread implements Runnable{
		@Override
		public void run() {
			System.out.println("运行线程");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println("中断线程");
				e.printStackTrace();
			}
		}
		
	}
	
	static class MargoInterruptedThread implements Runnable{
		@Override
		public void run() {
			System.out.println("运行线程............");
			try {
				System.out.println("运行线程:"+Thread.interrupted());   //false
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.out.println("中断线程:"+Thread.interrupted()); //true
				//e.printStackTrace();
			}
			System.out.println(Thread.currentThread().isInterrupted()); //false
		}
		
	}
}

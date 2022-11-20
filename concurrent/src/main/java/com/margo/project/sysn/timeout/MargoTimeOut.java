package com.margo.project.sysn.timeout;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 *  thread.interrupt中断
 * @author fangxingbang
 *
 */
public class MargoTimeOut {
	public static void main(String[] args) throws InterruptedException {
		//任务线程
		Callable<String> callable=new Callable<String>() {
			@Override
			public String call() throws Exception {
				System.out.println(Thread.currentThread().getName());
				//执行任务
				Thread.sleep(300000);
				//返回结果
				return "东方不败";
			}
		};
		FutureTask<String> future=new FutureTask<>(callable);
		Thread thread=new Thread(future);
		thread.start();
		try {
			//获取结果，两秒之后不返回结果,抛出异常
			String name=future.get(2000,TimeUnit.MILLISECONDS);
			System.out.println(name);
		} catch (InterruptedException e) {
			throw new RuntimeException("中断异常",e);
		} catch (ExecutionException e) {
			throw new RuntimeException("执行异常",e);
		} catch (TimeoutException e) {
			System.out.println("超时异常");
			//中断任务线程
			thread.interrupt();
			thread.join();
		}
		Thread.sleep(300000);
	}
}

package com.margo.project.sysn.timeout;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 	
 * @author fangxingbang
 *
 */
public class ThreadPoolTimeOut {
	public static void main(String[] args) {
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
		ExecutorService executor=Executors.newFixedThreadPool(4);
		Future<String> future=executor.submit(callable);
		try {
			//获取结果，两秒之后不返回结果,抛出异常
			String name=future.get(2000,TimeUnit.MILLISECONDS);
			System.out.println(name);
		} catch (InterruptedException e) {
			//throw new RuntimeException("中断异常",e);
		} catch (ExecutionException e) {
			//throw new RuntimeException("执行异常",e);
		} catch (TimeoutException e) {
			//throw new RuntimeException("超时异常",e);
		} finally {
			future.cancel(true);
		}
		for(int i=0;i<16;i++) {
			//任务线程
			Runnable callable2=new Runnable() {
				@Override
				public void run(){
					System.out.println(Thread.currentThread().getName());
				}
			};
			executor.submit(callable2);
		}
	
	}
}

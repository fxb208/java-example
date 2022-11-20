package com.margo.project.asyn;

import java.util.concurrent.CompletableFuture;

/**
 * 创建CompletableFuture是通过CompletableFuture.supplyAsync()实现的,他要需要一个实现Supplier接口的对象
 * 完成时会调用Consumer对象
 * 异常时会调用Function对象
 * @author fangxingbang
 *
 */
public class MargoSimpleCompletableFuture {
	
	public static void main(String[] args) {
		simple();
	}
	
	public static void simple() {
		MargoSimpleCompletableFuture margoCompletableFuture=new MargoSimpleCompletableFuture();
		CompletableFuture<Double> cf=CompletableFuture.supplyAsync(margoCompletableFuture::fetchPrice);
		//执行成功
		cf.thenAccept(result->{
			System.out.println("price:"+result);
		});
		//执行失败
		cf.exceptionally(e->{
			e.printStackTrace();
			return null;
		});
		//主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭
		try {
			Thread.sleep(200);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public Double fetchPrice() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(Math.random()<0.3) {
			throw new RuntimeException("fetchPrice fail");
		}
		return 5+Math.random()*20;
	}
}

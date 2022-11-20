package com.margo.project.asyn;

import java.util.concurrent.CompletableFuture;

/**
 * serial串行
 * CompletableFuture命名规则
 * 		xxx()表示该方法将继续在已有线程执行
 * 		xxxAsync()表示该方法在线程池中执行
 * @author fangxingbang
 *
 */
public class MargoSerialCompletableFuture {
	public static void main(String[] args) {
		serial();
	}
	
	public static void serial() {
		CompletableFuture<String> cfQuery=CompletableFuture.supplyAsync(()->{
			return queryCode("中国石化");
		});
		
		CompletableFuture<Double> cfFetch=cfQuery.thenApplyAsync((code)->{
			return fetchPrice(code);
		});
		
		cfFetch.thenAccept(result->{
			System.out.println("Price:"+result);
		});
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static String queryCode(String name) {
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "601857";
	}
	
	public static Double fetchPrice(String code) {
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

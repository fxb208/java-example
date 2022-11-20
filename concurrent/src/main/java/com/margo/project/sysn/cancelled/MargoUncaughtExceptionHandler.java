package com.margo.project.sysn.cancelled;

import java.lang.Thread.UncaughtExceptionHandler;


/**
 * 	线程异常异常处理
 * @author fangxingbang
 *
 */
public class MargoUncaughtExceptionHandler {
	public static void main(String[] args) {
		Thread thread=new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(1/0);
			}
		});
		thread.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println(e.getMessage());
			}
			
		});
		thread.start();
	}
}

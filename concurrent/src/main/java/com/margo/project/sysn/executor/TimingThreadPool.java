package com.margo.project.sysn.executor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class TimingThreadPool extends ThreadPoolExecutor{

	private ThreadLocal<Long> startTime=new ThreadLocal<>();
	
	private final AtomicLong totalTime=new AtomicLong();
	
	private final AtomicLong numTasks=new AtomicLong();
	
	
	public TimingThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
	}
	
	protected void beforeExecute(Thread t, Runnable r) {
		super.beforeExecute(t, r);
		System.out.println("beforeExecute..............................");
		startTime.set(System.nanoTime());
	}

	protected void afterExecute(Runnable r, Throwable t) { 
		super.afterExecute(r, t);
		System.out.println("afterExecute..............................");
		long endTime=System.nanoTime();
		long taskTime=endTime-startTime.get();
		numTasks.incrementAndGet();
		totalTime.addAndGet(taskTime);
	}
	
	protected void terminated() { 
		try {
			System.out.println("花费时间："+totalTime.get());
			System.out.println("执行任务："+numTasks.get());
		} finally {
			super.terminated();
		}
	}
}

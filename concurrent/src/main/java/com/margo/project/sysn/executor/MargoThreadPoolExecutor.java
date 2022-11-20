package com.margo.project.sysn.executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;

/**
 * terminating
 * 		v.	(使) 停止，结束，终止; 到达终点站;
 * 
 * excess 英[ɪkˈses , ˈekses] 美[ɪkˈses , ˈekses]
 * n.	超过; 过度; 过分; 过多的量; 超过的量; 免赔额; 自负额;
 * adj.	超额的; 额外的; 附加的; 过度的;
 * 
 * idle	英[ˈaɪdl] 美[ˈaɪdl]
 * adj.	懈怠的; 懒惰的; 闲置的; 没有工作的; 闲散的;
 * v.	混时间; 闲荡; 无所事事; 空转; 挂空挡; 未熄火; (尤指暂时地) 关闭工厂，使(工人)闲着;
 * @author fxb208
 *
 */
public class MargoThreadPoolExecutor {
	
	@Test
	public void test() {
		CountDownLatch latch=new CountDownLatch(20);
		BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(16);
		ThreadFactory threadFactory = Executors.defaultThreadFactory();
		RejectedExecutionHandler handler = new AbortPolicy();
		//DefaultThreadFactory
		//ThreadPoolExecutor executor=new ThreadPoolExecutor(4, 8, 5, TimeUnit.MINUTES, workQueue, threadFactory, handler);
		
		TimingThreadPool executor=new TimingThreadPool(4, 8, 5, TimeUnit.MINUTES, workQueue, threadFactory, handler);

		for(int i=0;i<20;i++) {
			Runnable command=new Runnable() {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName());
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					latch.countDown();
				}
			};
			executor.execute(command);
		}
		try {
			latch.await();
			System.out.println("跑完了");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	int shareVar=0;
	
	public void cacheThreadPool() {
		ExecutorService threadPool = Executors.newCachedThreadPool();
		// ExecutorService threadPool = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 100; i++) {
			threadPool.execute(new Runnable() {

				@Override
				public void run() {
					String currentThread = Thread.currentThread().getName();
					System.out.println("当前是" + shareVar + " " + currentThread);
					shareVar++;
				}

			});
		}
		threadPool.shutdown();
		System.out.println(shareVar);
	}

}

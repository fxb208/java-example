package com.margo.project.sysn.cancelled.future;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import com.margo.project.sysn.cancelled.vola.PrimeGenerator;

public class YbFutureCancel {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService exec=Executors.newCachedThreadPool();
		PrimeGenerator task=new PrimeGenerator();
		Future<?> future=exec.submit(task);
		TimeUnit.MILLISECONDS.sleep(100);
		future.cancel(true);
		List<BigInteger> lstPrime=task.get();
		for(int i=0;i<lstPrime.size();i++) {
			System.out.println(lstPrime.get(i));
		}
	}
}

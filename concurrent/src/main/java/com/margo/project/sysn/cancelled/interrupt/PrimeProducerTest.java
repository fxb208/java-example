package com.margo.project.sysn.cancelled.interrupt;

import java.math.BigInteger;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class PrimeProducerTest {
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<BigInteger> queue=new ArrayBlockingQueue<>(100);
		PrimeProducer primeProducer=new PrimeProducer(queue);
		Thread producer=new Thread(primeProducer);
		producer.start();
		try {
			Thread.sleep(100);
		} finally {
			primeProducer.cancel();
		}
	
		
		
	}
	
}

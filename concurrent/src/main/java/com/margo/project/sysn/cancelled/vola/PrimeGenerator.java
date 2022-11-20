package com.margo.project.sysn.cancelled.vola;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
/**
 * 素数生成器
 * @author fxb208
 *
 */
public class PrimeGenerator implements Runnable{
	private final List<BigInteger> primes=new ArrayList<BigInteger>();
	//开关
	private volatile boolean cancelled;
	@Override
	public void run() {
		BigInteger p=BigInteger.ONE;
		while(!cancelled) {
			p=p.nextProbablePrime();
			synchronized (this) {
				primes.add(p);
			}
		}
	}

	public void cancel() {
		cancelled=true;
	}
	
	public synchronized List<BigInteger> get(){
		return new ArrayList<>(primes);
	}
}

package com.margo.project.sysn.cancelled.vola;

import java.math.BigInteger;
import java.util.List;

public class PrimeGeneratorTest {
	public static void main(String[] args) throws InterruptedException {
		PrimeGenerator primeGenerator=new PrimeGenerator();
		new Thread(primeGenerator).start();
		try {
			Thread.sleep(1000);
		} finally {
			primeGenerator.cancel();
		}
		List<BigInteger> lstPrime=primeGenerator.get();
		for(int i=0;i<lstPrime.size();i++) {
			System.out.println(lstPrime.get(i));
		}
	}
}

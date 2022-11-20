package com.margo.project.discretemathematics.numbertheory;

public class YbModularExponentiation {
	
	public static void main(String[] args) {
		YbModularExponentiation yb=new YbModularExponentiation();
		System.out.println(yb.modularExponentiation(90, 101, 1189));
	}
	
	/**
	 * b^n %m
	 * @param b
	 * @param n
	 * @param m
	 * @return
	 */
	public int modularExponentiation(int P,int E,int n) {
		int r2=1;
		int p=P;
		int e=E;
		while(e!=0) {
			int Q=e/2;
			int R=e%2;
			int r1=p*p%n;
			if(R==1) {
				r2=r2*p%n;
			}
			p=r1;
			e=Q;
		}
		return r2;
	}

}

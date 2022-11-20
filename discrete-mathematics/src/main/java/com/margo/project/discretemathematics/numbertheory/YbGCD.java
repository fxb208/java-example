package com.margo.project.discretemathematics.numbertheory;

/**
 * 欧几里得算法 求最大公约数
 * @author fxb20
 *
 */
public class YbGCD {
	
	public static void main(String[] args) {
		YbGCD yb=new YbGCD();
		System.out.println(yb.gcd(12, 15));

		int a=4;
		int b=8;
		while(a !=0){
			int n=b%a;
			b=a;
			a=n;
		}
	}
	
    public int findGCD(int[] nums) {
    	int min=nums[0];
    	int max=nums[0];
    	for(int i=1;i<nums.length;i++) {
    		max=Math.max(max, nums[i]);
    		min=Math.min(min, nums[i]);
    	}
    	return gcd(max,min);
    }
    
    int gcd(int a,int b) {
    	return b==0 ? a:gcd(b,a%b);
    }
}

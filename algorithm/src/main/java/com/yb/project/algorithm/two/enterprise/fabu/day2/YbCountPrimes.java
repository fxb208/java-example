package com.yb.project.algorithm.two.enterprise.fabu.day2;

import java.util.Arrays;

/**
 * 204. 计数质数
 * https://leetcode.cn/problems/count-primes/
 *
 */
public class YbCountPrimes {

    public static void main(String[] args) {
        YbCountPrimes yb = new YbCountPrimes();
        yb.countPrimes_2(499979);
    }

    public int countPrimes_2(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim,true);
        int result = 0;
        for(int i=2;i<n;i++){
            if(isPrim[i]){
                result ++;
                for(long j=(long)i*(long)i;j<n;j+=i){
                    isPrim[(int)j]=false;
                }
            }
        }
        return result;
    }


    public int countPrimes_1(int n) {
        int result = 0;
        for(int i=2;i<n;i++){
            if(isPrimes(i)){
                result ++;
            }
        }
        return result;
    }

    public boolean isPrimes(int n){
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}

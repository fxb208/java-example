package leetcode.od.other;

import java.util.Arrays;

/**
 *  204. 计数质数
 *  给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。
 */
public class Leetcode204 {

    public static void main(String[] args) {
        Leetcode204 yb = new Leetcode204();
        System.out.println(yb.countPrimes(100));
        System.out.println(yb.countPrimes_v(100));
    }

    public int countPrimes(int n) {
        int[] arr = new int[n+1];
        Arrays.fill(arr,1);
        int res = 0;
        for(int i=2;i<=n;i++){
            if(arr[i]==1){
                res++;
                for(int j=1;i*j<=n;j++){
                    arr[i*j]=0;
                }
            }
        }
        return res;
    }

    public int countPrimes_v(int n) {
        int res=0;
        for(int i=2;i<n;i++){
            if(isPrime(i)){
                res++;
            }
        }
        return res;
    }

    public boolean isPrime(int n){
        int k=(int)Math.sqrt(n);
        int count=0;
        for(int i=2;i<=k;i++){
            while(n%i==0){
                n/=i;
                return false;
            }
        }
        return true;
    }

    public int gcd(int a,int b){
        return a%b==0 ? b: gcd(b,a%b);
    }

}

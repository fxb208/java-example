package com.yb.project.code;

public class Example02 {
    public static void main(String[] args) {
        Example02 yb = new Example02();
        System.out.println(yb.nums2());
    }

    public int nums(){
        int res=1;
        while(res%2>0 || res%3>0 || res%5>0 || res%6>0 || res%7>0){
            res++;
        }
        return res-1;
    }

    public int nums2(){
        int[] arr = new int[]{2,3,5,6,7};
        int res = arr[0];
        for(int i=1;i<arr.length;i++){
            res = res*arr[i]/gcd(res,arr[i]);
        }
        return res-1;
    }

    public int gcd(int a,int b){
        return a%b==0?b:gcd(b,a%b);
    }
}

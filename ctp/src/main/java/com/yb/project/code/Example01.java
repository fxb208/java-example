package com.yb.project.code;

/**
 *
 */
public class Example01 {
    public static void main(String[] args) {
        Example01 yb = new Example01();
        System.out.println(yb.square(9,4));
    }

    public int square(int num,int k){
        if(k==0){
            return 1;
        }
        if(k==1){
            return num;
        }
        int n = k/2;
        return square(num,n)*square(num,n)*square(num,k%2);
    }
}

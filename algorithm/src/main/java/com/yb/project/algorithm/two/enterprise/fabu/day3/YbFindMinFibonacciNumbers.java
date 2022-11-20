package com.yb.project.algorithm.two.enterprise.fabu.day3;

import java.util.LinkedList;

/**
 * 1414. 和为 K 的最少斐波那契数字数目
 * https://leetcode.cn/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/
 */
public class YbFindMinFibonacciNumbers {
  public static void main(String[] args) {
    //
      YbFindMinFibonacciNumbers yb = new YbFindMinFibonacciNumbers();
      System.out.println(yb.findMinFibonacciNumbers(10));
  }

    public int findMinFibonacciNumbers(int k) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(1);
        int a = 1;
        int b = 1;
        while (a+b <= k){
            int c = a+b ;
            list.add(c);
            a = b;
            b = c;
        }
        int res = 0;
        while(k>0){
            int last = list.pollLast();
            if(k == last){
                res ++;
                break;
            }else if(k>last && k < 2*last){
                res ++;
                k -= last;
            }
        }
        return res;
    }
}

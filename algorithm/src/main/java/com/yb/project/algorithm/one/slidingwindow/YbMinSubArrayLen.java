package com.yb.project.algorithm.one.slidingwindow;


/**
 * leecode209 长度最小的子数组
 * @author fxb20
 * 
 * 给定一个含有n个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。
 * 如果不存在符合条件的子数组，返回 0 。
 * 
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *
 */
public class YbMinSubArrayLen {
	public static void main(String[] args) {
		YbMinSubArrayLen yb=new YbMinSubArrayLen();
		int[] arr=new int[] {2,3,1,2,4,3};
		int result=yb.minSubArrayLen(7, arr);
		System.out.println(result);
	}
	
    public int minSubArrayLen(int target, int[] nums) {
    	int sum=0; //计数
    	int length=0; //结果
    	int k=0;   //窗口宽度
    	for(int i=0;i<nums.length;i++) {
    		sum=sum+nums[i];
    		if(length==0) {
        		k++;	
    		}else {
    			sum=sum-nums[i-k];
    		}
    		if(sum>=target && length==0) {
    			length=k;
    		}
    		//缩减窗口
    		while(length>1 && (sum-nums[i-k+1])>=target) {
    			length--;
    			sum=sum-nums[i-k+1];
    			k--;
    		}
    	}
        return length;
    }
}

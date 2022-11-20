package com.yb.project.algorithm.one.prefixsum;

import java.util.HashMap;
import java.util.Map;

/**
 * leecode 523. 连续的子数组和
 * @author fxb20
 * 
 * 给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
 * 子数组大小 至少为 2 ，且子数组元素总和为 k 的倍数。
 * 如果存在，返回 true ；否则，返回 false 。
 * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。0 始终视为 k 的一个倍数。
 * 
 * 输入：nums = [23,2,4,6,7], k = 6
 * 输出：true
 * 解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/continuous-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class YbCheckSubarraySum {
	public static void main(String[] args) {
		YbCheckSubarraySum yb=new YbCheckSubarraySum();
		int[] nums=new int[] {23,6,9};
		System.out.println(yb.checkSubarraySum0(nums, 6));
	}
	
    public boolean checkSubarraySum(int[] nums, int k) {
    	int n=nums.length;
    	int[] sum=new int[n+1];
    	for(int i=1;i<=n;i++) {
    		sum[i]=sum[i-1]+nums[i-1];
    	}
    	Map<Integer, Integer> map=new HashMap<Integer, Integer>();
    	map.put(0, 0);
    	for(int i=1;i<=n;i++) {
    		int a=sum[i]%k;
    		if(!map.containsKey(a)) {
    			map.put(a, i);
    		}else {
    			int val=map.get(a);
    			if(i-val>1) {
    				return true;
    			}
    		}
    	}
    	
    	return false;
    }
    
    /**
     * 暴力算法
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySum0(int[] nums, int k) {
    	int n=nums.length;
    	for(int i=0;i<n-1;i++) {
    		int s=nums[i];
    		for(int j=i+1;j<n;j++) {
    			s+=nums[j];
                if(s%k==0) {
        			return true;
        		}
    		}
    	}
    	return false;
    }
}

package com.yb.project.algorithm.one.prefixsum;

import java.util.HashMap;
import java.util.Map;

/**
 * 525. 连续数组
 * @author fxb20 
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 * 
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。
 * 
 * 输入: nums = [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
 *
 */
public class YbFindMaxLength {
	
	public static void main(String[] args) {
		int[] nums=new int[] {0,1,1,0,1,1,1,0};
		YbFindMaxLength yb=new YbFindMaxLength();
		System.out.println(yb.findMaxLength(nums));
	}
	
	/**
	 * @param nums
	 * @return
	 */
    public int findMaxLength(int[] nums) {
    	Map<Integer,Integer> map=new HashMap<Integer, Integer>();
    	map.put(0, -1);
    	int counter=0;
    	int result=0;
    	for(int i=0;i<nums.length;i++) {
    		if(nums[i]==1) {
    			counter++;
    		}else {
    			counter--;
    		}
    		if(map.containsKey(counter)) {
    			int index=map.get(counter);
    			result=Math.max(result, i-index);
    		}else {
    			map.put(counter, i);
    		}
    	}
    	return result;
    }

	/**
	 * 不合理   int[] nums=new int[] {0,1,1,0,1,1,1,0};
	 * @param nums
	 * @return
	 */
    public int findMaxLength0(int[] nums) {
    	if(nums.length==0 || nums.length==1) {
    		return 0;
    	}
    	int[] sum=new int[nums.length+1];
    	sum[0]=0;
    	for(int i=1;i<=nums.length;i++) {
    		if(nums[i-1]==0) {
    			sum[i]=sum[i-1]-1;
    		}else {
    			sum[i]=sum[i-1]+1;
    		}
    		
    	}
    	int i=0;
    	int j=nums.length;
    	while(j>i) {
    		if((sum[j]-sum[i])==0) {
    			return j-i;
    		}else if(sum[j]-sum[i]<0) { //0多了
    			if(nums[i]==0) {
    				i++;
    			}else if(nums[j-1]==0) {
    				j--;
    			}else {
    				i++;
    			}
    		}else { //1多了
    			if(nums[i]==1) {
    				i++;
    			}else if(nums[j-1]==1) {
    				j--;
    			}else {
    				i++;
    			}	
    		}
    	}
    	return 0;
    }
}

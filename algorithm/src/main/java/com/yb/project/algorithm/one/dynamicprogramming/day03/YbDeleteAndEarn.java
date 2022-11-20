package com.yb.project.algorithm.one.dynamicprogramming.day03;

/**
 * leecode 740. 删除并获得点数
 * @author fxb20
 * 
 * 给你一个整数数组 nums ，你可以对它进行一些操作。 
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。
 * 之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 *  
 * 输入：nums = [3,4,2]
 * 输出：6
 * 解释：
 * 删除 4 获得 4 个点数，因此 3 也被删除。
 * 之后，删除 2 获得 2 个点数。总共获得 6 个点数。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-and-earn
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 *
 */
public class YbDeleteAndEarn {
	public static void main(String[] args) {
		YbDeleteAndEarn yb=new YbDeleteAndEarn();
		int[] nums=new int[] {2,2,3,3,3,4};
		int result=yb.deleteAndEarn(nums);
		System.out.println(result);
	}
	
    public int deleteAndEarn(int[] nums) {
    	int max=Integer.MIN_VALUE;
    	for(int i=0;i<nums.length;i++) {
    		if(nums[i]>max) {
    			max=nums[i];
    		}
    	}
    	int[] arrNums=new int[max+1];
    	if(arrNums.length==1) {
    		return arrNums[0];
    	}
    	for(int i=0;i<nums.length;i++) {
    		arrNums[nums[i]]=arrNums[nums[i]]+nums[i];
    	}
    	int[] dp=new int[arrNums.length];
    	dp[0]=arrNums[0];
    	dp[1]=Math.max(arrNums[0], arrNums[1]);
    	for(int i=2;i<arrNums.length;i++) {
    		dp[i]=Math.max(dp[i-1], dp[i-2]+arrNums[i]);
    	}
    	return dp[arrNums.length-1];
    }
}

package com.yb.project.algorithm.one.greedyalgorithm;

import java.util.PriorityQueue;

/**
 * leetcode 2233. K 次增加后的最大乘积
 * @author fxb20
 * 
 * 给你一个非负整数数组 nums 和一个整数 k 。每次操作，你可以选择 nums 中 任一 元素并将它 增加 1 。
 * 请你返回 至多 k 次操作后，能得到的 nums的 最大乘积 。由于答案可能很大，请你将答案对 109 + 7 取余后返回。
 * 
 * 示例 1：
 * 输入：nums = [0,4], k = 5
 * 输出：20
 * 解释：将第一个数增加 5 次。
 * 得到 nums = [5, 4] ，乘积为 5 * 4 = 20 。
 * 可以证明 20 是能得到的最大乘积，所以我们返回 20 。
 * 存在其他增加 nums 的方法，也能得到最大乘积。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-product-after-k-increments
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class YbMaximumProduct {
	
	public static void main(String[] args) {
		int[] nums=new int[] {24,5,64,53,26,38};
		int k=54;
		YbMaximumProduct yb=new YbMaximumProduct();
		System.out.println(yb.maximumProduct(nums, k));
	}
	
	/**
	 *  12   +31
	 * [36, 38, 36, 53, 64, 37]
	 * @param nums
	 * @param k
	 * @return
	 */
    public int maximumProduct(int[] nums, int k) {
    	PriorityQueue<Integer> queue = new PriorityQueue<>();
    	for(int i=0;i<nums.length;i++) {
    		queue.add(nums[i]);
    	}
    	while(k>0) {
    		int min=queue.poll();
    		queue.add(min+1);
    		k--;
    		System.out.println(k);
    	}   	
    	long result=1;
    	int mod = 1000000007;
    	while(!queue.isEmpty()) {
    		result=result*queue.poll()%mod;
    	}
    	return (int)result;
    }
    //180820950
}

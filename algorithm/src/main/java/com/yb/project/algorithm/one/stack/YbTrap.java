package com.yb.project.algorithm.one.stack;

/**
 * leetcode 42. 接雨水
 * @author fxb20
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，
 * 可以接 6 个单位的雨水（蓝色部分表示雨水）。 
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class YbTrap {
	
	public static void main(String[] args) {
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		YbTrap yb=new YbTrap();
		System.out.println(yb.trap0(height));
	}
	
	
	/**
	 * 单调栈
	 * @param height
	 * @return
	 */
    public int trap(int[] height) {
    	return 0;
    }
	
	/**
	 * 动态规划
	 * @param height
	 * @return
	 */
    public int trap0(int[] height) {
    	int res=0;
    	int m=height.length;
    	int[] leftMax=new int[m];
    	leftMax[0]=height[0];
    	int[] rightMax=new int[m];
    	rightMax[m-1]=height[m-1];
    	for(int i=1;i<m;i++) {
    		leftMax[i]=Math.max(leftMax[i-1], height[i]);
    	}
    	for(int i=m-2;i>=0;i--) {
    		rightMax[i]=Math.max(rightMax[i+1], height[i]);
    	}
    	for(int i=0;i<m;i++) {
    		res+=Math.min(leftMax[i], rightMax[i])-height[i];
    	}
    	
    	return res;
    }
}

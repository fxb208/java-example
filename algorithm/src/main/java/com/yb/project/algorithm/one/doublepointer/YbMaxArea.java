package com.yb.project.algorithm.one.doublepointer;

/**
 * leetcode 11 . 盛最多水的容器
 * @author fxb20
 * 
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49 
 *
 * 输入：height = [1,1]
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class YbMaxArea {
	public static void main(String[] args) {
		int[] height=new int[] {1,8,6,2,5,4,8,3,7};
		YbMaxArea yb=new YbMaxArea();
		System.out.println(yb.maxArea(height));
	}
    public int maxArea(int[] height) {
    	int max=0;
    	int i=0;
    	int j=height.length-1;
    	while(i<j) {
    		int l=Math.min(height[i], height[j]);
    		max=Math.max(l*(j-i), max);
    		if(height[i]>height[j]) {
    			j--;
    		}else {
    			i++;
    		}
    	}
    	return max;
    }
}

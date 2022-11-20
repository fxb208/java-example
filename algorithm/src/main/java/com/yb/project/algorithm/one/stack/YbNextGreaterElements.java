package com.yb.project.algorithm.one.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * leetcode 503. 下一个更大元素 II
 * @author fxb20
 * 给定一个循环数组nums（nums[nums.length - 1]的下一个元素是nums[0]），
 * 返回nums中每个元素的 下一个更大元素 。
 * 数字 x的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。
 * 如果不存在，则输出 -1。
 * 
 * 示例 1:
 * 输入: nums = [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数； 
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/next-greater-element-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class YbNextGreaterElements {
	
	public static void main(String[] args) {
		YbNextGreaterElements yb=new YbNextGreaterElements();
		int[] nums=new int[] {1,2,3,4,3};
		yb.nextGreaterElements(nums);
	}
	
    public int[] nextGreaterElements(int[] nums) {
    	int[] res=new int[nums.length];
		Arrays.fill(res,-1);
    	Deque<Integer> deque=new ArrayDeque<Integer>();
    	for(int i=0;i<nums.length*2-1;i++) {
    		Integer m=deque.peek();
    		while(m !=null && nums[i%nums.length]>nums[m]) {
    			deque.pop();
    			res[m%nums.length]=nums[i%nums.length];
    			m=deque.peek();
    		}
    		deque.push(i%nums.length);
    	}
    	return res;
    }
    
    public int[] nextGreaterElements0(int[] nums) {
    	int[] res=new int[nums.length];
		Arrays.fill(res,-1);
    	Deque<int[]> deque=new ArrayDeque<int[]>();
    	for(int i=0;i<nums.length*2;i++) {
    		int[] m=deque.peek();
    		while(m !=null && nums[i%nums.length]>m[0]) {
    			deque.pop();
    			res[m[1]%nums.length]=nums[i%nums.length];
    			m=deque.peek();
    		}
    		deque.push(new int[] {nums[i%nums.length],i});
    	}
    	return res;
    }
}

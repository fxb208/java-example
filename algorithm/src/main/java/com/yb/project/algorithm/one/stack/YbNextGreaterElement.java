package com.yb.project.algorithm.one.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 496. 下一个更大元素 I
 * @author fxb20
 * nums1中数字x的 下一个更大元素 是指x在nums2 中对应位置 右侧 的 第一个 比x大的元素。
 * 给你两个 没有重复元素 的数组nums1 和nums2 ，下标从 0 开始计数，其中nums1是nums2的子集。
 * 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，
 * 并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
 * 返回一个长度为nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
 * 
 * 示例 1：
 * 输入：nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出：[-1,3,-1]
 * 解释：nums1 中每个值的下一个更大元素如下所述：
 * - 4 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
 * - 1 ，用加粗斜体标识，nums2 = [1,3,4,2]。下一个更大元素是 3 。
 * - 2 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/next-greater-element-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class YbNextGreaterElement {
	public static void main(String[] args) {
		YbNextGreaterElement yb=new YbNextGreaterElement();
		int[] nums1 = new int[] {4,1,2};
	    int[] nums2 = new int[] {1,3,4,2};
		yb.nextGreaterElement(nums1, nums2);
	}
	
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    	int[] res=new int[nums1.length];
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	Deque<Integer> stack=new ArrayDeque<Integer>();
    	for(int i=nums2.length-1;i>=0;i--) {
    		Integer m = stack.peek();
    		while(m !=null && nums2[i]>m) {
    			stack.pop();
    			m = stack.peek();
    		}
    		map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
    		stack.push(nums2[i]);
    	}
    	for(int i=0;i<nums1.length;i++) {
    		res[i]=map.get(nums1[i]);
    	}
    	return res;
    }
	
    /**
     * 暴力算法
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement0(int[] nums1, int[] nums2) {
    	int[] res=new int[nums1.length];
    	for(int i=0;i<nums1.length;i++) {
    		res[i]=-1;
    		int index=nums2.length;
    		for(int j=0;j<nums2.length;j++) {
        		if(nums1[i]==nums2[j]) {
        			index=j;
        		}
        		if(j>index && nums2[j]>nums1[i]) {
        			res[i]=nums2[j];
        			break;
        		}
        	}
    	}
    	return res;
    }
}

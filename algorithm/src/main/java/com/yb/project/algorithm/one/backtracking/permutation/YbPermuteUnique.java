package com.yb.project.algorithm.one.backtracking.permutation;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 47 全排列 II
 * @author fxb20
 *
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class YbPermuteUnique {
	public static void main(String[] args) {
		YbPermuteUnique yb=new YbPermuteUnique();
		System.out.println(yb.permuteUnique(new int[] {1,1,2}));
	}
	
    public List<List<Integer>> permuteUnique(int[] nums) {
    	List<List<Integer>> res=new LinkedList<List<Integer>>();
    	Deque<Integer> temp=new LinkedList<Integer>();
    	boolean[] use=new boolean[nums.length];
    	Arrays.sort(nums);
    	dfs(nums,res,temp,use);
    	return res;
    }
    
    public void dfs(int[] nums,List<List<Integer>> res,Deque<Integer> temp,boolean[] use) {
    	if(temp.size()==nums.length) {
    		res.add(new LinkedList<Integer>(temp));
    		return;
    	}
    	for(int i=0;i<nums.length;i++) {
			if(use[i] || i>0 && nums[i]==nums[i-1] && !use[i-1]){
				continue;
			}
			temp.addLast(nums[i]);
			use[i]=true;
			dfs(nums,res,temp,use);
			temp.removeLast();
			use[i]=false;
//    		if(!use[i] && (i-1==-1 || nums[i-1] !=nums[i] || !use[i-1])) {
//
//    		}
    	}
    }
}

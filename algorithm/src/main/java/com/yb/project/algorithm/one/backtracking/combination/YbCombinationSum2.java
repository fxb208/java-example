package com.yb.project.algorithm.one.backtracking.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 40. 组合总和 II
 * @author fxb20
 * 给定一个候选人编号的集合candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * candidates中的每个数字在每个组合中只能使用一次。
 * 注意：解集不能包含重复的组合。
 * 
 * 输入: candidates =[10,1,2,7,6,1,5], target =8,
 * 输出:
 * [
 *  [1,1,6],
 *  [1,2,5],
 *  [1,7],
 *  [2,6]
 * ]
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class YbCombinationSum2 {
	
	public static void main(String[] args) {
		YbCombinationSum2 yb=new YbCombinationSum2();
		int[] candidates =new int[] {10,1,2,7,6,1,5};
		System.out.println(yb.combinationSum2(candidates, 8));
	}
	
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	List<List<Integer>> resut=new LinkedList<List<Integer>>();
    	Deque<Integer> path=new LinkedList<Integer>();
    	Arrays.sort(candidates);
    	dfs(candidates,target,resut,path,0);
    	return resut;
    }
    
    /**
     * 1, 1, 2, 5, 6, 7, 10
     * @param candidates
     * @param target
     * @param resut
     * @param path
     * @param idx
     */
    public void dfs(int[] candidates,int target,List<List<Integer>> resut,Deque<Integer> path,int idx) {
		if(target==0) {
			resut.add(new ArrayList<Integer>(path));
			return;
		}
		for(int i=idx;i<candidates.length;i++) {
			if(target>=candidates[i] && (i==idx || candidates[i] !=candidates[i-1])) {
				path.addLast(candidates[i]);
				//选中
				dfs(candidates,target-candidates[i],resut,path,i+1);
				//回溯
				path.removeLast();	
			}
		
		}
    }
}

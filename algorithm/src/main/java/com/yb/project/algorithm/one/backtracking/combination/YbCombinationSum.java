package com.yb.project.algorithm.one.backtracking.combination;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 39. 组合总和
 * @author fxb20
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target，
 * 找出candidates中可以使数字和为目标数target 的 所有不同组合 ，并以列表形式返回。
 * 你可以按 任意顺序 返回这些组合。candidates 中的 同一个 数字可以 无限制重复被选取 。
 * 如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为target 的不同组合数少于 150 个。
 * 
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class YbCombinationSum {
	
	public static void main(String[] args) {
		YbCombinationSum yb=new YbCombinationSum();
		System.out.println(yb.combinationSum(new int[] {2,3,6,7}, 7));
	}
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> resut=new ArrayList<List<Integer>>();
		LinkedList<Integer> path=new LinkedList<Integer>();
		dfs(candidates,target,resut,path,0);
		return resut;
	}
	
	public void dfs(int[] candidates,int target,List<List<Integer>> resut,LinkedList<Integer> path,int idx) {
		if(target==0) {
			resut.add(new ArrayList<Integer>(path));
			return;
		}
		for(int i=0;i<candidates.length;i++) {
			if(target>=candidates[i] && i>=idx) {
				path.addLast(candidates[i]);
				//选中
				dfs(candidates,target-candidates[i],resut,path,i);
				//回溯
				path.removeLast();	
			}
		
		}
	}
	
	public void dfs0(int[] candidates,int target,List<List<Integer>> resut,LinkedList<Integer> path,int idx) {
		if(idx==candidates.length) { //下标越界，直接返回
			return;
		}
		if(target==0) {
			resut.add(new ArrayList<Integer>(path));
			return;
		}
		
		//直接跳过
		dfs(candidates,target,resut,path,idx+1);
		if(target>=candidates[idx]) {
			path.add(candidates[idx]);
			//选中
			dfs(candidates,target-candidates[idx],resut,path,idx);
			//回溯
			path.remove(path.size()-1);
		}
		
	}
	
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<List<Integer>> ans = new ArrayList<List<Integer>>();
//        List<Integer> combine = new ArrayList<Integer>();
//        dfs(candidates, target, ans, combine, 0);
//        return ans;
//    }
//
//    public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
//        if (idx == candidates.length) {
//            return;
//        }
//        if (target == 0) {
//            ans.add(new ArrayList<Integer>(combine));
//            return;
//        }
//        // 直接跳过
//        dfs(candidates, target, ans, combine, idx + 1);
//        // 选择当前数
//        if (target - candidates[idx] >= 0) {
//            combine.add(candidates[idx]);
//            dfs(candidates, target - candidates[idx], ans, combine, idx);
//            combine.remove(combine.size() - 1);
//        }
//    }


}

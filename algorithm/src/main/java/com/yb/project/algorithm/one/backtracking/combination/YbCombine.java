package com.yb.project.algorithm.one.backtracking.combination;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 77. 组合
 * @author fxb20
 * 
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 * 
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class YbCombine {
	public static void main(String[] args) {
		YbCombine yb=new YbCombine();
		System.out.println(yb.combine(4, 2));
	}
	
    public List<List<Integer>> combine(int n, int k) {
    	List<List<Integer>> res=new ArrayList<List<Integer>>();
    	List<Integer> path=new ArrayList<Integer>();
    	backtrack(n,k,res,path,1);
    	return res;
    }
    
    public void backtrack(int n, int k,List<List<Integer>> res,List<Integer> path,int idx) {
    	if(path.size()==k) {
    		res.add(new ArrayList<Integer>(path));
    		return;
    	}
    	for(int i=idx;i<=n;i++) {
    		path.add(i);
    		backtrack(n, k,res,path,i+1);
    		path.remove(path.size()-1);
    	}
    }
}

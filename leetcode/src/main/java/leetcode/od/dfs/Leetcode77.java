package leetcode.od.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 */
public class Leetcode77 {
    public static void main(String[] args) {
        Leetcode77 yb = new Leetcode77();
        int n=4;
        int k=2;
        List<List<Integer>> res = yb.combine(n,k);
        for(List<Integer> lst : res){
            System.out.println("["+lst.get(0)+" "+lst.get(1)+"]");
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> lst = new LinkedList<>();
        dfs(n,k,1,res,lst);
        return res;
    }

    public void dfs(int n, int k, int idx, List<List<Integer>> res, LinkedList<Integer> lst){
        if(lst.size()==k){
            res.add(new ArrayList<>(lst));
            return;
        }
        for(int i=idx;i<=n;i++){
            lst.add(i);
            dfs(n,k,i+1,res,lst);
            lst.pollLast();
        }
    }
}

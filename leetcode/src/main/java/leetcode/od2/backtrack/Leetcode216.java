package leetcode.od2.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. 组合总和 III
 *
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 */
public class Leetcode216 {

    public static void main(String[] args) {
        Leetcode216 yb = new Leetcode216();
        yb.combinationSum3(3,7);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backTrack(res,path,k,n,1,new boolean[9]);
        return res;
    }

    public void backTrack(List<List<Integer>> res,List<Integer> path,int k,int n,int idx,boolean[] used){
        if(path.size()==k){
            if(n==0){
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for(int i=idx;i<=9;i++){
            if(!used[i]){
                used[i]=true;
                path.add(i);
                backTrack(res,path,k,n-i,idx+1,used);
                path.remove(path.size()-1);
                used[i]=false;
            }
        }
    }

    public List<List<Integer>> combinationSum3_(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backTrack(res,path,k,n,1);
        return res;
    }

    public void backTrack(List<List<Integer>> res,List<Integer> path,int k,int n,int idx){
        if(idx==3){
            System.out.println(3);
        }
        if(path.size()==k){
            if(n==0){
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for(int i=idx;i<=9;i++){
            path.add(i);
            backTrack(res,path,k,n-i,i+1);
            path.remove(path.size()-1);
        }
    }
}

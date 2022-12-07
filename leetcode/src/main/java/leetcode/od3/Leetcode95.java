package leetcode.od3;

import java.util.ArrayList;
import java.util.List;

/**
 * 95. 不同的二叉搜索树 II
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。
 * 可以按 任意顺序 返回答案
 */
public class Leetcode95 {

    public static void main(String[] args) {
        Leetcode95 yb = new Leetcode95();
        List<TreeNode> lst = yb.generateTrees(1);
        System.out.println(lst.size());
    }

    public List<TreeNode> generateTrees(int n) {
        if(n==0){
            return new ArrayList<>();
        }
        return generateTrees(1,n);
    }

    public List<TreeNode> generateTrees(int begin,int end) {
        List<TreeNode> res = new ArrayList<>();
        if(begin>end){
            res.add(null);
            return res;
        }
        for(int i=begin;i<=end;i++){
            List<TreeNode> lefts = generateTrees(begin,i-1);
            List<TreeNode> rights = generateTrees(i+1,end);
            for(TreeNode left :lefts){
                for(TreeNode right:rights){
                    TreeNode node = new TreeNode(i);
                    node.left=left;
                    node.right=right;
                    res.add(node);
                }
            }
        }
        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

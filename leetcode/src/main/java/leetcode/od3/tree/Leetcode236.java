package leetcode.od3.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class Leetcode236 {
    public static void main(String[] args) {
        Leetcode236 yb = new Leetcode236();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        yb.lowestCommonAncestor(root,root,root.left);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> res = new ArrayList<>();
        postOrder(root,res,p,q);
        return res.get(0);
    }

    public boolean postOrder(TreeNode node, List<TreeNode> res,TreeNode p, TreeNode q){
        boolean matcher = false;
        if(node !=null){
            boolean left = postOrder(node.left,res,p,q);
            boolean right = postOrder(node.right,res,p,q);
            if(node.val == p.val || node.val == q.val){
                matcher = true;
            }
            if((left || right) && matcher && res.isEmpty()){
                res.add(node);
            }
            if(left && right && res.isEmpty()){
                res.add(node);
            }
            return left || right || matcher;
        }
        return false;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

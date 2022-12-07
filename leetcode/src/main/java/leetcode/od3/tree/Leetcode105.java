package leetcode.od3.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * <p>
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历，
 * inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 */
public class Leetcode105 {
    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
//        int[] preorder =new int[]{1,2,3};
//        int[] inorder =new int[]{3,2,1};
        Leetcode105 yb = new Leetcode105();
        yb.buildTree(preorder,inorder);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==1){
            return new TreeNode(preorder[0]);
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        int len = preorder.length;
        TreeNode node = buildTree(preorder,map,0,len-1,0);
        return node;
    }

    public TreeNode buildTree(int[] preorder,Map<Integer,Integer> map,
                              int preorder_left,int preorder_right,int inorder_left){
        if(preorder_left>preorder_right){
            return null;
        }
        TreeNode node = new TreeNode(preorder[preorder_left]);
        int inorder_root=map.get(preorder[preorder_left]);
        int left_len = inorder_root-inorder_left;
        node.left=buildTree(preorder,map,preorder_left+1,
                preorder_left+left_len,inorder_root-left_len);
        node.right=buildTree(preorder,map,preorder_left+left_len+1, preorder_right,inorder_root+1);
        return node;
    }


    public static class TreeNode {
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

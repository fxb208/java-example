package leetcode.od3.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 *
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历，
 * postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 *
 * inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 */
public class Leetcode106 {
    public static void main(String[] args) {
        int[] postorder = new int[]{9,15,7,20,3};
        int[] inorder = new int[]{9,3,15,20,7};
//        int[] preorder =new int[]{1,2,3};
//        int[] inorder =new int[]{3,2,1};
        Leetcode106 yb = new Leetcode106();
        yb.buildTree(inorder,postorder);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        TreeNode node = buildTree(postorder,map,0,0,postorder.length-1);
        return node;
    }

    public TreeNode buildTree(int[] postorder,Map<Integer,Integer> map,
                              int inorder_left,int postorder_left,int postorder_right){
        if(postorder_left>postorder_right){
            return null;
        }
        int val = postorder[postorder_right];
        int len = map.get(val)-inorder_left;
        TreeNode node = new TreeNode(val);
        node.left = buildTree(postorder,map,inorder_left,postorder_left,postorder_left+len-1);
        node.right = buildTree(postorder,map,map.get(val)+1,postorder_left+len,postorder_right-1);
        return node;
    }



    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
   }
}

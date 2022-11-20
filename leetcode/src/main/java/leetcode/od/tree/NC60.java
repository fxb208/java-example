package leetcode.od.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * NC60 判断一棵二叉树是否为搜索二叉树和完全二叉树
 * 描述
 * 给定一棵二叉树，已知其中的节点没有重复值，请判断该二叉树是否为搜索二叉树和完全二叉树。
 * 输出描述：分别输出是否为搜索二叉树、完全二叉树。
 *
 * 要求：空间复杂度 O(n)O(n)，时间复杂度 O(n)O(n)
 */
public class NC60 {
    /**
     *
     * @param root TreeNode类 the root
     * @return bool布尔型一维数组
     */
    public boolean[] judgeIt (TreeNode root) {
        // write code here
        boolean[] res = new boolean[2];
        res[0]=isSearchTree(root);
        res[1]=isCTree(root);
        return res;
    }

    public boolean isSearchTree(TreeNode root){
        List<Integer> lst = new ArrayList<>();
        trave(root,lst);
        for(int i=1;i<lst.size();i++){
            if(lst.get(i)<lst.get(i-1)){
                return false;
            }
        }
        return true;
    }

    public void trave(TreeNode root,List<Integer> lst){
        if(root !=null){
            trave(root.left,lst);
            lst.add(root.val);
            trave(root.right,lst);
        }
    }

    public boolean isCTree(TreeNode root){
        if(root ==null){
            return true;
        }
        LinkedList<TreeNode> lst = new LinkedList<>();
        lst.add(root);
        boolean flag=false;
        while(lst.size()>0){
            int len=lst.size();
            for(int i=0;i<len;i++){
                TreeNode node = lst.pollLast();
                if(flag && (node.left !=null || node.right !=null)){
                    return false;
                }
                if(node.left == null && node.right !=null){
                    return false;
                }
                if(node.left !=null){
                    lst.addFirst(node.left);
                }
                if(node.right !=null){
                    lst.addFirst(node.right);
                }
                if(node.left==null || node.right==null){
                    flag=true;
                }
            }
        }
        return true;
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }
}

package leetcode.fabu.day2;

import java.util.ArrayList;
import java.util.List;

/**
 * 230. 二叉搜索树中第K小的元素
 * https://leetcode.cn/problems/kth-smallest-element-in-a-bst/
 */
public class YbKthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        int result = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        lst(arrayList,root);
        return arrayList.get(k-1);
    }

    public void lst(List<Integer> lst,TreeNode root){
        if(root!=null){
            lst(lst,root.left);
            lst.add(root.val);
            lst(lst,root.right);
        }
    }

    class TreeNode {
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



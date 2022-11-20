package leetcode.od.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 *
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，
 * 第三行再按照从左到右的顺序打印，其他行以此类推
 */
public class JZ32III {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        if(root !=null){
            list.add(root);
        }
        int level = 1;
        while(list.size()>0){
            List<Integer> data = new ArrayList<>();
            int size = list.size();
            for(int i=0;i<size;i++){
                if(level % 2 ==1){
                    TreeNode node = list.pollLast();
                    data.add(node.val);
                    if(node.left != null){
                        list.add(0,node.left);
                    }
                    if(node.right != null){
                        list.add(0,node.right);
                    }
                }else{
                    TreeNode node = list.pollFirst();
                    data.add(node.val);
                    if(node.right != null){
                        list.add(node.right);
                    }
                    if(node.left != null){
                        list.add(node.left);
                    }
                }
            }
            level++;
            res.add(data);
        }
        return res;
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
   }
}

package leetcode.od2;

/**
 * 1373. 二叉搜索子树的最大键值和
 *
 * 给你一棵以 root 为根的 二叉树 ，请你返回 任意 二叉搜索子树的最大键值和。
 * 二叉搜索树的定义如下：
 * 任意节点的左子树中的键值都 小于 此节点的键值。
 * 任意节点的右子树中的键值都 大于 此节点的键值。
 * 任意节点的左子树和右子树都是二叉搜索树。
 */
public class Leetcode1373 {

    public static void main(String[] args) {
        Leetcode1373 yb = new Leetcode1373();
//        TreeNode root = new TreeNode(4);
//        root.left = new TreeNode(3);
//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(2);
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(-5);
        root.right.right = new TreeNode(20);
        System.out.println(yb.maxSumBST(root));
    }


    Integer res = 0;

    public int maxSumBST(TreeNode root) {
        int[] res = new int[]{0};
        doMaxSumBST(root,res);
        return res[0];
    }

    public void doMaxSumBST(TreeNode root,int[] res){
        if(isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE)){
            sumBST(root,res);
            return;
        };
        doMaxSumBST(root.left,res);
        doMaxSumBST(root.right,res);
    }

    public boolean isBST(TreeNode node,int lower,int hight){
        if(node == null){
            return true;
        }
        if(node.val<=lower || node.val>=hight){
            return false;
        }
        return isBST(node.left,lower,node.val) && isBST(node.right, node.val, hight);
    }

    public int sumBST(TreeNode node,int[] res){
        if(node == null){
            return 0;
        }
        int left = sumBST(node.left,res);
        int right = sumBST(node.right,res);
        res[0] = Math.max(Math.max(left,right),res[0]);
        res[0] = Math.max(node.val+left+right,res[0]);
        return node.val+left+right;
    }


    public int[] maxBst_long(TreeNode node,int lower,int hight){
        if(node == null){
            res = Math.max(res,0);
            return new int[]{1, 0};
        }
        if(node.val<=lower || node.val>=hight){
            maxBst_long(node,Integer.MIN_VALUE,Integer.MAX_VALUE);
            return new int[]{0,0};
        }
        int[] left = maxBst_long(node.left,lower,node.val);
        int[] right = maxBst_long(node.right, node.val, hight);
        if(left[0]==1 && right[0]==1){
            res = Math.max(res,left[1]+right[1]+node.val);
            return new int[]{1,left[1]+right[1]+node.val};
        }else{
            maxBst_long(node.left,Integer.MIN_VALUE,Integer.MAX_VALUE);
            maxBst_long(node.right,Integer.MIN_VALUE,Integer.MAX_VALUE);
            return new int[]{0,0};
        }
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

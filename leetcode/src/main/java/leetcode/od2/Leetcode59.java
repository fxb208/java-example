package leetcode.od2;

/**
 * 59. 螺旋矩阵 II
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 */
public class Leetcode59 {
    public static void main(String[] args) {
        //
        Leetcode59 yb = new Leetcode59();
        yb.generateMatrix(1);
    }

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int left=0;
        int right=n-1;
        int top = 0;
        int buttom = n-1;
        int id = 1;
        while(left<=right && top<=buttom){
            for(int i = left;i<=right;i++){
                res[top][i]=id;
                id++;
            }
            for(int j = top+1;j<=buttom;j++){
                res[j][right]=id;
                id++;
            }
            if(top<buttom){
                for(int i = right-1;i>=left;i--){
                    res[buttom][i]=id;
                    id++;
                }
            }
            if(left<right){
                for(int j = buttom-1;j>top;j--){
                    res[j][left]=id;
                    id++;
                }
            }
            left++;
            right--;
            top++;
            buttom--;
        }
        return res;
    }
}

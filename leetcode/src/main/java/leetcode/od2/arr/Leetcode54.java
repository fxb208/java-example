package leetcode.od2.arr;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 */
public class Leetcode54 {
    public static void main(String[] args) {
        //
        Leetcode54 yb = new Leetcode54();
        int[][] matrix = new int[][]{{1,2,3}};
        yb.spiralOrder(matrix);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        // ij  00 01 02 12 22 21 20 10 11 12
        //
        List<Integer> res = new ArrayList<>();
        int top = 0;
        int buttom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        while(top<=buttom && left<=right){
            for(int i=left;i<=right;i++){
                res.add(matrix[top][i]);
            }
            for(int j=top+1;j<=buttom;j++){
                res.add(matrix[j][right]);
            }
            if(top<buttom){
                for(int i=right-1;i>=left;i--){
                    res.add(matrix[buttom][i]);
                }
            }
            if(left<right){
                for(int j=buttom-1;j>top;j--){
                    res.add(matrix[j][left]);
                }
            }
            top++;
            buttom--;
            left++;
            right--;
        }
        return res;
    }
}

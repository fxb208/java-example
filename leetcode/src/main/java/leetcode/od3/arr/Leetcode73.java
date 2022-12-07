package leetcode.od3.arr;

import java.util.HashSet;
import java.util.Set;

/**
 * 73. 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 */
public class Leetcode73 {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        for(int i=0;i< matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for(int num : rows){
            for(int j=0;j<matrix[0].length;j++){
                matrix[num][j]=0;
            }
        }

        for(int num : cols){
            for(int j=0;j<matrix.length;j++){
                matrix[j][num]=0;
            }
        }
    }
}

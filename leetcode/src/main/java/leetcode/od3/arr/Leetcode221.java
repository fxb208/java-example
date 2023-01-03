package leetcode.od3.arr;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode221
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 */
public class Leetcode221 {
    public static void main(String[] args) {
        //[["0","1"],["1","0"]]
        //char [][] matrix = new char[][]{{'0','1'},{'1','0'}};
        // [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
        //char [][] matrix = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        /**
         * [["1","1","1","1","0"],
         * ["1","1","1","1","0"],
         * ["1","1","1","1","1"],
         * ["1","1","1","1","1"],
         * ["0","0","1","1","1"]]
         */
        char [][] matrix = new char[][]{
                {'1','1','1','1','0'},
                {'1','1','1','1','0'},
                {'1','1','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};
        Leetcode221 yb = new Leetcode221();
        System.out.println(yb.maximalSquare(matrix));
        System.out.println(Math.pow(4,2));
    }

    public int maximalSquare(char[][] matrix) {
        int res = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='1'){
                    res = Math.max(res,square(matrix,i,j));
                }
            }
        }
        return res;
    }

    public int square(char[][] matrix,int i,int j){
        int res = 1;
        List<int[]> rows = new ArrayList<>();
        rows.add(new int[]{i,j});
        List<int[]> cols = new ArrayList<>();
        cols.add(new int[]{i,j});
        int[] tail = new int[]{i,j};
        for(int k=1;i+k<matrix.length && j+k<matrix[0].length;k++){
            for(int[] arr: rows){
                if(matrix[arr[0]+1][arr[1]]=='1'){
                    arr[0]=i+1;
                }else{
                    return res;
                }
            }
            for(int[] arr: cols){
                if(matrix[arr[0]][arr[1]+1]=='1'){
                    arr[1]=j+1;
                }else{
                    return res;
                }
            }
            if(matrix[tail[0]+1][tail[1]+1]=='1'
                    && matrix[tail[0]+1][tail[1]]=='1'
                    && matrix[tail[0]][tail[1]+1]=='1'){
                tail[0]=tail[0]+1;
                tail[1]=tail[1]+1;
                if(k>1){
                    rows.add(new int[]{tail[0],j});
                    cols.add(new int[]{i,tail[1]});
                }
            }else{
                return res;
            }
            res= (int) Math.pow(k+1,2);
        }
        return res;
    }
}

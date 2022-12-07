package leetcode.od3.binarysearch;

/**
 * 240. 搜索二维矩阵 II
 *
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 */
public class Leetcode240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bottom= matrix.length-1;
        while(top<=bottom){
            if(matcher(matrix[top],target)){
                return true;
            }
            top++;
        }
        return false;
    }

    public boolean matcher(int[] row,int target){
        int left = 0;
        int right = row.length-1;
        while(left<=right){
            int middle = left + (right-left)/2;
            if(row[middle]==target){
                return true;
            }else if(row[middle]<target){
                left = middle+1;
            }else{
                right = middle-1;
            }
        }
        return false;
    }
}

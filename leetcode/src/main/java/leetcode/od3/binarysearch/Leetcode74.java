package leetcode.od3.binarysearch;

/**
 * 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 */
public class Leetcode74 {
    public static void main(String[] args) {
        Leetcode74 yb = new Leetcode74();
        int[][] matrix = new int[][]{{1}};
        yb.searchMatrix(matrix,2);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length-1;
        int x = -1;
        while(left<=right){
            int middle = left+(right-left)/2;
            if(target<=matrix[middle][matrix[0].length-1] && target>=matrix[middle][0]){
                x=middle;
                break;
            }else if(target<matrix[middle][0]){
                right = middle-1;
            }else{
                left = middle+1;
            }
        }
        if(x==-1){
            return false;
        }
        left = 0;
        right = matrix[0].length-1;
        while(left<=right){
            int middle = left+(right-left)/2;
            if(target==matrix[x][middle]){
                return true;
            }else if(target<matrix[x][middle]){
                right = middle-1;
            }else{
                left = middle+1;
            }
        }
        return false;
    }
}

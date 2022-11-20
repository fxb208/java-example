package leetcode.od.sort;

/**
 * JZ4 二维数组中的查找
 */
public class JZ4 {
    public static void main(String[] args) {
        //int [][] array = new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        //int [][] array = new int[][]{{1,1}};
        int [][] array = new int[][]{{}};
        System.out.println(Find(2,array));
    }

    public static boolean Find(int target, int [][] array) {
        int a=array.length;
        if(a==0){
            return false;
        }
        int b=array[0].length;
        if(b==0){
            return false;
        }
        for(int i=0;i<a;i++){
            if(array[i][0]>target){
                a=i;
            }
            for(int j=0;j<b;j++){
                if(array[i][j]==target){
                    return true;
                }
                if(array[i][j]>target){
                    b=j;
                }

            }
        }
        return false;
    }
}

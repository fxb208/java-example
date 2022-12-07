package leetcode.od3.arr;

import java.util.Arrays;
/**
 * 56. 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 */
public class Leetcode56 {
    public static void main(String[] args) {
        // [[1,3],[2,6],[8,10],[15,18]]
        Leetcode56 yb = new Leetcode56();
        yb.merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(o1, o2) -> {
            return o1[0]-o2[0];
        });
        int[][] res = new int[intervals.length][2];
        int begin=intervals[0][0]; int end=intervals[0][1]; int k=0;
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=end){
                end = Math.max(intervals[i][1],end);
            }else{
                res[k]=new int[]{begin,end};
                k++;
                begin = intervals[i][0];
                end = intervals[i][1];
            }
        }
        res[k]=new int[]{begin,end};
        k++;
        int[][] copy = new int[k][2];
        System.arraycopy(res,0,copy,0,k);
        return copy;
    }
}

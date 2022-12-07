package leetcode.od3.arr;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode57
 *
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 */
public class Leetcode57 {
    public static void main(String[] args) {
        Leetcode57 yb = new Leetcode57();
        yb.insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}},new int[]{4,8});
        //yb.insert(new int[][]{{1,3},{6,9}},new int[]{2,5});
    }

    /**
     * https://leetcode.cn/problems/insert-interval/solutions/472435/shou-hua-tu-jie-57-cha-ru-qu-jian-fen-cheng-3ge-ji/?orderBy=most_votes
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int len = intervals.length;
        int begin = 0;
        while(begin<len && intervals[begin][1]<newInterval[0]){
            res.add(intervals[begin]);
            begin++;
        }
        while(begin<len && intervals[begin][0]<=newInterval[1]){
            newInterval[0] = Math.min(newInterval[0],intervals[begin][0]);
            newInterval[1] = Math.max(newInterval[1],intervals[begin][1]);
            begin++;
        }
        res.add(newInterval);
        while(begin<len && intervals[begin][0]>newInterval[1]){
            res.add(intervals[begin]);
            begin++;
        }

        return res.toArray(new int[0][]);
    }
}

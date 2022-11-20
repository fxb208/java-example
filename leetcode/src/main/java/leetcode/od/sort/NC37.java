package leetcode.od.sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * NC37.合并区间
 */
public class NC37 {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals,(o1, o2) -> {return o1.start-o2.start;});
        ArrayList<Interval> result = new ArrayList<>();
        for(int i=0;i<intervals.size();){
            int j=1;
            int end = Math.max(result.get(i).end,0);
            while(end>intervals.get(i+j).start){
                j++;
                end = Math.max(end,intervals.get(i+j).end);
            }
            result.add(new Interval(result.get(i).start,end));
            i+=j;
        }
        return result;

    }

    public class Interval {
        int start;
        int end;
        Interval() {
            start = 0;
            end = 0;
        }
        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}

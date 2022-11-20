package leetcode.fabu.day3;

import java.util.Arrays;

/**
 * 274. H 指数
 * https://leetcode.cn/problems/h-index/
 */
public class YbHIndex {
    public static void main(String[] args) {
        int[] citations = new int[]{0,1,3,5,6};
        YbHIndex yb = new YbHIndex();
        System.out.println("result: "+yb.hIndex(citations));
    }

    public int hIndex(int[] citations) {
        // 0,1,3,5,6
        Arrays.sort(citations);
        int res = 0;
        int i = citations.length-1;
        while(i>=0 && citations[i]>res){
            i--;
            res ++;
        }
        return res;
    }
}

package leetcode.od2.dindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 1423. 可获得的最大点数
 * 几张卡牌 排成一行，每张卡牌都有一个对应的点数。点数由整数数组 cardPoints 给出。
 * 每次行动，你可以从行的开头或者末尾拿一张卡牌，最终你必须正好拿 k 张卡牌。
 * 你的点数就是你拿到手中的所有卡牌的点数之和。
 * 给你一个整数数组 cardPoints 和整数 k，请你返回可以获得的最大点数。
 */
public class Leetcode1423 {

    public static void main(String[] args) {
        Leetcode1423 yb =new Leetcode1423();
        System.out.println(yb.maxScore(new int[]{1,2,3,4,5,6,1},3));
    }

    public int maxScore(int[] cardPoints, int k){
        int res = 0;
        if(k>=cardPoints.length){
            for(int i=0;i<cardPoints.length;i++){
                res+=cardPoints[i];
            }
        }else{
            int left = k-1;
            int right = 0;
            int temp = 0;
            for(int i=0;i<=left;i++){
                temp+=cardPoints[i];
            }
            res=Math.max(res,temp);
            while(left>=0){
                temp-=cardPoints[left];
                left--;
                right++;
                temp+=cardPoints[cardPoints.length-right];
                res=Math.max(res,temp);
            }

        }
        return res;
    }


//    public int maxScore_bug(int[] cardPoints, int k) {
//        int res = 0;
//        int left = 0;
//        int right = cardPoints.length-1;
//        Queue<Integer> lst = new LinkedList<>();
//        while(left<=right && k>0){
//            if(cardPoints[right]>cardPoints[left]){
//                res += cardPoints[right];
//                right--;
//            }else if(cardPoints[right]<cardPoints[left]){
//                res += cardPoints[left];
//                left++;
//            }else{
//                int k1=left+1;
//                int k2=right-1;
//                while(k1<=k2 && cardPoints[k1] == cardPoints[k2]){
//                    k1++;
//                    k2--;
//                }
//                if(cardPoints[k1]>cardPoints[k2]){
//                    res += cardPoints[left];
//                    left++;
//                }else{
//                    res += cardPoints[right];
//                    right--;
//                }
//            }
//            k--;
//        }
//        while(k>0 && !lst.isEmpty()){
//            res += lst.poll();
//        }
//        return res;
//    }
}

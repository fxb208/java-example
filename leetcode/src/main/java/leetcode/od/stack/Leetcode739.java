package leetcode.od.stack;

import java.util.LinkedList;

/**
 * 剑指 Offer II 038. 每日温度
 */
public class Leetcode739{
    public static void main(String[] args) {
        Leetcode739 yb = new Leetcode739();
        int[] result = yb.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
        System.out.println(result);
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        LinkedList<int[]> lst = new LinkedList<>();
        for(int i=0;i<temperatures.length;i++){
            while(lst.peekLast() !=null){
                int[] last = lst.peekLast();
                if(last[0]<temperatures[i]){
                    lst.pollLast();
                    res[last[1]]=i-last[1];
                }else{
                    break;
                }
            }
            lst.addLast(new int[]{temperatures[i],i});
        }
        for(int[] arr: lst){
            res[arr[1]]=0;
        }
        return res;
    }
}

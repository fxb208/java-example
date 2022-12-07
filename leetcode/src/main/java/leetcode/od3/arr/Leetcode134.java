package leetcode.od3.arr;

/**
 * 134. 加油站
 * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。
 * 你从其中的一个加油站出发，开始时油箱为空。
 * 给定两个整数数组 gas 和 cost ，如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。
 * 如果存在解，则 保证 它是 唯一 的。
 */
public class Leetcode134 {
    public static void main(String[] args) {
        int[] gas = new int[]{4,5,3,1,4};
        int[] cost = new int[]{5,4,3,4,2};
        Leetcode134 yb = new Leetcode134();
        System.out.println(yb.canCompleteCircuit(gas,cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int sum = 0;
        for(int i=0;i<len;i++){
            if(gas[i]>cost[i]){
                sum = gas[i]-cost[i];
                int k = i+1;
                while(sum>0 && k<len){
                    sum+=gas[k];
                    sum-=cost[k];
                    k++;
                }
                if(k==len && sum>=0){
                    k=0;
                    while(sum>0 && k<i){
                        sum+=gas[k];
                        sum-=cost[k];
                        k++;
                    }
                    if(k==i && sum>=0){
                        return i;
                    }
                }
                sum=0;
            }
        }
        return -1;
    }
}

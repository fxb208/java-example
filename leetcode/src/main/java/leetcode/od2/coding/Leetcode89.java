package leetcode.od2.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 89. 格雷编码
 *
 * n 位格雷码序列 是一个由 2n 个整数组成的序列，其中：
 * 每个整数都在范围 [0, 2n - 1] 内（含 0 和 2n - 1）
 * 第一个整数是 0
 * 一个整数在序列中出现 不超过一次
 * 每对 相邻 整数的二进制表示 恰好一位不同 ，且
 * 第一个 和 最后一个 整数的二进制表示 恰好一位不同
 * 给你一个整数 n ，返回任一有效的 n 位格雷码序列 。
 */
public class Leetcode89 {
    public static void main(String[] args) {
        Leetcode89 yb = new Leetcode89();
        yb.grayCode(2);
    }


    public List<Integer> grayCode(int n) {
        ArrayList<Integer> res = new ArrayList<>((int)Math.pow(2,n));
        res.add(0);
        res.add(1);
        for(int i=2;i<=n;i++){
            int length = (int)Math.pow(2,i-1);
            for(int j=0;j<length;j++){
                res.set(j,res.get(j)<<1);

            }
            for(int j=0;j<length;j++){
                res.add(res.get(length-1-j)+1);
            }
        }
        return res;
    }

    public List<Integer> grayCode_arr(int n) {
        Integer[] arr = new Integer[(int)Math.pow(2,n)];
        arr[0]=0;
        arr[1]=1;
        for(int i=2;i<=n;i++){
            int length = (int)Math.pow(2,i-1);
            for(int j=0;j<length;j++){
                arr[j]=arr[j]<<1;
                arr[2*length-1-j]=arr[j]+1;
            }
        }
        return Arrays.asList(arr);
    }



}

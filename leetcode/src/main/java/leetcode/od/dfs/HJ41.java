package leetcode.od.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * HJ41 称砝码
 *  对于每组测试数据：
 * 第一行：n --- 砝码的种数(范围[1,10])
 * 第二行：m1 m2 m3 ... mn --- 每种砝码的重量(范围[1,2000])
 * 第三行：x1 x2 x3 .... xn --- 每种砝码对应的数量(范围[1,10])
 */
public class HJ41 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int[] a = new int[len];
        int[] b = new int[len];
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<a.length;i++){
            a[i]=in.nextInt();
        }
        for(int j=0;j<b.length;j++){
            b[j]=in.nextInt();
        }
        set.add(0);
        for(int i=0;i<len;i++){
            List<Integer> lst = new ArrayList<>(set);
            for(int k=0;k<lst.size();k++) {
                for(int j=1;j<=b[i];j++){
                    set.add(lst.get(k) + a[i] * j);
                }
            }

        }
        System.out.println(set.size());
    }
}

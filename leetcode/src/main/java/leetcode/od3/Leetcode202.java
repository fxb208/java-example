package leetcode.od3;

import java.util.HashSet;
import java.util.Set;

/**
 * 202. 快乐数
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」 定义为：
 *
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 */
public class Leetcode202 {
    public static void main(String[] args) {
        Leetcode202 yb = new Leetcode202();
        System.out.println(yb.isHappy(7));
    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        return isHappy(n,set);
    }

    public boolean isHappy(int n, Set<Integer> set) {
        if(n==1){
            return true;
        }
        String str = String.valueOf(n);
        int res = 0;
        for(int i=0;i<str.length();i++){
            res+=Math.pow(Integer.valueOf(str.charAt(i)+""),2);
        }
        if(set.contains(res)){
            return false;
        }
        set.add(res);
        return isHappy(res,set);
    }
}

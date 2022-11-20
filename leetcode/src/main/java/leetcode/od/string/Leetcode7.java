package leetcode.od.string;

import com.sun.tools.javac.Main;

import java.util.TreeMap;

/**
 * 7. 整数反转
 *
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 */
public class Leetcode7 {
    public static void main(String[] args) {
        int max = Integer.MAX_VALUE;
        StringBuffer sb = new StringBuffer();
        System.out.println(Integer.parseInt(sb.append(max).append(1).toString()));
    }

    public int reverse(int x) {
        String str = String.valueOf(x);
        StringBuffer sb = new StringBuffer();
        for(int i=str.length()-1;i>1;i--){
            sb.append(str.charAt(i));
        }
        if(Character.isDigit(str.charAt(0))){
            sb.append(str.charAt(0));
        }else{
            sb.insert(0,str.charAt(0));
        }

        try{
            return Integer.parseInt(sb.toString());
        }catch (Exception e){

        }
        return 0;
    }
}

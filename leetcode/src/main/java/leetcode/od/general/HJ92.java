package leetcode.od.general;

import java.util.Scanner;

/**
 * HJ92 在字符串中找出连续最长的数字串
 * 描述
 * 输入一个字符串，返回其最长的数字子串，以及其长度。若有多个最长的数字子串，则将它们全部输出（按原字符串的相对位置）
 * 本题含有多组样例输入。
 *
 * 数据范围：字符串长度 1 \le n \le 200 \1≤n≤200  ， 保证每组输入都至少含有一个数字
 * 输入描述：
 * 输入一个字符串。1<=len(字符串)<=200
 *
 * 输出描述：
 * 输出字符串中最长的数字字符串和它的长度，中间用逗号间隔。如果有相同长度的串，则要一块儿输出（中间不要输出空格）。
 */
public class HJ92 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String text = in.next();
            int len=0;
            int[] dp=new int[text.length()];
            if(Character.isDigit(text.charAt(0))){
                dp[0]=1;
                len=1;
            }
            for(int i=1;i<text.length();i++){
                if(Character.isDigit(text.charAt(i))){
                    dp[i]=dp[i-1]+1;
                    len=Math.max(dp[i],len);
                }
            }
            StringBuffer sb = new StringBuffer();
            for(int i=0;i<dp.length;i++){
                if(dp[i]==len){
                    sb.append(text.substring(i+1-len,i+1));
                }
            }
            System.out.println(sb.toString() +","+ len);
        }
    }
}

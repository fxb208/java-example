package leetcode.od2.dp;

import java.util.Scanner;

/**
 * HJ71 字符串通配符
 * 描述
 * 问题描述：在计算机中，通配符一种特殊语法，广泛应用于文件搜索、数据库、正则表达式等领域。现要求各位实现字符串通配符的算法。
 * 要求：
 * 实现如下2个通配符：
 * *：匹配0个或以上的字符（注：能被*和?匹配的字符仅由英文字母和数字0到9组成，下同）
 * ？：匹配1个字符
 * 注意：匹配时不区分大小写。
 * 输入：
 * 通配符表达式；
 * 一组字符串。
 * 输出：
 * 返回不区分大小写的匹配结果，匹配成功输出true，匹配失败输出false
 */
public class HJ71 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 带有通配符的字符串
        //String aa=in.nextLine();
        // 需要匹配的字符串
        //String bb=in.nextLine();
        String aa="t?t*1*.*";  // 带有通配符的字符串
        String bb="txt12.xls";  // 需要匹配的字符串
        boolean res = match(aa.toLowerCase(),bb.toLowerCase());
        System.out.println(res);
    }

    public static boolean match(String aa,String bb){
        boolean[][] dp = new boolean[aa.length()+1][bb.length()+1];
        dp[0][0]=true;
        for(int i=1;i<=aa.length();i++){
            if(aa.charAt(i-1)=='*'){
                dp[i][0]=true;
            }else{
                break;
            }

        }
        for(int i=1;i<=aa.length();i++){
            for(int j=1;j<=bb.length();j++){
                if(aa.charAt(i-1)== bb.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else if(aa.charAt(i-1)=='?' && (Character.isDigit(bb.charAt(j-1)) || Character.isLowerCase(bb.charAt(j-1)))){
                    dp[i][j]=dp[i-1][j-1];
                }else if(aa.charAt(i-1)=='*' && (Character.isDigit(bb.charAt(j-1)) || Character.isLowerCase(bb.charAt(j-1)))){
                    dp[i][j]=dp[i-1][j] || dp[i][j-1] || dp[i-1][j-1];
                }
            }
        }
        return dp[aa.length()][bb.length()];

    }
}

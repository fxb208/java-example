package leetcode.od.dp;

import java.util.Scanner;

/**
 * HJ65 查找两个字符串a,b中的最长公共子串
 */
public class HJ65 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        int max = 0;
        int end = 0;
        if(a.length()>b.length()){
            String temp = a;
            a = b;
            b = temp;
        }
        int[][] dp=new int[a.length()][b.length()];
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)==b.charAt(0)){
                dp[i][0]=1;
                if(dp[i][0]>max){
                    end = i;
                    max = dp[i][0];
                }
            }
        }
        for(int i=0;i<b.length();i++){
            if(b.charAt(i)==a.charAt(0)){
                dp[0][i]=1;
            }
        }

        for(int i=1;i<a.length();i++){
            for(int j=1;j<b.length();j++){
                if(a.charAt(i)==b.charAt(j)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    if(dp[i][j]>max){
                        end = i;
                        max = dp[i][j];
                    }
                }else{
                    dp[i][j]=0;
                }
            }
        }
        if(max > 1){
            System.out.println(a.substring(end+1-max,end+1));
        } else{
            System.out.println("");
        }
    }
}

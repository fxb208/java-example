package leetcode.od.general;

import java.util.Locale;
import java.util.Scanner;

/**
 * HJ71 字符串通配符
 * 实现如下2个通配符：
 * *：匹配0个或以上的字符（注：能被*和?匹配的字符仅由英文字母和数字0到9组成，下同）
 * ？：匹配1个字符
 *
 * 输入描述：
 * 先输入一个带有通配符的字符串，再输入一个需要匹配的字符串
 */
public class HJ71 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a=in.nextLine();
        String b=in.nextLine();
        boolean res = match(a.toLowerCase(),b.toLowerCase(),0,0);
        System.out.println(res);
    }
    public static boolean match(String a,String b,int i,int j){
        if(i==a.length() && j==b.length()){
            return true;
        }
        if((i==a.length() && j !=b.length()) || (i!=a.length() && j ==b.length())){
            return false;
        }
        if(a.charAt(i)==b.charAt(j)){
            return match(a,b,i+1,j+1);
        }
        boolean bool = Character.isDigit(b.charAt(j)) || Character.isLowerCase(b.charAt(j));
        if(a.charAt(i)=='?' && bool){
            return match(a,b,i+1,j+1);
        }
        if(a.charAt(i)=='*'){
            if(bool){
                return match(a,b,i,j+1) || match(a,b,i+1,j+1);
            }else{
                return match(a,b,i+1,j);
            }

        }
        return false;
    }
}

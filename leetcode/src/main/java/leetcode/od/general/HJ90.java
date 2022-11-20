package leetcode.od.general;

import java.util.Scanner;

/**
 * HJ90 合法IP
 *  PV4地址可以用一个32位无符号整数来表示，一般用点分方式来显示，点将IP地址分成4个部分，
 *  每个部分为8位，表示成一个无符号整数（因此正号不需要出现），如10.137.17.1，
 *  是我们非常熟悉的IP地址，一个IP地址串中没有空格出现（因为要表示成一个32数字）。
 *  现在需要你用程序来判断IP是否合法。
 */
public class HJ90 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word = in.next();
        String[] arr = word.split("\\.");
        boolean res = true;
        if(arr.length<4){
            res = false;
        }
        for(String str:arr){
            if(!res){
                break;
            }
            res = res && suit(str);
        }
        if(res){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }

    public static boolean suit(String str){
        if(str.length()==0 || str.length()>3){
            return false;
        }
        for(Character ch : str.toCharArray()){
            if(!Character.isDigit(ch)){
                return false;
            }
        }
        int ip = Integer.parseInt(str);
        if((ip<256 && ip>0 && !str.startsWith("0")) || (ip==0 && "0".equals(str))){
            return true;
        }
        return false;
    }

//    public static boolean suit(String str){
//        try{
//            int ip = Integer.valueOf(str);
//            if((ip<256 && ip>0 && !str.startsWith("0") && !str.startsWith("+")) || (ip==0 && "0".equals(str))){
//                return true;
//            }
//        }catch (Exception e){
//        }
//        return false;
//    }
}

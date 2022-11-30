package leetcode.od2.math;

/**
 * 43. 字符串相乘
 *
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 */
public class Leetcode43 {
    public static void main(String[] args) {
        Leetcode43 yb = new Leetcode43();
        System.out.println(yb.multiply("999","999"));
    }

    public String multiply(String num1, String num2) {
        if("0".equals(num1) || "0".equals(num2)){
            return "0";
        }
        int[] arr = new int[num1.length()+num2.length()];
        for(int i=num1.length()-1;i>=0;i--){
            for(int j=num2.length()-1;j>=0;j--){
                int h=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                int a = h%10;
                int b = h/10;
                arr[i+j+1] = arr[i+j+1]+a;
                arr[i+j] = arr[i+j]+b;
            }
        }
        for(int i=arr.length-1;i>0;i--){
            if(arr[i]>9){
                int a = arr[i]%10;
                int b = arr[i]/10;
                arr[i] = a;
                arr[i-1] = arr[i-1]+b;
            }
        }
        StringBuilder sb = new StringBuilder();
        if(arr[0]>0){
            sb.append(arr[0]);
        }
        for(int i=1;i<arr.length;i++){
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}

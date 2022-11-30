package leetcode.od2.math;

/**
 * 415. 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 */
public class Leetcode415 {
    public static void main(String[] args) {
        Leetcode415 yb = new Leetcode415();
        System.out.println(yb.addStrings("123","987"));
    }

    public String addStrings(String num1, String num2) {
        int a = num1.length();
        int b = num2.length();
        int [] arr=new int[Math.max(a,b)+1];
        int i=a-1;
        int j=b-1;
        int idx = arr.length-1;
        while(i>=0 || j>=0){
            int num = 0;
            if(i>=0 && j>=0){
                num = (num1.charAt(i)-'0')+num2.charAt(j)-'0';
                i--;
                j--;
            }else if(i>=0){
                num = (num1.charAt(i)-'0');
                i--;
            }else{
                num = num2.charAt(j)-'0';
                j--;
            }
            arr[idx]+=num;
            if(arr[idx]>9){
                arr[idx]=arr[idx]%10;
                arr[idx-1]=1;
            }
            idx--;
        }
        StringBuilder sb = new StringBuilder();
        if(arr[0]>0){
            sb.append(arr[0]);
        }
        for(int k=1;k<arr.length;k++){
            sb.append(arr[k]);
        }
        return sb.toString();
    }
}

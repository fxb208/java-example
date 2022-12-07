package leetcode.od2.math;

/**
 * 66. 加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 */
public class Leetcode66 {
    public static void main(String[] args) {
        Leetcode66 yb = new Leetcode66();
        System.out.println(yb.plusOne(new int[]{9,9}));
    }

    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            if(i==digits.length-1){
                digits[i]++;
            }
            if(digits[i]==10 && i>0){
                digits[i]=0;
                digits[i-1]++;
            }else{
                break;
            }
        }
        if(digits[0]<10){
            return digits;
        }else{
            int[] res = new int[digits.length+1];
            System.arraycopy(digits,1,res,2,digits.length-1);
            res[0]=1;
            res[1]=0;
            return res;
        }
    }
}

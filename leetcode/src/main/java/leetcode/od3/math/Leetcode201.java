package leetcode.od3.math;

/**
 * 201. 数字范围按位与
 * 给你两个整数 left 和 right ，表示区间 [left, right] ，
 * 返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。
 */
public class Leetcode201 {
    public static void main(String[] args) {
        Leetcode201 yb = new Leetcode201();
        System.out.println(yb.rangeBitwiseAnd(2147483646,2147483647));
    }

    public int rangeBitwiseAnd(int left, int right) {
        if(left == right){
            return left;
        }
        int res = left & (left+1);
        if(left<Integer.MAX_VALUE-2){
            for(int i=left+2;i<=right;i++){
                if(res == 0){
                    return 0;
                }
                res = res & i;
            }
        }
        return res;
    }
}

package leetcode.od2.coding;

/**
 * 717. 1 比特与 2 比特字符
 *
 * 有两种特殊字符：
 *
 * 第一种字符可以用一比特 0 表示
 * 第二种字符可以用两比特（10 或 11）表示
 * 给你一个以 0 结尾的二进制数组 bits ，如果最后一个字符必须是一个一比特字符，则返回 true 。
 */
public class Leetcode717 {
    public static void main(String[] args) {
        Leetcode717 yb = new Leetcode717();
        System.out.println(yb.isOneBitCharacter(new int[]{1,1,1,0}));
    }

    public boolean isOneBitCharacter(int[] bits) {
        boolean res = true;
        for(int i=0;i<bits.length;i++){
            if(bits[i]==1){
                i++;
                res = false;
            }else{
                res = true;
            }
        }
        return res;
    }
}

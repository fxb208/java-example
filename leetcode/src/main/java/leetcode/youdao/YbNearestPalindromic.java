package leetcode.youdao;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/find-the-closest-palindrome/
 * 564. 寻找最近的回文数
 */
public class YbNearestPalindromic {
    public static void main(String[] args) {
        System.out.println(Math.abs(-8));  // 8
        System.out.println(Math.floor(7.9));  //7.0
        System.out.println(Math.round(7.7));  //8
        System.out.println(new StringBuffer("abc").reverse().toString());  //cba
        System.out.println(Math.pow(10, 2));  //100.0
        System.out.println(Math.pow(10, 4));  //10000.0
        System.out.println(1&1);  //1
        System.out.println(2&1);  //0
        System.out.println(3&1);  //1
        System.out.println(4&1);  //0
    }

    /**
     * 1, 构造回文整数有一个直观的方法：用原数的较高位的数字替换其对应的较低位。
     * 例如，对于数 12345，我们可以用 1 替换 5，用 2 替换 2，这样原数即变为回文整数 12321，
     * 用 222 替换 444，这样原数即变为回文整数 12321
     * 2, 构造的回文整数大于原数时，我们可以减小该回文整数的中间部分来缩小回文整数和原数的差距
     * 例如，对于数 99321，我们将构造出回文整数 99399，实际上 99299 更接近原数
     * 3, 构造的回文整数小于原数时，我们可以增大该回文整数的中间部分来缩小回文整数和原数的差距。
     * 例如，对于数 12399, 我们将构造出回文整数 12321,实际上 12421 更接近原数
     * 4, 构造的回文整数等于原数时，由于题目约定，我们需要排除该回文整数，在其他的可能情况中寻找最近的回文整数
     * @param n
     */
    String nearestPalindromic(String n) {
       return null;
    }


    public List<Long> getCandidates(String n){
        int length = n.length();
        List<Long> result = new LinkedList<>();
        result.add((long)Math.pow(length,length-1)-1);
        result.add((long)Math.pow(length,length)+1);
        return null;
    }
}

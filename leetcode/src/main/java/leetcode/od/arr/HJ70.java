package leetcode.od.arr;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *  HJ70 矩阵乘法计算量估算
 */
public class HJ70 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int[][] arr = new int[len][2];
        for(int i=0;i<len;i++){
            arr[i][0]=in.nextInt();
            arr[i][1]=in.nextInt();
        }
        String str = in.next();
        LinkedList<Character> lst = new LinkedList<>();
        long res=0;
        LinkedList<int[]> temp = new LinkedList<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='('){
                lst.add(str.charAt(i));
            }else if(Character.isUpperCase(str.charAt(i))){
                lst.add(str.charAt(i));
            }else{
                Character ch1 = lst.pollLast();
                Character ch2 = lst.pollLast();
                lst.pollLast();
                int[] a;
                int[] b;
                if(Character.isUpperCase(ch1)){
                    b = arr[ch1-'A'];
                }else{
                    b = temp.pollLast();
                }
                if(Character.isUpperCase(ch2)){
                    a = arr[ch2-'A'];
                }else{
                    a = temp.pollLast();
                }
                res=res+a[0]*a[1]*b[1];
                temp.add(new int[]{a[0],b[1]});
                lst.add('a');
            }
        }
        System.out.println(res);
    }
}

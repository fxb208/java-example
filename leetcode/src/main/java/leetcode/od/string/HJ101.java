package leetcode.od.string;

import java.util.Arrays;
import java.util.Scanner;

/**
 * HJ101 输入整型数组和排序标识，对其元素按照升序或降序进行排序
 */
public class HJ101 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        Integer[] arr = new Integer[len];
        for(int i=0;i<len;i++){
            arr[i]=in.nextInt();
        }
        int desc = in.nextInt();
        // Arrays.sort(arr,(o1,o2)->{return o1 - o2;});
        Arrays.sort(arr);
        StringBuffer sb = new StringBuffer();
        if(desc == 0){
            for(int i=0;i<arr.length;i++){
                sb.append(arr[i]).append(" ");
            }
        }else{
            for(int i=arr.length-1;i>=0;i--){
                sb.append(arr[i]).append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}

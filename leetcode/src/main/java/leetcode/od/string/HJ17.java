package leetcode.od.string;

import java.util.Scanner;

/**
 * HJ17 坐标移动
 */
public class HJ17 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        String[] arr = str.split(";");
        int[] result = new int[]{0,0};
        for(int i=0;i<arr.length;i++){
            if(arr[i].startsWith("A") && isInteger(arr[i].substring(1))>0){
                result[0]-=isInteger(arr[i].substring(1));
            }
            if(arr[i].startsWith("D") && isInteger(arr[i].substring(1))>0){
                result[0]+=isInteger(arr[i].substring(1));
            }
            if(arr[i].startsWith("W") && isInteger(arr[i].substring(1))>0){
                result[1]+=isInteger(arr[i].substring(1));
            }
            if(arr[i].startsWith("S") && isInteger(arr[i].substring(1))>0){
                result[1]-=isInteger(arr[i].substring(1));
            }
        }
        System.out.println(result[0]+","+result[1]);
    }

    static int isInteger(String word){
        try {
            int result = Integer.parseInt(word);
            if(result>0 && result<100){
                return result;
            }
        }catch(Exception ex) {

        }
        return 0;
    }
}

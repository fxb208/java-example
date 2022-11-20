package leetcode.od.string;

import java.util.Arrays;
import java.util.Scanner;

public class HJ33 {
    public static void main(String[] args) {

        // 3868643487
        // 2147483647
        System.out.println(Integer.MAX_VALUE);

        Scanner in = new Scanner(System.in);
        //String text1 = in.next(); //
        String text1 = "10.0.3.193";
        //String text2 = in.next(); //
        String text2 = "167969729";
        String[] arr = text1.split("\\.");
        StringBuffer sb1 = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            char[] chArr = new char[]{'0','0','0','0','0','0','0','0'};
            String str = Integer.toBinaryString(Integer.valueOf(arr[i]));
            System.arraycopy(str.toCharArray(),0,chArr,chArr.length-str.length(),str.length());
            sb1.append(String.valueOf(chArr));
        }
        //Integer result1 = Integer.parseUnsignedInt(sb1.toString());
        Long result1 = Long.parseLong(sb1.toString(),2);
        System.out.println(result1);

        StringBuilder sb2 = new StringBuilder();

        char[] chArr = new char[32];
        Arrays.fill(chArr,'0');
        String str = Long.toBinaryString(Long.valueOf(text2));
        System.arraycopy(str.toCharArray(),0,chArr,chArr.length-str.length(),str.length());
        String binary = String.valueOf(chArr).toString();
        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                sb2.append(Integer.parseInt(binary.substring(0, 8),2)).append(".");
            } else if (i == 1) {
                sb2.append(Integer.parseInt(binary.substring(8, 16),2)).append(".");
            } else if (i == 2) {
                sb2.append(Integer.parseInt(binary.substring(16, 24),2)).append(".");
            } else if (i == 3) {
                sb2.append(Integer.parseInt(binary.substring(24),2));
            }
        }
        System.out.println(sb2.toString());
    }

}

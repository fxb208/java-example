package leetcode.od.other;

import java.util.Scanner;

/**
 * HJ29 字符串加解密
 */
public class HJ29 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        //String text1=in.next();
        String text1 = "2OA92AptLq5G1lW8564qC4nKMjv8C";
        StringBuffer sb1 = new StringBuffer();
        for (int i = 0; i < text1.length(); i++) {
            if (Character.isDigit(text1.charAt(i))) {
                int val = Integer.valueOf(String.valueOf(text1.charAt(i)));
                sb1.append(Integer.valueOf(val == 9 ? 0 : val + 1));
            } else if (Character.isLowerCase(text1.charAt(i))) {
                char ch = Character.toUpperCase(text1.charAt(i));
                sb1.append((char) (ch == 'Z' ? 'A' : ch + 1));
            } else if (Character.isUpperCase(text1.charAt(i))) {
                char ch = Character.toLowerCase(text1.charAt(i));
                sb1.append((char) (ch == 'z' ? 'a' : ch + 1));
            }
        }
        System.out.println(sb1.toString());

        //String text2=in.next();
        String text2 = "B5WWIj56vu72GzRja7j5";
        StringBuffer sb2 = new StringBuffer();
        for (int i = 0; i < text2.length(); i++) {
            if (Character.isDigit(text2.charAt(i))) {
                int val = Integer.valueOf(String.valueOf(text2.charAt(i)));
                sb2.append(Integer.valueOf(val == 0 ? 9 : val - 1));
            } else if (Character.isLowerCase(text2.charAt(i))) {
                char ch = Character.toUpperCase(text2.charAt(i));
                sb2.append((char) (ch == 'A' ? 'Z' : ch - 1));
            } else if (Character.isUpperCase(text2.charAt(i))) {
                char ch = Character.toLowerCase(text2.charAt(i));
                sb2.append((char) (ch == 'a' ? 'z' : ch - 1));
            }
        }
        System.out.println(sb2.toString());
    }
}

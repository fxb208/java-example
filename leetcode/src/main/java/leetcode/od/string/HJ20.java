package leetcode.od.string;

import java.util.Scanner;

public class HJ20 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int result = 0;
        boolean repeat = false;
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String password = in.next();
            for (int i = 0; i < password.length(); i++) {
                if (Character.isDigit(password.charAt(i))) {
                    result = result | 1;
                } else if (Character.isLowerCase(password.charAt(i))) {
                    result = result | 2;
                } else if (Character.isUpperCase(password.charAt(i))) {
                    result = result | 4;
                } else {
                    result = result | 8;
                }
                if (i + 3 < password.length() && password.lastIndexOf(password.substring(i, i + 3)) - i > 3) {
                    repeat = true;
                    break;
                }
            }

            if (password.length() > 8 && !repeat && (result == 15 || result == 14 || result == 13 || result == 11 || result == 7)) {
                System.out.println("OK");
            } else {
                System.out.println("NG");
            }

        }
    }
}

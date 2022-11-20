package leetcode.od;

import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;

public class StringTest {

    @Test
    public void lengthTest(){
        String str="world";
        System.out.println(str.substring(2,5));
    }

    @Test
    public void splitTest(){
        String str="hello world";
        String[] arr = str.split(" ");
        System.out.println(arr.length);
    }

    @Test
    public void intValue(){
        String str = "01";
        System.out.println(Integer.valueOf(str));  // 1

        String str2 = "+01";
        System.out.println(Integer.valueOf(str2)); // 1
    }

    @Test
    public void isInt(){
        String str = "122";
        String regex = "[1-2][0-9]*";
        System.out.println(str.matches(regex));
    }
}

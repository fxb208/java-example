package leetcode.od.general;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HJ74 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word = in.nextLine();
        // String word = "xcopy /s c:\\ d:\\e";
        List<String> lst= new ArrayList<>();
        int spit = 0;
        int begin = 0;
        int end = 0;
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)=='\"' && spit==0){
                spit++;
                begin=i+1;
            }else if(word.charAt(i)=='\"' && spit==1){
                spit--;
                lst.add(word.substring(begin,i));
                begin=i+1;
            }else if(word.charAt(i)==' ' && spit==0){
                if(!word.substring(begin,i).equals("")){
                    lst.add(word.substring(begin,i));
                }
                begin=i+1;
            }
        }
        if(begin<word.length()){
            lst.add(word.substring(begin));
        }
        System.out.println(lst.size());
        for(String str : lst){
            System.out.println(str);
        }
    }
}

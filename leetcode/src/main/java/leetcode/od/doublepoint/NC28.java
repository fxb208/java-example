package leetcode.od.doublepoint;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * NC28 最小覆盖子串
 */
public class NC28 {

    public static void main(String[] args) {
        NC28 yb = new NC28();
        //System.out.println(yb.minWindow("XDOYEZODEYXNZ","XYZ"));
        //System.out.println(yb.minWindow("a","aa"));

        String s = "";
        String t = "";
        try (InputStream input = new FileInputStream("/home/fangxingbang/code/java-example/leetcode/config.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            s = prop.getProperty("s");
            t = prop.getProperty("t");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        char[] ss=s.toCharArray();
        char[] tt=t.toCharArray();
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        for(char ch:ss){
            map1.put(ch,map1.getOrDefault(ch,0)+1);
        }
        for(char ch:tt){
            map2.put(ch,map2.getOrDefault(ch,0)+1);
        }


        System.out.println(yb.minWindow(s,t));
    }

    public String minWindow (String S, String T) {
        char[] ss=S.toCharArray();
        char[] tt=T.toCharArray();
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        for(char ch:tt){
            map2.put(ch,map2.getOrDefault(ch,0)+1);
        }
        int right=0;
        int left=0;
        boolean valid = false;
        int vLen = 0;
        int len = ss.length;
        String res = "";
        while(right<ss.length){
            if(map2.containsKey(ss[right])){
                map1.put(ss[right],map1.getOrDefault(ss[right],0)+1);
                if(map1.get(ss[right]).equals(map2.get(ss[right]))){
                    vLen++;
                }
            }
            right++;
            if(vLen==map2.keySet().size()){
                valid = true;
            }
            while(valid){
                if(map2.containsKey(ss[left])){
                    map1.put(ss[left],map1.get(ss[left])-1);
                    if(map1.get(ss[left])<map2.get(ss[left])){
                        vLen--;
                        valid=false;
                        if(!valid){
                            if(right-left-1<len){
                                len=right-left;
                                res=S.substring(left,right);
                            }
                        }
                    }
                }
                left++;
            }

        }
        return res;
    }

//    public String minWindow (String S, String T) {
//        int j=0;
//        int begin=0;
//        int nextBegin = 0;
//        int len = S.length();
//        String res =S;
//        for(int i=0;i<S.length();i++){
//            if(j>0 && nextBegin==0 && S.charAt(i)==T.charAt(0)){
//                nextBegin = i;
//            }
//            if(S.charAt(i)==T.charAt(j)){
//                if(j==0){
//                    begin=i;
//                }
//                j++;
//                if(j==T.length()){
//                    if(i-begin+1<len){
//                        len=i-begin+1;
//                        res=S.substring(begin,len);
//                    }
//                    j=0;
//                    i=nextBegin;
//                }
//
//            }
//        }
//        return res;
//    }
}

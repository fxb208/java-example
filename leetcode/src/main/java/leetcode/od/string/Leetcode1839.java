package leetcode.od.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 1839. 所有元音按顺序排布的最长子字符串
 *
 * aeiou
 */
public class Leetcode1839 {
    public static void main(String[] args) {
        Leetcode1839 yb = new Leetcode1839();
        System.out.println(yb.longestBeautifulSubstring("aeiaaioaaaaeiiiiouuuooaauuaeiu"));
    }


    public int longestBeautifulSubstring(String word) {
        int res = 0;
        Map<Character,Integer> map = new HashMap<>();
        map.put('a',0);
        map.put('e',1);
        map.put('i',2);
        map.put('o',3);
        map.put('u',4);
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)=='a'){
                int left=i;
                int val=map.get('a');
                while(i<word.length()-1){
                    i++;
                    if(map.get(word.charAt(i)).equals(val+1)){
                        val+=1;
                    }else if(map.get(word.charAt(i)).equals(val)){
                        val+=0;
                    }else{
                        i--;
                        break;
                    }
                }
                if(val==4){
                    res=Math.max(res,i-left+1);
                }
            }
        }
        return res;
    }
}

package leetcode.od2;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. 罗马数字转整数
 *
 * I 1
 * V 5
 * X 10
 * L 50
 * C 100
 * D 500
 * M 1000
 */
public class Leetcode13 {
    public static void main(String[] args) {
        //
        Leetcode13 yb = new Leetcode13();
        yb.romanToInt("III");
    }

    public int romanToInt(String s) {
        Map<Character ,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int res = 0;
        s=s+"I";
        for(int i=0;i<s.length()-1;i++){
            if(map.get(s.charAt(i))>=map.get(s.charAt(i+1))){
                res+=map.get(s.charAt(i));
            }else{
                res +=map.get(s.charAt(i+1))-map.get(s.charAt(i));
                i++;
            }
        }
        return res;
    }
}

package leetcode.od.sort;

import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 *  HJ27 查找兄弟单词
 */
public class HJ27 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String[] arr = new String[len];
        for (int i = 0; i < len; i++) {
            arr[i] = in.next();
        }
        String word = in.next();
        int idx = in.nextInt();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < word.length(); i++) {
            map.put(word.charAt(i), map.getOrDefault(word.charAt(i), 0) + 1);
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() == word.length() && !arr[i].equals(word) && mather(map, arr[i])) {
                res.add(arr[i]);
            }
        }
        //
        System.out.println(res.size());
        if (res.size() >= idx) {
            Collections.sort(res);
            System.out.println(res.get(idx - 1));
        }

    }

    public static boolean mather(Map<Character, Integer> map, String str) {
        Map<Character, Integer> strMap = new HashMap<Character, Integer>();
        for (int i = 0; i < str.length(); i++) {
            strMap.put(str.charAt(i), strMap.getOrDefault(str.charAt(i), 0) + 1);
        }
        Boolean result = true;
        for (Character ch : map.keySet()) {
            if (!map.get(ch).equals(strMap.get(ch))) {
                result = false;
                break;
            }
        }
        return result;
    }
}

package leetcode.od2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Leetcode 17 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * <p>给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class Leetcode17 {
  public static void main(String[] args) {
    Leetcode17 yb = new Leetcode17();
    System.out.println(yb.letterCombinations("23"));
  }

  // [ad, ae, af]
  public List<String> letterCombinations(String digits) {
    Map<Character, String> map = new HashMap<>();
    map.put('2', "abc");
    map.put('3', "def");
    map.put('4', "ghi");
    map.put('5', "jkl");
    map.put('6', "mno");
    map.put('7', "pqrs");
    map.put('8', "tuv");
    map.put('9', "wxyz");
    List<String> res = new ArrayList<>();
    StringBuffer path = new StringBuffer();
    List<String> lst = new ArrayList<>();
    for (int i = 0; i < digits.length(); i++) {
      if (map.containsKey(digits.charAt(i))) {
        lst.add(map.get(digits.charAt(i)));
      }
    }
    if(lst.size()==0){
      return Collections.emptyList();
    }
    dfs(res, path, lst, 0);
    return res;
  }

  public static void dfs(List<String> res, StringBuffer path, List<String> lst, int idx) {
    if (path.length() == lst.size()) {
      res.add(path.toString());
      return;
    }
    for (int i = idx; i < lst.size(); i++) {
      for (int j = 0; j < lst.get(i).length(); j++) {
        path.append(lst.get(i).charAt(j));
        dfs(res, path, lst, i+1);
        path.delete(path.length() - 1, path.length());
      }
    }
  }
}

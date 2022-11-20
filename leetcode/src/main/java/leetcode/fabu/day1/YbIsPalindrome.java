package leetcode.fabu.day1;

/** 9. 回文数 https://leetcode.cn/problems/palindrome-number/ */
public class YbIsPalindrome {

  public boolean isPalindrome(int x) {
    String str = String.valueOf(x);
    int length = str.length();
    boolean result = true;
    for (int i = 0; i < length / 2; i++) {
      if (str.charAt(i) != str.charAt(length - 1 - i)) {
        result = false;
      }
    }
    return result;
  }
}

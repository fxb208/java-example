package com.yb.project.algorithm.two.dp;

/** 5. 最长回文子串 https://leetcode.cn/problems/longest-palindromic-substring/ */
public class YbLongestPalindrome {
  public static void main(String[] args) {

    String s = "aaaa";
    YbLongestPalindrome yb = new YbLongestPalindrome();
    System.out.println(yb.longestPalindrome(s));
  }

  public String longestPalindrome(String s) {
    int len = s.length();
    boolean[][] dp = new boolean[len][len];
    for (int i = 0; i < len; i++) {
      dp[i][i] = true;
    }
    int begin = 0;
    int maxLength = 0;
    for (int i = 0; i + 1 < len; i++) {
      if (s.charAt(i) == s.charAt(i + 1)) {
        begin = i;
        maxLength = 2;
        dp[i][i + 1] = true;
      }
    }

    for (int j = 2; j < len; j++) {
      for (int i = 0; i + j < len; i++) {
        if (dp[i + 1][i + j - 1] && s.charAt(i) == s.charAt(i + j)) {
          dp[i][i + j] = true;
          begin = i;
          maxLength = j + 1;
        }
      }
    }
    return s.substring(begin, begin + maxLength);
  }
}

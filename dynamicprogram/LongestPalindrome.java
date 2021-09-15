package com.yezhibo.leetcode.dynamicprogram;

import org.junit.Test;

/**
 * 5.最长回文子串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * 题目描述：
 * 给定一个字符串s，找到s中最长的回文子串。
 *
 * 解题思路：
 * 设dp[i][j] 表示字符串从位置i到位置j之间的字符是否为回文串
 * 则状态转移方程可表示为：
 *
 * dp[i][j] = s[i]==s[j] && dp[i+1][j-1]
 *
 * 最终求出dp[i][j] 为true并且 j-i最大的即可
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        init(dp, s.length());
        String result = s.substring(0, 1);
        for (int l = 1; l < s.length(); l++) {
            for (int i = 0; i + l < s.length(); i++) {
                int j = i + l;
                if (s.charAt(i) == s.charAt(j)) {
                    if (l == 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if (dp[i][j] && (l+1) > result.length()) {
                    result = s.substring(i, j+1);
                }
            }
        }
        return result;
    }

    private void init(boolean[][] dp, int n) {
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
    }

    @Test
    public void test() {
        String s1 = "babad";
        System.out.println(longestPalindrome(s1));

        String s2 = "cbbd";
        System.out.println(longestPalindrome(s2));

        String s3 = "a";
        System.out.println(longestPalindrome(s3));
    }
}

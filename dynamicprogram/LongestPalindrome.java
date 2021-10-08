package com.yezhibo.leetcode.dynamicprogram;

import org.junit.Test;

/**
 * 5.最长回文子串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * 题目描述：
 * 给你一个字符串s，找到s中最长的回文子串
 *
 * 解题思路：
 * 如果一个子串为回文串，那么去掉首尾元素后依然是回文子串
 * 利用该原理可以缩小问题规模，进而采用动态规划算法
 *
 * 设dp[i][j] 表示以第i个字符开始到第j个字符结束的子串是否为回文串，则有递推方程：
 *
 * if(j-i==0 || (j-i==1 && s[i]=s[j])) {
 *     dp[i][j] = true;
 * }
 * if (s[i]==s[j] && dp[i+1][j-1]) {
 *     dp[i][j] = true;
 * }
 *
 * 注意：由于递推方程是从短到长来依次递进的，所以遍历时可按子串长度来遍历；
 * 最终输出结果为最长回文串，因此需要定义一个全局变量用来存储单步执行后的最长回文串
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

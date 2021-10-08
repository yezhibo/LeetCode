package com.yezhibo.leetcode.dynamicprogram;

import org.junit.Test;

import java.util.Arrays;

/**
 * 32.最长有效括号
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 *
 * 题目描述：
 * 给定一个只包含'（'和'）'的字符串，求出最长有效（格式正确且连续）括号子串的长度
 *
 * 设输入字符串为s，s[i]表示s的第i个位置上的字符
 * 设dp[i] 表示以s[i]为结尾的最长有效括号子串的长度，则状态转移方程表示为：
 *
 * if (s[i] == ')' && s[i-1] == '(') {
 *     dp[i] = dp[i-2] + 2;
 * }
 * if (s[i] = ')' && s[i-1] == ')' && s[i-dp[i-1]-1] == '(') {
 *     dp[i] = dp[i-1] + 2 + dp[i-dp[i-1]-2]
 * }
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s.length() < 2) {
            return 0;
        }
        int[] dp = new int[s.length()];
        dp[0] = 0;
        dp[1] = s.charAt(0) == '(' && s.charAt(1) == ')' ? 2 : 0;

        for (int i = 2; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                continue;
            }
            if (s.charAt(i-1) == '(') {
                dp[i] = dp[i-2] + 2;
                continue;
            }
            int preIndex = i-dp[i-1]-1;
            if (preIndex >= 0 && s.charAt(preIndex) == '(') {
                int preMaxSize = preIndex-1 >= 0 ? dp[preIndex-1] : 0;
                dp[i] = dp[i-1] + 2 + preMaxSize;
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }

    @Test
    public void test() {
        String s1 = "";
        String s2 = "(";
        String s3 = "()";
        String s4 = "()()()()()()()";
        String s5 = ")()()()(((";
        System.out.println(longestValidParentheses(s1));
        System.out.println(longestValidParentheses(s2));
        System.out.println(longestValidParentheses(s3));
        System.out.println(longestValidParentheses(s4));
        System.out.println(longestValidParentheses(s5));
    }

}

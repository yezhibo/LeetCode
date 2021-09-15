package com.yezhibo.leetcode.dynamicprogram;

import org.junit.Test;

/**
 * 44.通配符匹配
 * https://leetcode-cn.com/problems/wildcard-matching/
 *
 * 同问题：https://leetcode-cn.com/problems/regular-expression-matching/
 *
 * 题目描：
 * 给定一个字符串s和一个字符模式p，实现一个支持?和*的匹配：
 * ?可以匹配任何单个字符
 * *可以匹配任意的字符串，包含空串
 *
 * 用d[i][j]表示字符串s的前i个字符和模式p的前j个字符匹配结果
 * 状态转移方程：
 * if(s[i]==p[j] || p[j]=='?') {
 *     d[i][j] = d[i-1][j-1]
 * }
 *
 * if(p[j] == '*') {
 *     d[i][j] = d[i][j-1] | d[i-1][j]
 * }
 */
public class IsMach {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        initDp(dp, p);
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i][j-1] | dp[i-1][j];
                    continue;
                }
                if (p.charAt(j-1) == '?' || p.charAt(j-1) == s.charAt(i-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    private void initDp(boolean[][] dp, String p) {
        for (int j = 1; j<=p.length(); j++) {
            if (p.charAt(j-1) == '*') {
                dp[0][j] = dp[0][j-1];
            }
        }
    }

    @Test
    public void test() {
        String s1 = "acdcb";
        String p1 = "a*c?b";
        System.out.println(isMatch(s1, p1));
    }
}

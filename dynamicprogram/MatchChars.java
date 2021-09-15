package com.yezhibo.leetcode.dynamicprogram;

import org.junit.Test;

/**
 * 10.正则表达式匹配
 * https://leetcode-cn.com/problems/regular-expression-matching/
 *
 * 题目描述：
 * 给你一个字符串s和一个字符规律p，请你来实现一个支持 '.'和'*'的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖整个字符串s的，而不是部分字符串。
 *
 * 解题思路：采用动态规划
 * 匹配规则：字母相等匹配，.匹配任意字符，*匹配0个或多个前一个字母
 *
 *
 * 递推公式：d[i][j] = d[]
 */
public class MatchChars {
    private static final char STAR = '*';
    private static final char POINT = '.';
    private static final char SPACE = ' ';
    public boolean isMatch(String s, String p) {
        boolean[][] result = new boolean[s.length()+1][p.length()+1];
        initResult(result, s, p);
        for (int i = 1; i<=s.length(); i++) {
            char si = s.charAt(i-1);
            for (int j = 1; j<=p.length(); j++) {
                char pj = p.charAt(j-1);
                if (si == pj || pj == POINT) {
                    result[i][j] = result[i-1][j-1];
                    continue;
                }

                if (pj == STAR) {
                    if (result[i][j-2]) {
                        result[i][j] = true;
                    } else if (si == p.charAt(j-2) || p.charAt(j-2) == POINT){
                        result[i][j] = result[i-1][j];
                    }

                }
            }
        }
        return result[s.length()][p.length()];
    }

    private void initResult(boolean[][] result, String s, String p) {
        result[0][0] = true;
        for (int i = 1; i<=p.length(); i++) {
            if (p.charAt(i-1) == STAR) {
                result[0][i] = result[0][i-2];
            }
        }
    }

    @Test
    public void test() {
        try {
            System.out.println(isMatch("a", ".*..a*"));
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}

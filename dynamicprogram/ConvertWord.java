package com.yezhibo.leetcode.dynamicprogram;

import org.junit.Test;

/**
 * 72.编辑距离
 * https://leetcode-cn.com/problems/edit-distance/
 *
 * 题目描述：
 * 给你两个单词word1和word2，请你计算出将word1转换成word2所使用的最小操作数
 * 你可以对一个单词进行如下三种操作：
 * 1、插入一个字符
 * 2、删除一个字符
 * 4、替换一个字符
 *
 * 解题思路：
 * 如果只看最后一个字符，A转B的所有可能操作有：
 * 1、在A后边追加
 * 2、在B后边追加
 * 3、a 和 b相互转换
 *
 * 设dp[i][j] 表示word1的前i个字符转换成word2的前j个字符所使用的最小操作数
 *
 * 则，有状态转移方程：
 * if (word1[i] == word2[j]) {
 *     dp[i][j] = Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1, dp[i-1][j-1]);
 * } else {
 *     dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1;
 * }
 */
public class ConvertWord {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        init(dp);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1), dp[i-1][j-1]);
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    private void init(int[][] dp) {
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = j;
        }
    }

    @Test
    public void test() {
        System.out.println(minDistance("horse", "ros"));
        System.out.println(minDistance("intention", "execution"));
    }
}

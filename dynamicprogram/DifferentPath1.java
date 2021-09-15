package com.yezhibo.leetcode.dynamicprogram;

import org.junit.Test;

/**
 * https://www.cnblogs.com/wxd0108/p/5295017.html
 *
 * 题目描述：
 *
 * 一个机器人位于一个m*n网络的左上角，机器人每次只能向下或者向右移动一步。
 * 机器人试图达到网格的右下角，问总共右多少条路径
 *
 * 解题思路：
 * 设dp[i][j]表示从起点到该点不同路径的条数，则有状态转移方程：
 *
 * dp[i][j] = dp[i][j-1] + dp[i-1][j]
 */
public class DifferentPath1 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        init(dp);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }

    private void init(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = 1;
        }
    }

    @Test
    public void test() {
        System.out.println(uniquePaths(3, 7));
    }
}

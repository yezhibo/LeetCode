package com.yezhibo.leetcode.dynamicprogram;

import org.junit.Test;

/**
 * 64. 最小路径和
 * https://leetcode-cn.com/problems/minimum-path-sum/
 *
 * 题目描述：
 * 给定一个包含非负整数的m*n网格grid，请找出一条从左上角到右下角的路径使得路径上的数字总和最小
 *
 * 解题思路：
 * 设dp[i][j]表示到网格i,j位置的最小路径和，则有
 * dp[i][j] = min(dp[i][j-1], dp[i-1][j]) + grid[i][j]
 *
 */
public class MinSumPath {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        init(dp, grid);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + grid[i][j];
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }

    private void init(int[][] dp, int[][] grid) {
        dp[0][0] = grid[0][0];
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
    }

    @Test
    public void test() {
        int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));

        int[][] grid1 = new int[][]{{1,2,3},{4,5,6}};
        System.out.println(minPathSum(grid1));
    }
}

package com.yezhibo.leetcode.dynamicprogram;

import org.junit.Test;

/**
 * 2017.网格游戏
 * https://leetcode-cn.com/problems/grid-game/
 */
public class GridGame {
    long[][] dp;
    public long gridGame(int[][] grid) {
        dp = new long[2][grid[0].length];
        getMaxPathSum(grid);
        fillPathNum(grid);
        dp = new long[2][grid[0].length];
        return getMaxPathSum(grid);
    }

    private long getMaxPathSum(int[][] grid) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                    continue;
                }
                if (i == 0 || (j > 0 && dp[i][j-1] > dp[i-1][j])) {
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                } else {
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                }
            }
        }
        return dp[1][grid[0].length-1];
    }

    private void fillPathNum(int[][] grid) {
        int i = 1;
        int j = grid[0].length - 1;
        for (int c = 0; c < grid[0].length; c++) {
            int cur = grid[i][j];
            grid[i][j] = 0;
            if (i == 0 || (j > 0 && dp[i][j] - cur == dp[i][j-1])) {
                j--;
            } else {
                i--;
            }
        }
        grid[i][j] = 0;
    }

    @Test
    public void test() {
        int[][] input = new int[][]{{20,3,20,17,2,12,15,17,4,15},{20,10,13,14,15,5,2,3,14,3}};
        System.out.println(gridGame(input));
    }
}

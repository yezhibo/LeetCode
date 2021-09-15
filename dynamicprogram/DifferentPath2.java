package com.yezhibo.leetcode.dynamicprogram;

import org.junit.Test;

/**
 * 63.不同路径2
 * https://leetcode-cn.com/problems/unique-paths-ii/
 *
 * 题目描述：
 * 一个机器人位于一个m*n网格左上角，机器人每次只能向下或者向右移动一步
 * 机器人试图到达网格的右下角，
 * 现在考虑网格中有障碍物，那么从左上角到右下角将会有多少条不同路径
 *
 * 输入为一个二维数组，0表示该点可以正常通过，1表示该点有障碍物
 *
 * 解题思路：
 * 设dp[i][j] 表示到该位置共有多少种不同的走法
 *
 * 则状态方程表示为：
 *
 * if(input[i][j] == 0) {
 *     dp[i][j] = dp[i][j-1] + dp[i-1][j];
 * }
 */
public class DifferentPath2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        init(obstacleGrid, dp);
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
            }
        }
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

    /**
     * 对于第一行和第一列，如果某个地方值为1，表示从此处开始后边的位置都不可访问
     *
     * @param graph graph
     * @param dp dp
     */
    private void init(int[][] graph, int[][] dp) {
        for (int i = 0; i < graph.length; i++) {
            if (graph[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }
        for (int j = 0; j < graph[0].length; j++) {
            if (graph[0][j] == 1) {
                break;
            }
            dp[0][j] = 1;
        }
    }

    @Test
    public void test() {
        int[][] graph = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(graph));

        int[][] graph2 = new int[][]{{0,0}};
        System.out.println(uniquePathsWithObstacles(graph2));

        int[][] graph3 = new int[][]{{1,0}};
        System.out.println(uniquePathsWithObstacles(graph3));
    }
}

package com.yezhibo.leetcode.dynamicprogram;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * 85.最大矩形
 * https://leetcode-cn.com/problems/maximal-rectangle/
 *
 * 题目描述：
 * 给定一个仅包含0和1、大小为rows*cols的二维二进制矩阵，找出只包含1的最大矩形，并返回其面积
 *
 * 解题思路：
 * 设dp[i][j] 表示第i行前j个数连续1的个数
 *
 */
public class MaxRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[][] heightsArr = calculateHeight(matrix);
        int[] maxAreas = new int[heightsArr.length];
        for (int i = 0; i < maxAreas.length; i++) {
            maxAreas[i] = largestRectangleArea(heightsArr[i]);
        }
        return Arrays.stream(maxAreas).max().getAsInt();
    }

    public int largestRectangleArea(int[] heights) {
        int result = 0;
        int[] newHeights = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeights, 1, heights.length);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < newHeights.length; i++) {
            while (!stack.empty() && newHeights[i] < newHeights[stack.peek()]) {
                int curHeight = newHeights[stack.pop()];
                result = Math.max(result, curHeight * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        return result;
    }

    public int[][] calculateHeight(char[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];
        for (int j = 0; j < matrix[0].length; j++) {
            int height = 0;
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] == '1') {
                    result[i][j] = ++height;
                } else {
                    height = 0;
                }
            }
        }
        return result;
    }

    @Test
    public void test() {
        char[][] matrix = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},
                {'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalRectangle(matrix));
    }
}

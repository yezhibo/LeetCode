package com.yezhibo.leetcode.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * 867.转置矩阵
 * https://leetcode-cn.com/problems/transpose-matrix/
 *
 * 题目描述：
 * 给你一个二维整数数组matrix，返回matrix的转置矩阵
 *
 *
 * 解题思路：
 * 将矩阵的行列互换
 *
 */
public class TransposeMatrix {
    public int[][] transpose(int[][] matrix) {
        int[][] result = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    @Test
    public void test() {
        int[][] result = transpose(new int[][]{{1,2,3},{4,5,6}});
        System.out.println(Arrays.toString(result));
    }
}

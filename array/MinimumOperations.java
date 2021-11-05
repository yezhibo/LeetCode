package com.yezhibo.leetcode.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;

/**
 * 2033.获取单值网格的最小操作数
 * https://leetcode-cn.com/problems/minimum-operations-to-make-a-uni-value-grid/
 *
 * 解题思路：
 * 1、求出网格数的中位数，最大值加最小值/2  中间两个数与其最接近的
 *
 * 2、累加每个数转换为该数的操作次数，如果无法转换，则转换失败。
 */
public class MinimumOperations {
    public int minOperations(int[][] grid, int x) {
        List<Integer> list = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        if (m*n == 1) {
            return 0;
        }
        for (int[] ints : grid) {
            for (int j = 0; j < n; j++) {
                list.add(ints[j]);
            }
        }
        list.sort(Comparator.comparingInt(v -> v));
        int target = list.get((m*n) / 2);

        int minOperations = 0;
        for (int[] ints : grid) {
            for (int j = 0; j < n; j++) {
                int cur = ints[j];
                int diff = Math.abs(cur - target);
                if (diff % x > 0) {
                    return -1;
                }
                minOperations += diff / x;
            }
        }
        return minOperations;
    }

    @Test
    public void test() {
        //System.out.println(minOperations(new int[][]{{2,4},{6,8}}, 2));
        System.out.println(minOperations(new int[][]{{1,5},{2,3}}, 1));
        System.out.println(minOperations(new int[][]{{1,2},{3,4}}, 2));
    }
}

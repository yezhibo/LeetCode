package com.yezhibo.leetcode.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 建信02. 柱状图分析
 * https://leetcode-cn.com/contest/ccbft-2021fall/problems/9Rs2aO/
 *
 * 解题思路：
 * 1、对原始数组从小到大排序
 * 2、从头开始遍历排序后的数组，找出差值最小的柱形组
 *
 */
public class FindMinDiffArr {
    public int[] analysisHistogram(int[] heights, int cnt) {
        Arrays.sort(heights);
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        int n = heights.length - cnt + 1;
        for (int i = 0; i < n; i++) {
            int diff = heights[i+cnt-1] - heights[i];
            if (diff < min) {
                min = diff;
                minIndex = i;
            }
        }
        int[] result = new int[cnt];
        System.arraycopy(heights, minIndex, result, 0, cnt);
        return result;
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(analysisHistogram(new int[]{3,2,7,6,1,8}, 3)));
    }
}

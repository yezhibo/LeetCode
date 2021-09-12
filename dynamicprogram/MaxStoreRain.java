package com.yezhibo.leetcode.dynamicprogram;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/trapping-rain-water/
 *
 * 题目描述：给定n个非负整数表示每个宽度为1的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 思路：每个坐标的雨水量 v[i] = min(left_max[i], right_max[i]) - height[i]
 * left_max[i] 表示当前坐标左侧最大值，right_max[i] 表示当前坐标右侧坐标最大值
 *
 */
public class MaxStoreRain {
    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int[] left_max = new int[height.length];
        int[] right_max = new int[height.length];
        for (int i = 1; i<height.length; i++) {
            left_max[i] = Math.max(height[i - 1], left_max[i - 1]);
        }
        for (int j = height.length - 2; j>=0; j--) {
            right_max[j] = Math.max(height[j+1], right_max[j+1]);
        }
        int ans = 0;
        for (int i = 1; i < height.length -1; i++) {
            int max = Math.min(left_max[i], right_max[i]);
            if (max > height[i]) {
                ans += max - height[i];
            }
        }
        return ans;
    }

    @Test
    public void test(){
        int[] height1 = new int[]{};
        int[] height2 = new int[]{3,1,5};
        int[] height3 = new int[]{9,1,2,3,4,5,10};
        int[] height4 = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height1));
        System.out.println(trap(height2));
        System.out.println(trap(height3));
        System.out.println(trap(height4));
    }
}

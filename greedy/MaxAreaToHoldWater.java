package com.yezhibo.leetcode.greedy;

import org.junit.Test;

/**
 * 11.盛水最多的容器
 * https://leetcode-cn.com/problems/container-with-most-water/
 *
 * 题目描述：
 * 给你n个非负整数a1,a2,...,an，每个数代表坐标中的一个点（i，ai）；
 * 找出其中的两个点，使他们与x轴构成的容器可以容纳最多的水
 *
 * 解题思路：
 * 采用双指针的方法，每次移动指针数值较小的那个，保证下次数据能取到更大的
 *
 */
public class MaxAreaToHoldWater {
    public static int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int leftValue = height[left];
            int rightValue = height[right];
            maxArea = Math.max(maxArea, (right - left) * Math.min(leftValue, rightValue));
            if(leftValue < rightValue) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    @Test
    public void test() {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}

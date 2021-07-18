package com.yezhibo.leetcode.greedy;

/**
 * 求一个数组中能组成的最大区域：
 * 盛水最多的容器
 */
public class MaxArea {
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

    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}

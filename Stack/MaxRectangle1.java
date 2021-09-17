package com.yezhibo.leetcode.Stack;

import org.junit.Test;

import java.util.Stack;

/**
 * 84.柱状图中最大的矩形
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 *
 * 题目描述：
 * 给定n个非负整数，用来表示柱状图中各个柱子的高度。每个柱子相邻，且宽度为1。
 * 求在该柱状图中，能够勾勒出来的所有矩形的最大面积。
 *
 * 解题思路：
 * 分别求出以每个坐标高度为高的最大矩形面积，最终从中选出最大的即为总体最大的面积。
 * 每个点的面积 等于该点左侧小于其本身的最近点到右侧小于其本身的最近点的距离于高度之积
 *
 * 维护一个单调栈，栈中存储数组的下标，并且保证下标对应的数值为单调递增，则一旦有小于的
 * 就可弹出栈顶元素，并计算出该元素的高度
 *
 */
public class MaxRectangle1 {
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

    @Test
    public void test() {
        int[] input = new int[]{2,1,5,6,2,3};
        System.out.println(largestRectangleArea(input));
    }
}

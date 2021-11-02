package com.yezhibo.leetcode.string;

import org.junit.Test;

import java.util.Arrays;

/**
 * 2055.蜡烛之间的盘子
 * https://leetcode-cn.com/problems/plates-between-candles/
 *
 * 直接暴力求解会超时，需要对结果进行缓存
 *
 * 1.缓存*的前缀和，那么最终结果即为：子串中第一个| 与最后一个|之间的*
 *
 * 2、如何快速找到第一个| 和最后一个|：
 * 缓存每个点离得最近的前一个| 和后一个| 则子串的第一个|即为第一个元素
 * 离的最近的后一个| 最后一个|为最后一个元素离的最近的前一个|
 */
public class PlateBTCandles {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        // 缓存*的前缀和
        int[] sum = new int[n+1];
        // 缓存第i个元素离的最近的前一个|
        int[] before = new int[n];
        // 缓存第i个元素离的最近的后一个|
        int[] after = new int[n];
        for (int i = 1; i < n+1; i++) {
            sum[i] = (arr[i-1] == '*') ? (sum[i-1] + 1) : sum[i-1];
        }
        for (int i = 0, pre = -1; i < n; i++) {
            if (arr[i] == '|') {
                pre = i;
            }
            before[i] = pre;
        }
        for (int i = n-1, pre = n; i > -1; i--) {
            if (arr[i] == '|') {
                pre = i;
            }
            after[i] = pre;
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = after[queries[i][0]];
            int right = before[queries[i][1]];
            if (left>=queries[i][0] && left <= queries[i][1] && right>=queries[i][0] && right<= queries[i][1]) {
                result[i] = sum[right] - sum[left];
            }
        }
        return result;
    }


    @Test
    public void test() {
        String str = "***|**|*****|**||**|*";
        int[][] queries = new int[][]{{1,17},{4,5},{14,17},{5,11},{15,16}};
        System.out.println(Arrays.toString(platesBetweenCandles(str, queries)));
    }
}


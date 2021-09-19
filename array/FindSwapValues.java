package com.yezhibo.leetcode.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 面试题16.21.交换和
 * https://leetcode-cn.com/problems/sum-swap-lcci/
 *
 * 题目描述：
 * 给定两个整数数组，请交换一对数值，使得两个数组所有元素和相等
 * 返回一个数组，第一个元素是第一个数组中要交换的元素，第二个元素是第二个数组中要交换的元素
 * 若有多个答案，返回任意一个均可。若无满足条件的数组，返回空数组。
 *
 * 解题思路：
 * 如果想让两个数组交换某个值后，和相等，那么两个数组的差值必须是偶数
 *
 * 设两个数组差值为diff
 * 交换的元素要满足：
 * num1 - num2 = diff/2
 * 遍历第一个数组，查找是否有满足该条件的元素即可
 */
public class FindSwapValues {
    public static int[] findSwapValues(int[] array1, int[] array2) {
        // 1.计算出两个数组和的差值
        int sum1 = Arrays.stream(array1).sum();
        int sum2 = Arrays.stream(array2).sum();
        int range = sum1 - sum2;
        if (range%2 !=0 ) {
            return new int[0];
        }
        Set<Integer> array1Set = Arrays.stream(array1).boxed().collect(Collectors.toSet());
        for (int val2 : array2) {
            if (array1Set.contains(val2 + range/2)) {
                return new int[]{val2+range/2, val2};
            }
        }
        return new int[0];
    }

    @Test
    public void test() {
        int[] array1 = new int[]{4, 1, 2, 1, 1, 2};
        int[] array2 = new int[]{3, 6, 3, 3};
        System.out.println(Arrays.toString(findSwapValues(array1, array2)));
    }
}

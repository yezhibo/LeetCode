package com.yezhibo.leetcode.array;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 给定两个整数数组，请交换一对数值，使得两个数组所有元素和相等
 */
public class FindSwapValues {
    public static int[] findSwapValues(int[] array1, int[] array2) {
        // 1.计算出两个数组和的差值
        int sum1 = getSum(array1);
        int sum2 = getSum(array2);
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



    private static int getSum(int[] array) {
        int sum = 0;
        for (int val : array) {
            sum += val;
        }
        return sum;
    }


    public static void main(String[] args) {
        int[] array1 = new int[]{4, 1, 2, 1, 1, 2};
        int[] array2 = new int[]{3, 6, 3, 3};
        System.out.println(Arrays.toString(findSwapValues(array1, array2)));
    }
}

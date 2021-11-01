package com.yezhibo.leetcode.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 5898.数组中第k个独一无二的字符串
 * https://leetcode-cn.com/problems/kth-distinct-string-in-an-array/
 *
 * 解题思路：
 * 1、统计出每个字符的个数
 * 2、删掉个数大于1的字符
 * 3、输出第k个字符
 */
public class KthDistinctStr {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> strCountMap = new HashMap<>();
        for (String str : arr) {
            int count = strCountMap.getOrDefault(str, 0);
            strCountMap.put(str, count + 1);
        }
        List<String> result = new ArrayList<>();
        for (String str : arr) {
            if (strCountMap.get(str) == 1) {
                result.add(str);
            }
        }
        return result.size() < k ? "" : result.get(k-1);
    }

    @Test
    public void test() {
        System.out.println(kthDistinct(new String[]{"d","b","c","b","c","a"}, 2));
    }
}

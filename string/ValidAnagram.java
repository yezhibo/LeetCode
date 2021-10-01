package com.yezhibo.leetcode.string;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 242.有效的字母异味词
 * https://leetcode-cn.com/problems/valid-anagram/
 *
 * 题目描述：
 * 给定两个字符串s和t，编写一个函数来判断t是否为s的字母异位词
 * 注意：若s和t中每个字符出现的次数都相同，则称s和t互为字母异位词。
 *
 * 解题思路：
 * 定义一个缓存来存储每个字符出现的频度
 * 遍历两次字符串，一次加，一次减；最终判断字符频度是否为0
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) - 1);
        }
        for (int f : freq.values()) {
            if (f != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    @Test
    public void test() {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
    }
}

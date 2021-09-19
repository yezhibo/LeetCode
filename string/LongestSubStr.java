package com.yezhibo.leetcode.string;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 3.无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * 题目描述：
 * 输入一个字符串s，请你找出其中不包含重复字符的最长字串的长度
 *
 * 思路：利用滑动窗口的方法
 * 遍历以每个字符为开头的最长不重复子串，从中找出最大的即为结果
 */
public class LongestSubStr {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> occ = new HashSet<>();
        int maxLength = 0;
        int rl = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (i>0){
                occ.remove(s.charAt(i-1));
            }
            while (rl < n && !occ.contains(s.charAt(rl))) {
                occ.add(s.charAt(rl));
                rl++;
            }
            maxLength = Math.max(maxLength, occ.size());
        }
        return maxLength; 
    }

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}

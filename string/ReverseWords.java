package com.yezhibo.leetcode.string;

import org.junit.Test;

/**
 * 557.反转字符串中的单词2
 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 *
 * 题目描述：
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * 解题思路：
 * 先把字符串按空格分割，然后依次反转每个单词，最后再拼接
 */
public class ReverseWords {
    public String reverseWords(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = reverseWord(words[i]);
        }
        return String.join(" ", words);
    }

    private String reverseWord(String word) {
        char[] input = word.toCharArray();
        int length = word.length();
        int mid = length / 2;
        for (int i = 0; i < mid; i++) {
            char tmp = input[length - i - 1];
            input[length - i - 1] = input[i];
            input[i] = tmp;
        }
        return new String(input);
    }

    @Test
    public void test() {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }

}

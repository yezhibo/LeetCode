package com.yezhibo.leetcode.string;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 819.最常见的单词
 * https://leetcode-cn.com/problems/most-common-word/
 *
 * 题目描述：
 * 给定一个段落和一个禁用单词列表，返回出现次数最多，同时不在禁用列表中的单词
 * 题目保证至少有一个词不在禁用列表中，而且答案唯一
 *
 * 解题思路：
 * 1、提取出段落中的单词：仅包含字母的
 * 2、统计出不在禁用列表中的单词的数量；
 *
 */
public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = Arrays.stream(banned).collect(Collectors.toSet());
        Map<String, Integer> wordFreq = new HashMap<>();
        paragraph += ".";
        char[] chars = paragraph.toCharArray();
        StringBuilder word = new StringBuilder();
        int maxFreq = Integer.MIN_VALUE;
        String result = "";
        for (char c : chars) {
            if (Character.isLetter(c)) {
                word.append(Character.toLowerCase(c));
                continue;
            }
            if (bannedSet.contains(word.toString())) {
                word = new StringBuilder();
                continue;
            }
            if (word.length() == 0) {
                continue;
            }
            int freq = wordFreq.getOrDefault(word.toString(), 0) + 1;
            wordFreq.put(word.toString(), freq);
            if (freq > maxFreq) {
                maxFreq = freq;
                result = word.toString();
            }
            word = new StringBuilder();
        }
        return result;
    }

    @Test
    public void test() {
        //System.out.println(mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));
        //System.out.println(mostCommonWord("Bob", new String[]{}));
        System.out.println(mostCommonWord("Bob. hIt, baLl", new String[]{"bob","hit"}));
    }
}

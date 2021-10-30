package com.yezhibo.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 2042.检查橘子中的数字是否递增
 * https://leetcode-cn.com/problems/check-if-numbers-are-ascending-in-a-sentence/
 */
public class CheckIsIncrSentence {
    public boolean areNumbersAscending(String s) {
        String[] words = s.split(" ");
        List<Integer> nums = new ArrayList<>();
        for (String str : words) {
            if (Character.isDigit(str.charAt(0))) {
                nums.add(Integer.valueOf(str));
            }
        }
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i-1)>=nums.get(i)) {
                return false;
            }
        }
        return true;
    }
}

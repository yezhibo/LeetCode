package com.yezhibo.leetcode.stack;

import org.junit.Test;

import java.util.Stack;

/**
 * 1190.反转每对括号间的子串
 * https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses/
 *
 * 题目描述：
 * 给出一个字符串s（仅含有小写英文字母和括号）。
 *
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 *
 * 注意，您的结果中 不应 包含任何括号。
 *
 * 解题思路：
 * 对于括号序列相关的题目通用解法是使用递归或着栈
 *
 * 题目中要每个括号中的字符均反转，那么就可以定义一个栈
 * 存储括号左侧的字符串，再定义一个字符串存储最终结果
 * 从左往右遍历输入字符串
 * 每遇到一个左括号就把当前拿到的字符入栈，并清空
 * 每遇到一个有括号就把当前拿到的字符串反转，并弹出栈中的字符串拼接在当前字符串首部，待遇到下一个右括号时继续反转。
 */
public class ReverseParentheses {
    public String reverseParentheses(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        char[] input = s.toCharArray();
        for (char c : input) {
            if (c == '(') {
                stack.push(result.toString());
                result.setLength(0);
                continue;
            }
            if (c == ')') {
                result.reverse();
                result.insert(0, stack.pop());
                continue;
            }
            if (Character.isLetter(c)) {
                result.append(c);
            }
        }
        return result.toString();
    }

    @Test
    public void test() {
        System.out.println(reverseParentheses("(abcd)"));
        System.out.println(reverseParentheses("(u(love)i)"));
    }
}

package com.yezhibo.leetcode.string;

import org.junit.Test;

import java.util.Stack;

/**
 * 面试题16.26 计算器
 * https://leetcode-cn.com/problems/calculator-lcci/
 *
 * 题目描述：
 *
 * 给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。
 *
 * 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 *
 * 解题思路：
 *
 */
public class Caculate {
    public static int calculate(String s) {
        char[] input = s.replace(" ", "").toCharArray();
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i<input.length) {
            char tmp = input[i];
            if (tmp=='+' || tmp=='-' || tmp=='*' || tmp=='/'){
                i++;
            }
            int num = 0;
            while (i < input.length && Character.isDigit(input[i])) {
                num = num*10 + input[i] - '0';
                i++;
            }
            switch (tmp) {
                case '-':
                    num = -num;
                    break;
                case '*':
                    num = stack.pop()*num;
                    break;
                case '/':
                    num = stack.pop()/num;
                    break;
                default:
                    break;
            }
            stack.push(num);
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

    @Test
    public void test() {
        String input1 = "3 + 12 *2-10/2+5*3";
        System.out.println(calculate(input1));
    }
}

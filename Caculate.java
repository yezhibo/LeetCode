package com.yezhibo.leetcode;

import java.util.Stack;

/**
 * 计算器
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

    public static void main(String[] args) {
        String input1 = "3 + 12 *2-10/2+5*3";
        System.out.println(calculate(input1));
    }
}

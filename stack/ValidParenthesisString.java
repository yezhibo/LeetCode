package com.yezhibo.leetcode.stack;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 678.有效的括号字符串
 * https://leetcode-cn.com/problems/valid-parenthesis-string/
 *
 * 题目描述：
 * 给定一个只包含三种字符的字符串:( ) 和 *，写一个函数来检验这个字符串是否为
 * 有效字符串，有效字符串具有如下规则：
 * 1、任何左括号必须有相应的右括号
 * 2、任何右括号必须有相应的左括号
 * 3、左括号必须在右括号之前
 * 4、*可以被看作任意括号，或者空串
 * 5、一个空串也可被时为有效字符串
 *
 *
 * 解题思路：
 * 采用两个栈来分别存储左括号和*，来右括号时就抵消对应左括号
 * 注意题目要求左括号必须在右括号之前，因此需要分先后顺序
 * 当*用作右括号时，坐标必须在左括号之后
 */
public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack1.push(i);
                continue;
            }
            if (c == '*') {
                stack2.push(i);
                continue;
            }
            if (!stack1.isEmpty()) {
                stack1.pop();
                continue;
            }
            if (!stack2.isEmpty()) {
                stack2.pop();
                continue;
            }
            return false;
        }
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int index1 = stack1.pop();
            int index2 = stack2.pop();
            if (index1 > index2) {
                return false;
            }
        }
        return stack1.isEmpty();
    }

    @Test
    public void test() {
        /*System.out.println(checkValidString("()"));
        System.out.println(checkValidString("(*)"));
        System.out.println(checkValidString("(*))"));*/
        // System.out.println(checkValidString("((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()"));
        System.out.println(checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));
    }
}

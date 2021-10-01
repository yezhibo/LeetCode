package com.yezhibo.leetcode.stack;

import org.junit.Test;

import java.util.LinkedList;

/**
 * 155.最小栈
 * https://leetcode-cn.com/problems/min-stack/
 *
 * 题目描述：
 * 设计一个支持push，pop，top，操作，并在常数时间内能检测到最小元素的栈。
 * 1、push(x) //将元素x入栈中
 * 2、pop() //删除栈顶元素
 * 3、top() //获取栈顶元素
 * 4、getMin() //检测栈中的最小元素
 *
 * 解题思路：
 * 题目中未限制数据结构，因此可以使用java的类库来实现 入栈、出栈、和查看栈顶元素操作
 * 对于在常数时间内获取到栈中最小元素
 * 由于栈中元素涉及出栈操作，因此需要维护每个元素对应的最小值
 *
 * 采用辅助栈，来存储每个元素对应的最小元素，每当有元素出栈时，相应的把最小元素也出栈
 *
 */
public class MinStack {
    private final LinkedList<Integer> stack;
    private final LinkedList<Integer> minStack;

    /**
     * 初始化
     */
    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    /**
     * 入栈
     *
     * @param val value
     */
    public void push(int val) {
        stack.push(val);
        minStack.push(Math.min(val, minStack.isEmpty() ? val : minStack.peek()));
    }

    /**
     * 弹出栈顶元素
     */
    public void pop() {
        stack.pop();
        minStack.pop();
    }

    /**
     * 查看栈顶元素
     *
     * @return 栈顶元素
     */
    public int top() {
        return stack.peek();
    }

    /**
     * 获取最小元素
     *
     * @return 最小元素
     */
    public int getMin() {
        return minStack.peek();
    }

    @Test
    public void test() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}

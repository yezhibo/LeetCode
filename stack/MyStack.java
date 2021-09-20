package com.yezhibo.leetcode.stack;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225.用队列实现栈
 * https://leetcode-cn.com/problems/implement-stack-using-queues/
 *
 * 题目描述：
 * 请你仅使用两个队列实现一个后入先出的栈，并支持普通栈的全部4中操作：
 *
 * 1、void push(int x) // 将元素x压入栈顶
 * 2、int pop() // 移除并返回栈顶元素
 * 3、int pop() // 返回栈顶元素
 * 4、boolean empty() // 判断栈是否为空
 *
 * 解题思路：
 * 为了满足栈的特性，即最后入栈的元素最先出栈，采用辅助队列形式：
 * 入栈是先将元素入queue2，然后再将queue1的所有元素入queue2
 */
public class MyStack {
    /**
     * 存储栈内元素
     */
    Queue<Integer> queue1;
    /**
     * 用于入栈时倒换元素位置
     */
    Queue<Integer> queue2;

    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        Queue<Integer> tmp = queue2;
        queue2 = queue1;
        queue1 = tmp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue1.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }

    @Test
    public void test() {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }
}

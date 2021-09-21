package com.yezhibo.leetcode.queue;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * 703.数据流中的第K大元素
 * https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/
 *
 * 题目描述：
 * 设计一个找到数据流中第K大元素的类。注意是排序后的第K大元素，不是第k个不同的元素
 *
 * 解题思路：
 * 优先级队列
 */
public class KthLargest {
    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<Integer>();
        for (int x : nums) {
            add(x);
        }
    }

    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }

    @Test
    public void test() {

    }

    public static void main(String[] args) {
        /*KthLargest kthLargest = new KthLargest(3, new int[]{4,5,8,2});
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));*/

        /*KthLargest kthLargest = new KthLargest(1, new int[]{});
        System.out.println(kthLargest.add(-3));
        System.out.println(kthLargest.add(-2));
        System.out.println(kthLargest.add(-4));
        System.out.println(kthLargest.add(0));
        System.out.println(kthLargest.add(4));*/

        /*KthLargest kthLargest = new KthLargest(2, new int[]{0});
        System.out.println(kthLargest.add(-1));
        System.out.println(kthLargest.add(1));
        System.out.println(kthLargest.add(-2));
        System.out.println(kthLargest.add(-4));
        System.out.println(kthLargest.add(3));*/

        KthLargest kthLargest = new KthLargest(3, new int[]{5,-1});
        System.out.println(kthLargest.add(2));
        System.out.println(kthLargest.add(1));
        System.out.println(kthLargest.add(-1));
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(4));
    }
}

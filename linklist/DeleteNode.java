package com.yezhibo.leetcode.linklist;

import org.junit.Test;

/**
 * 建信01.间隔删除链表节点
 * https://leetcode-cn.com/contest/ccbft-2021fall/problems/woGGnF/
 *
 */
public class DeleteNode {
    public ListNode deleteListNode(ListNode head) {
        ListNode header = new ListNode(-1);
        header.next = head;
        ListNode node = head;
        while (node != null) {
            if (node.next != null) {
                node.next = node.next.next;
            }
            node = node.next;
        }
        return header.next;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        /*head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);*/
        System.out.println(deleteListNode(head).val);
    }
}

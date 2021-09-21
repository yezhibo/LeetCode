package com.yezhibo.leetcode.linklist;

/**
 * 707.设计链表
 * https://leetcode-cn.com/problems/design-linked-list/
 *
 * 题目描述：
 * 设计一个单链表
 *
 * 解题思路：
 *
 *
 */
public class MyLinkedList {
    int size;
    ListNode head;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.size = 0;
        this.head = new ListNode(0);
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0|| size <= index) {
            return -1;
        }
        ListNode currNode = head;
        int curIndex = 0;
        while (curIndex < index+1) {
            curIndex++;
            currNode = currNode.next;
        }
        return currNode.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        node.next = head.next;
        head.next = node;
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (size < index) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        ListNode node = new ListNode(val);
        int curIndex = 0;
        ListNode curNode = head;
        while (curIndex < index) {
            curIndex ++;
            curNode = curNode.next;
        }
        node.next = curNode.next;
        curNode.next = node;
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || size <= index) {
            return;
        }
        ListNode curNode = head;
        int curIndex = 0;
        while (curIndex < index) {
            curIndex++;
            curNode = curNode.next;
        }
        curNode.next = curNode.next.next;
        size--;
    }
}

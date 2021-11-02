package com.yezhibo.leetcode.linklist;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 2058.找出临界点之间的最小和最大距离
 * https://leetcode-cn.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/
 *
 */
public class NodesBtCritialPoints {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] result = new int[]{-1,-1};
        LinkedList<Integer> targetNodeIndex = new LinkedList<>();
        int index = 1;
        ListNode node = head.next;
        int preVal = head.val;
        int min = 100005;
        while (node.next != null) {
            int val = node.val;
            int nextVal = node.next.val;
            if ((val < preVal && val < nextVal) || (val > preVal && val > nextVal)) {
                if (targetNodeIndex.size() > 0) {
                    min = Math.min(min, index - targetNodeIndex.getLast());
                }
                targetNodeIndex.add(index);
            }
            index++;
            preVal = val;
            node = node.next;
        }
        if (targetNodeIndex.size() > 1) {
            result[0] = min;
            result[1] = targetNodeIndex.getLast() - targetNodeIndex.getFirst();
        }
        return result;
    }

    @Test
    public void test() {
        /*ListNode head = new ListNode(5);
        head.next = new ListNode(3);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next = new ListNode(2);
        System.out.println(Arrays.toString(nodesBetweenCriticalPoints(head)));*/

        ListNode head1 = new ListNode(2);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(2);
        System.out.println(Arrays.toString(nodesBetweenCriticalPoints(head1)));
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        System.out.println(list.getLast());
    }
}

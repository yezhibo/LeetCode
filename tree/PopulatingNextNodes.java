package com.yezhibo.leetcode.tree;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 116.填充每个节点的下一个右侧节点指针
 *
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 *
 *
 */
public class PopulatingNextNodes {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node pre = queue.poll();
                if (i < size - 1) {
                    pre.next = queue.peek();
                }
                push(pre.left, queue);
                push(pre.right, queue);
            }
        }
        return root;
    }

    private void push(Node node, Queue<Node> queue) {
        if (node != null) {
            queue.add(node);
        }
    }

    @Test
    public void test() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        connect(root);
    }
}

package com.yezhibo.leetcode.tree;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111.二叉树的最小深度
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * <p>
 * 题目描述：给定一个二叉树，找出其最小深度
 */
public class MinDepthOfBT {
    int min = 0;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int i = 0;
            for (; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    break;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            min++;
            if (i != size) {
                break;
            }
        }
        return min;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(minDepth(root));
    }
}

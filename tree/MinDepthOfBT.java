package com.yezhibo.leetcode.tree;

import java.util.Stack;

/**
 * 111.二叉树的最小深度
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * <p>
 * 题目描述：给定一个二叉树，找出其最小深度
 */
public class MinDepthOfBT {
    int min = 0;

    public int minDepth(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

        }
        return min;
    }
}

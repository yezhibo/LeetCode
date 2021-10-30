package com.yezhibo.leetcode.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 114.二叉树展开为链表
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 *
 * 题目描述：给定一个二叉树根节点，请你按照先序遍历的顺序将该二叉树展开为一个单链表
 *
 */
public class FlattenBT2List {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> result = new ArrayList<>();
        dfs(root, result);
        for (int i = 1; i < result.size(); i++) {
            TreeNode pre = result.get(i - 1);
            TreeNode cur = result.get(i);
            pre.left = null;
            pre.right = cur;
        }
    }

    public void dfs(TreeNode node, List<TreeNode> result) {
        if (node == null) {
            return;
        }
        result.add(node);
        dfs(node.left, result);
        dfs(node.right, result);
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        flatten(root);
        System.out.println(root);
    }
}

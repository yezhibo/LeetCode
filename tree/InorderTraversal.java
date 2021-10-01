package com.yezhibo.leetcode.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 94.二叉树的中序遍历
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 *
 * 题目描述：
 * 给定一个二叉树的根节点root，返回它的中序遍历。
 *
 * 解题思路：
 * 中序遍历：左 -> 根 -> 右
 * 利用递归，先遍历左子树，再添加根节点值，再遍历右子树
 *
 */
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        return res;
    }

    private void inOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
    }

    @Test
    public void test() {
        TreeNode right = new TreeNode(2, new TreeNode(3), null);
        TreeNode root = new TreeNode(1, null, right);
        System.out.println(Arrays.toString(inorderTraversal(root).toArray()));
    }
}

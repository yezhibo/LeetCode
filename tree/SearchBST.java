package com.yezhibo.leetcode.tree;

/**
 * 700.二叉树中的搜索
 * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 *
 * 题目描述：
 * 给定二叉搜索树（BST）的根节点和一个值。你需要在BST中找到节点值等于给定值的节点
 * 返回以该节点为根的树。如果节点不存在，则返回null;
 *
 * 解题思路：
 *
 */
public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (val == root.val) {
            return root;
        } else if (val > root.val) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }
}

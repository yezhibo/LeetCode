package com.yezhibo.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 99.恢复二叉搜索树
 * https://leetcode-cn.com/problems/recover-binary-search-tree/
 *
 * 题目描述：
 * 给你二叉搜索树的根节点root，该树中的两个节点被错误的交换。请在不改变其结构的情况下
 * 恢复这棵树。
 *
 * 解题思路：
 * 二叉搜索树特点：左子树上所有节点值均小于根节点，右子树所有节点值大于根节点
 *
 * 采用中序遍历二叉树，得到的序列正常是有序的
 * 找出序列中乱序的两个值，然后交换即可
 *
 *  1，2，3，4，5，6，7，8，9
 *
 *  1，2，5，4，3，6，7，8，9
 *
 *  从左到右遍历序列，如果
 */
public class RecoverBFS {
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        bfs(root, list);
        TreeNode node1 = null;
        TreeNode node2 = null;
        for (int i = 1; i< list.size(); i++) {
            TreeNode nodePre = list.get(i-1);
            TreeNode node = list.get(i);
            if (nodePre.val > node.val) {
                node1 = node;
                if (node2 == null) {
                    node2 = nodePre;
                }
            }
        }
        if (node1 != null) {
            int tmp = node1.val;
            node1.val = node2.val;
            node2.val = tmp;
        }
    }

    public void bfs(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        bfs(node.left, list);
        list.add(node);
        bfs(node.right, list);
    }
}

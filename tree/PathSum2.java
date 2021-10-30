package com.yezhibo.leetcode.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 113.路径总合2
 * https://leetcode-cn.com/problems/path-sum-ii/
 *
 * 题目描述：
 * 给定一个二叉树，找出二叉树中根节点到叶子结点路径和等于给定值的所有路径
 */
public class PathSum2 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        LinkedList<Integer> list = new LinkedList<>();
        dfs(root, list, targetSum);
        return result;
    }

    private void dfs(TreeNode node, LinkedList<Integer> list, int sum) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        if (node.left == null && node.right == null && node.val == sum) {
            result.add(new ArrayList<>(list));
            list.removeLast();
            return;
        }
        dfs(node.left, list,sum - node.val);
        dfs(node.right, list,sum - node.val);
        list.removeLast();
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        System.out.println(Arrays.toString(pathSum(root,22).toArray()));
    }
}

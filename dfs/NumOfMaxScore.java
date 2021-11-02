package com.yezhibo.leetcode.dfs;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2049.统计最高分节点数目
 * https://leetcode-cn.com/problems/count-nodes-with-the-highest-score/
 * <p>
 * 解题思路：
 * 1、统计出每个节点的子节点
 * 2、利用dfs计算出每个节点的子节点大小
 * 3、计算出所有点的分数，并找出分数最大的点的数量
 */
public class NumOfMaxScore {
    Map<Integer, List<Integer>> node2SubNodes = new HashMap<>();
    int[] count;

    public int countHighestScoreNodes(int[] parents) {
        count = new int[parents.length];
        initNode(parents);
        dfs(0);
        return getMaxScoreNum(parents);
    }

    private int getMaxScoreNum(int[] parents) {
        long maxScore = getSubNodeScore(node2SubNodes.get(0));
        int num = 1;
        for (int i = 1; i < parents.length; i++) {
            long score = (count[0] - count[i]) * getSubNodeScore(node2SubNodes.get(i));
            if (score > maxScore) {
                maxScore = score;
                num = 1;
                System.out.println("max node num: " + i);
            } else if (score == maxScore) {
                num++;
            }
        }
        System.out.println("max scores: " + maxScore);
        return num;
    }

    private long getSubNodeScore(List<Integer> subNodes) {
        if (subNodes == null || subNodes.isEmpty()) {
            return 1;
        }
        long sum = 1;
        for (Integer subNode : subNodes) {
            sum *= count[subNode];
        }
        return sum;
    }

    private void initNode(int[] parents) {
        for (int i = 1; i < parents.length; i++) {
            node2SubNodes.computeIfAbsent(parents[i], key -> new ArrayList<>()).add(i);
        }
    }

    private int dfs(int node) {
        count[node]++;
        List<Integer> subNodes = node2SubNodes.getOrDefault(node, new ArrayList<>());
        if (subNodes.isEmpty()) {
            return count[node];
        }
        for (Integer subNode : subNodes) {
            count[node] += dfs(subNode);
        }
        return count[node];
    }
}

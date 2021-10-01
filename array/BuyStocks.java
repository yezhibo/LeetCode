package com.yezhibo.leetcode.array;

import org.junit.Test;

/**
 * 122. 买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 * 题目描述：
 * 给定一个数组prices，其中prices[i]是一支股票第i天的价格
 * 设计一个算法来计算你能获取的最大利润。你可以尽可能地完成更多的交易（多买卖一支股票）
 *
 * 解题思路：
 * 由于股票的购买没有限制，因此问题等价于寻找x个不相交的区间（li,ri],使得如下的等式最大化(i=1,...,x)
 * {（a[ri]-a[li]）}
 * li表示在li天买入，ri表示在ri天卖出
 * 其中a[ri]-a[li]等价于（li,li+1],(li+1,li+2],...,(ri-1,ri]这若干个长度为1的区间价值和
 *
 * 因此问题可简化为寻找x个长度为1的区间，使得价值最大化，也即求出所有递增的区间递增和
 *
 */
public class BuyStocks {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            ans += Math.max(0, prices[i] - prices[i-1]);
        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
}

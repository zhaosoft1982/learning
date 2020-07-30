package com.zhaosoft.example.exam101_150.exam122;

/**
 * 优化后的波峰波谷法
 */
public class Solution_2 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxProfit += prices[i] - prices[i - 1];
        }
        return maxProfit;
    }
}

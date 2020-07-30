package com.zhaosoft.example.exam101_150.exam122;

/**
 * 动态规划
 */
public class Solution_dp {
    public int maxProfit1(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        // 0：持有现金
        // 1：持有股票
        // 状态转移：0 → 1 → 0 → 1 → 0 → 1 → 0
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            // 这两行调换顺序也是可以的
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);

        }
        return dp[len - 1][0];
    }

    public int macProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int cash = 0;
        int hold = -prices[0];

        int preCash = cash;
        int preHold = hold;

        for (int i = 1; i < len; i++) {
            cash = Math.max(preCash, preHold + prices[i]);
            hold = Math.max(hold, preCash - prices[i]);

            preCash = cash;
            preHold = hold;
        }
        return cash;
    }
}

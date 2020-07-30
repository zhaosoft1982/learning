package com.zhaosoft.example.exam101_150.exam122;

/**
 * 暴力搜索
 */
public class Solution_3 {
    private int result;

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        this.result = 0;
        dfs(prices, 0, len, 0, result);
        return this.result;
    }

    /**
     * @param prices 股价数组
     * @param index  当前是第几天，从 0 开始
     * @param
     * @param status 0 表示不持有股票，1表示持有股票，
     * @param profit 当前收益
     */
    private void dfs(int[] prices, int index, int len, int status, int profit) {
        if (index == len) {
            this.result = Math.max(this.result, profit);
            return;
        }
        dfs(prices, index + 1, len, status, profit);
        if (status == 0) {
            // 可以尝试转向 1
            dfs(prices, index + 1, len, 1, profit - prices[index]);

        } else {
            // 此时 status == 1，可以尝试转向 0
            dfs(prices, index + 1, len, 0, profit + prices[index]);
        }
    }
}

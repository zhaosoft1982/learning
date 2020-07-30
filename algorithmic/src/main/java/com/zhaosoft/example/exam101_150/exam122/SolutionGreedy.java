package com.zhaosoft.example.exam101_150.exam122;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 */
public class SolutionGreedy {


    /**
     * [7,1,5,3,6,4]
     * 贪心算法解决问题
     *
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int currentValue = 0;
        if (prices != null && prices.length > 0) {
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] < prices[i - 1]) {
                    currentValue = prices[i] - prices[i - 1] + currentValue;
                }

            }
        }
        return currentValue;
    }

    public int macProfit(int[] prices) {
        int res = 0;
        int len = prices.length;
        for (int i = 0; i < len - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                res = res + (prices[i + 1] - prices[i]);
            }
        }
        return res;
    }

    public int maxProfit2(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            sum = prices[i] > prices[i - 1] ? sum + prices[i] - prices[i - 1] : sum;
        }
        return sum;
    }
}

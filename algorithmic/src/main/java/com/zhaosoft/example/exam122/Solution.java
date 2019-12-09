package com.zhaosoft.example.exam122;

/**
 *
 */
public class Solution {


    /**
     * [7,1,5,3,6,4]
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int currentValue=0;
         if(prices!=null && prices.length>0){
             for(int i=1;i<prices.length;i++){
                 if(prices[i]<prices[i-1]){
                     currentValue=prices[i]-prices[i-1]+currentValue;
                 }

             }
         }
         return currentValue;
    }

    public int maxProfit2(int[] prices) {
        int sum = 0;
        for(int i=1;i<prices.length;i++){
            sum = prices[i]>prices[i-1]?sum+prices[i]-prices[i-1]:sum;
        }
        return sum;
    }
}

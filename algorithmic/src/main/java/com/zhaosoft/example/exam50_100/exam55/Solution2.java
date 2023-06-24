package com.zhaosoft.example.exam50_100.exam55;

public class Solution2 {
    /**
     * 动态规划
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        if (nums[0] == 0) {
            return false;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + i);
            if (dp[i] >= nums.length - 1) {
                return true;
            }
            if (dp[i] == i) {
                return false;
            }
        }
        return true;
    }
}
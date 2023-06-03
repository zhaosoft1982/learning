package com.zhaosoft.example.exam152;

/**
 * 152. 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * 测试用例的答案是一个 32-位 整数。
 * 子数组 是数组的连续子序列。
 */
public class Solution {
    /**
     * 动态规划
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int[] max = new int[n];
        max[0] = nums[0];
        int[] min = new int[n];
        min[0] = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            max[i] = Math.max(min[i - 1] * nums[i], Math.max(max[i - 1] * nums[i], nums[i]));
            min[i] = Math.min(min[i - 1] * nums[i], Math.min(max[i - 1] * nums[i], nums[i]));
            res = Math.max(res, max[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.print(min[i] + " ");
        }
        System.out.println("");
        for (int i = 0; i < nums.length; i++) {

            System.out.print(max[i] + " ");

        }
        System.out.println("");
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{3, 5, 6, -2, 4, -3, -2};
        System.out.println(s.maxProduct(nums));
    }
}

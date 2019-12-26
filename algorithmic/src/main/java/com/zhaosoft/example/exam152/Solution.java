package com.zhaosoft.example.exam152;

public class Solution {
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
            max[i] = Math.max(min[i - 1] * nums[i],Math.max(max[i - 1] * nums[i],nums[i]));
            min[i] = Math.min(min[i - 1] * nums[i],Math.min(max[i - 1] * nums[i],nums[i]));
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

    public int maxProduct2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = nums[0];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                max[i] = Math.max(nums[i], nums[i] * max[i - 1]);
                min[i] = Math.min(nums[i], nums[i] * min[i - 1]);
            } else {
                max[i] = Math.max(nums[i], nums[i] * min[i - 1]);
                min[i] = Math.min(nums[i], nums[i] * max[i - 1]);
            }
        }
        int imax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (max[i] > imax) {
                imax = max[i];
            }
        }
        return imax;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{3, 5, 6, -2, 4, -3,-2};
        System.out.println(s.maxProduct2(nums));
    }
}

package com.zhaosoft.example.exam1_50.exam26;

public class Solution2 {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        Solution2 solution = new Solution2();
        solution.removeDuplicates(nums);
    }
}
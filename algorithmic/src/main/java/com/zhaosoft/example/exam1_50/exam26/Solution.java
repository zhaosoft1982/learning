package com.zhaosoft.example.exam1_50.exam26;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int p1 = 0;
        for (int p2 = 1; p2 < nums.length; p2++) {
            if (nums[p2] != nums[p1]) {
                p1++;
                nums[p1] = nums[p2];
            }
        }
        return p1+1;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        Solution solution = new Solution();
        solution.removeDuplicates(nums);
    }
}

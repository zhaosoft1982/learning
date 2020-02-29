package com.zhaosoft.example.exam1_50.exam35;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 输入: [1,3,5,6], 5
 * 输出: 2
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length-1;
        while (left < right) {
            int mid = (right + left) >>> 1;
            if (target > nums[mid]) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3, 5, 6};
        Solution solution8 = new Solution();
        int lengthOfLIS = solution8.searchInsert(nums, 5);
        System.out.println("顺序插入的位置：" + lengthOfLIS);
    }
}

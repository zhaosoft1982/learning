package com.zhaosoft.example.array.exam35;

/**
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 输入: [1,3,5,6], 5
 * 输出: 2
 */
public class Solution2 {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return right + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        Solution2 solution8 = new Solution2();
        int lengthOfLIS = solution8.searchInsert(nums, 5);
        System.out.println("顺序插入的位置：" + lengthOfLIS);
    }
}

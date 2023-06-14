package com.zhaosoft.example.array.exam704;

/**
 * 704. 二分查找
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 */
public class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            //防止(right + left)溢出
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 5, 6, 7, 12};
        Solution solution8 = new Solution();
        int lengthOfLIS = solution8.search(nums, 6);
        System.out.println("最长上升子序列的长度：" + lengthOfLIS);
        lengthOfLIS = solution8.search(nums, 8);
        System.out.println("最长上升子序列的长度：" + lengthOfLIS);
    }
}

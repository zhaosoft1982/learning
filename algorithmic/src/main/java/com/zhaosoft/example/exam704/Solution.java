package com.zhaosoft.example.exam704;

public class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (right + left) >>> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[left] == target) {
            return left;
        } else {
            return -1;
        }
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

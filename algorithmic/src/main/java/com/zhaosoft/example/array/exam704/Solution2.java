package com.zhaosoft.example.array.exam704;

public class Solution2 {
    public int search(int[] nums, int target) {
        // 避免当 target 小于nums[0] nums[nums.length - 1]时多次循环运算
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1; // 定义target在左闭右闭的区间里，[left, right]
        while (left <= right) {// 当left==right，区间[left, right]依然有效，所以用 <=
            // 防止溢出 等同于(left + right)/2
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) { // target 在左区间，所以[left, middle - 1]
                right = mid - 1;
            } else if (nums[mid] < target) { // target 在右区间，所以[middle + 1, right]
                left = mid + 1;
            } else {
                return mid;// 数组中找到目标值，直接返回下标
            }
        }
        return -1;
    }
}
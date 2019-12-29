package com.zhaosoft.example.exam300;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] res = new int[nums.length];
        int end = 0;
        res[end] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            if (res[end] < cur) {
                end++;
                res[end] = cur;
            } else {
                int right = end;
                int left = 0;
                while (left < right) {
                    int mid = (right + left) >>> 1;
                    if (res[mid] < cur) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                res[left] = cur;
            }

        }
        end++;
        return end;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12};
        Solution solution8 = new Solution();
        int lengthOfLIS = solution8.lengthOfLIS(nums);
        System.out.println("最长上升子序列的长度：" + lengthOfLIS);
    }

}

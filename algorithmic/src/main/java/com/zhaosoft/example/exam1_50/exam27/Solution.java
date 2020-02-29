package com.zhaosoft.example.exam1_50.exam27;

public class Solution {
    public int removeElement(int[] nums, int val) {
        //首先对数组排序
        //Arrays.sort(nums);
        int p1 = 0;
        int p2 = 0;
        while (p2 < nums.length) {
            if (nums[p2] != val) {
                nums[p1] = nums[p2];
                p1 = p1 + 1;
                p2 = p2 + 1;
            }else{
                p2 = p2 + 1;
            }
        }
        return nums.length-(p2-p1);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1,3, 1, 2, 5, 3, 3, 4};
        Solution solution = new Solution();
        System.out.println(solution.removeElement(nums,3));
    }
}

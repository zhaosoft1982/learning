package com.zhaosoft.example.exam27;

public class Solution2 {
    public int removeElement(int[] nums, int val) {
        int ans = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[ans] = nums[j];
                ans++;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 3, 1, 2, 5, 3, 3, 4};
        Solution2 solution = new Solution2();
        System.out.println(solution.removeElement(nums, 3));
    }
}

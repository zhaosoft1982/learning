package com.zhaosoft.example.exam300;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 *
 * 时间复杂度：O(n^2)O(n2)。有两个 nn 的循环。
 * 空间复杂度：O(n)O(n)，用了大小为 nn 的矩阵 dp。
 */
public class Solution1 {

    public int lengthOfLIS(int[] nums) {
        if(nums.length==0){
            return 0;
        }

        int[] dp =new int[nums.length];
        dp[0]=1;
        int maxRes=1;
        for(int i=1;i<nums.length;i++){
            int maxVal=0;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    maxVal=Math.max(maxVal,dp[j]);
                }
            }
            dp[i]=maxVal+1;
            maxRes=Math.max(maxRes,dp[i]);
        }
        return maxRes;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12};
        Solution1 solution8 = new Solution1();
        int lengthOfLIS = solution8.lengthOfLIS(nums);
        System.out.println("最长上升子序列的长度：" + lengthOfLIS);
    }
}

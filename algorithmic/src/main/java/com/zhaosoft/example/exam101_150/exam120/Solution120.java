package com.zhaosoft.example.exam101_150.exam120;

import java.util.List;

public class Solution120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0 || triangle.get(0).size() == 0) {
            return 0;
        }
        //倒序往上走
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = triangle.get(i).size() - 1; j >= 0; j--) {
                // DP formula
                int min = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
                min = min + triangle.get(i).get(j);
                triangle.get(i).set(j, min);

            }
        }
        return triangle.get(0).get(0);
    }

    public int minimumTotal_1(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0 | triangle.get(0).size() == 0) {
            return 0;
        }

        int[][] dp = new int[triangle.size() + 1][triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];

    }

    public int minimumTotal_2(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0 | triangle.get(0).size() == 0) {
            return 0;
        }
        // dp中记录了求第i行时，第i+1的最小路径和
        int[] dp = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    public int minimumTotal_3(List<List<Integer>> triangle) {
        if (triangle.size() == 0 || triangle == null) return 0;
        int[] dp = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + list.get(j);
            }
        }
        return dp[0];
    }

}



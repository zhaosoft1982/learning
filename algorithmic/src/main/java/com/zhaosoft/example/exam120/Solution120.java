package com.zhaosoft.example.exam120;

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

}



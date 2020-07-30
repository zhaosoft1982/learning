package com.zhaosoft.example.exam101_150.exam120;

import java.util.List;

public class Solution_DFS {

    int minResult = Integer.MAX_VALUE;

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0 || triangle.get(0).size() == 0) {
            return 0;
        }

        _dfs(triangle, 0, 0, 0);
        return minResult;
    }

    private int _dfs(List<List<Integer>> triangle, int i, int j, int sum) {
        //终止
        if (i == triangle.size() - 1) {
            sum = sum + triangle.get(i).get(j);
            minResult = Math.min(minResult, sum);
            return sum;
        }
        //程序处理
        sum = sum + triangle.get(i).get(j);
        //向下钻取
        _dfs(triangle, i + 1, j, sum);
        _dfs(triangle, i + 1, j + 1, sum);
        //状态清楚
        return sum;
    }
}

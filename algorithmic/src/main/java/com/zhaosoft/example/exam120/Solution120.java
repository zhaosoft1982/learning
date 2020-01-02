package com.zhaosoft.example.exam120;

import java.util.Arrays;
import java.util.List;

public class Solution120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0 || triangle.get(0).size() == 0) {
            return 0;
        }
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
        if (triangle.size() == 0 || triangle.get(0).size() == 0) {
            return 0;
        }
        int min = _dfs(triangle, 0, 0, "", 0);
        return min;
    }

    private int _dfs(List<List<Integer>> triangle, int i, int j, String path, int sum) {
        //terminator
        if (i == triangle.size() - 1) {
            path = path + triangle.get(i).get(j) + " #";
            sum = sum + triangle.get(i).get(j);
            System.out.println(path + " with sum :" + sum);

            return sum;
        }
        //process
        path = path + triangle.get(i).get(j) + "->";
        sum = sum + triangle.get(i).get(j);
        //drill down
        _dfs(triangle, i + 1, j, path, sum);
        _dfs(triangle, i + 1, j + 1, path, sum);
        //clear states
        //NOTe :no need to clear the state "path"
        return sum;
    }

    public static void main(String[] args) {
        Solution120 solution120 = new Solution120();
        int result = solution120.minimumTotal(Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7),
                Arrays.asList(4, 1, 8, 3)
        ));
        System.out.println(result);
    }
}



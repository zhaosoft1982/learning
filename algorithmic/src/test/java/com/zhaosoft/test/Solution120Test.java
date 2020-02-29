package com.zhaosoft.test;

import com.zhaosoft.example.exam101_150.exam120.Solution120;
import com.zhaosoft.example.exam101_150.exam120.Solution_DFS;
import com.zhaosoft.example.exam101_150.exam120.Solution_DP;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Solution120Test {
    List<List<Integer>> triangle = Arrays.asList(
            Arrays.asList(2),
            Arrays.asList(3, 4),
            Arrays.asList(6, 5, 7),
            Arrays.asList(4, 1, 8, 3)
    );

    @Test
    public void test() {
        Solution_DP solution120 = new Solution_DP();
        int result = solution120.minimumTotal(triangle);
        Assert.assertEquals(11, result);
    }

    @Test
    public void test_dfs() {
        Solution_DFS solution120 = new Solution_DFS();
        int result = solution120.minimumTotal(triangle);
        Assert.assertEquals(11, result);
    }

    @Test
    public void test_dp() {
        Solution120 solution120 = new Solution120();
        int result = solution120.minimumTotal_1(triangle);
        Assert.assertEquals(11, result);
    }
    @Test
    public void test_dp_2() {
        Solution120 solution120 = new Solution120();
        int result = solution120.minimumTotal_2(triangle);
        Assert.assertEquals(11, result);
    }
}

package com.zhaosoft.test.exam122;

import com.zhaosoft.example.exam122.Solution_2;
import org.junit.Test;

public class SolutionTest_2 {
    @Test
    public void test(){
        int [] prices=new int[]{1, 7, 2, 3, 6, 7, 6, 7};
        Solution_2 solution_2=new Solution_2();
        System.out.println(solution_2.maxProfit(prices));
    }
}

package com.zhaosoft.test.exam860;

import com.zhaosoft.example.exam860.Solution;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void lemonadeChangeTest() {
        int[] bills = new int[]{5, 5, 5, 10, 20};
        Solution solution = new Solution();
        System.out.println(solution.lemonadeChange(bills));
    }
}

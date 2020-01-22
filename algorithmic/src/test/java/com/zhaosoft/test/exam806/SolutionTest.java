package com.zhaosoft.test.exam806;

import org.junit.Test;

public class SolutionTest {
    @Test
    public void lemonadeChangeTest(){
        int[] bills=new int[]{5,5,5,10,20};
        com.zhaosoft.test.example.exam806.Solution solution=new com.zhaosoft.test.example.exam806.Solution();
        System.out.println(solution.lemonadeChange(bills));
    }
}

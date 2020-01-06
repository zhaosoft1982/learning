package com.zhaosoft.exam212;

import com.zhaosoft.example.exam212.Solution212;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SolutionTest212 {
    @Test
    public void test0() {
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};

        Solution212 solution212 = new Solution212();
        List<String> res = solution212.findWords(board, words);
        System.out.println(res.toString());
        Assert.assertEquals(2, res.size());
    }
}

package com.zhaosoft.test;

import com.zhaosoft.example.TreeNode;
import com.zhaosoft.example.exam101_150.exam144.Solution_BFS;
import com.zhaosoft.example.exam101_150.exam144.Solution_DFS;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution144Test {
    TreeNode root = null;


    @Before
    public void init() {
        root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node2.left = new TreeNode(3);
        root.right = node2;
    }

    @Test
    public void test() {
        Solution_DFS solution = new Solution_DFS();
        List<Integer> s = new ArrayList<>();
        s.add(1);
        s.add(2);
        s.add(3);
        Assert.assertEquals(s, solution.preorderTraversal(root));
    }

    @Test
    public void test0() {
        Solution_BFS solution_bfs = new Solution_BFS();
        List<Integer> s = new ArrayList<>();
        s.add(1);
        s.add(2);
        s.add(3);
        Assert.assertEquals(s, solution_bfs.preorderTraversal(root));
    }
}

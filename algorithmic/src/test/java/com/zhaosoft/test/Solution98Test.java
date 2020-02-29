package com.zhaosoft.test;

import com.zhaosoft.example.exam50_100.exam98.Solution;
import com.zhaosoft.example.exam50_100.exam98.Solution_DFS;
import com.zhaosoft.example.exam50_100.TreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Solution98Test {
    TreeNode root = null;


    @Before
    public void init() {
        root = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        node3.left = new TreeNode(1);
        node3.right = new TreeNode(2);
        root.left = node3;
        TreeNode node4 = new TreeNode(4);
        root.right = node4;
        node4.left = new TreeNode(3);
        node4.right = new TreeNode(6);
    }

    @Test
    public void test() {

        Solution_DFS solutionDfs = new Solution_DFS();
        Assert.assertEquals(false, solutionDfs.isValidBST(root));
    }

    @Test
    public void test1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        Solution_DFS solutionDfs = new Solution_DFS();
        Assert.assertEquals(false, solutionDfs.isValidBST(root));
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        Assert.assertEquals(false, solution.isValidBST(root));

    }
}

package com.zhaosoft.test;

import com.zhaosoft.example.exam50_100.TreeNode;
import com.zhaosoft.example.exam50_100.exam94.Solution;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution94Test {
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
    public void test2() {
        Solution solution = new Solution();
        List<Integer> s = new ArrayList();
        s.add(1);
        s.add(3);
        s.add(2);
        s.add(5);
        s.add(3);
        s.add(4);
        s.add(6);
        Assert.assertEquals(s, solution.inorderTraversal(root));

    }
}

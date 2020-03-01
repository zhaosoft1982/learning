package com.zhaosoft.test;

import com.zhaosoft.example.TreeNode;
import com.zhaosoft.example.exam101_150.exam102.Solution_BFS;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution102Test {

    @Test
    public void test0() {
        Solution_BFS solution_bfs = new Solution_BFS();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        node20.left = new TreeNode(15);
        node20.right = new TreeNode(7);
        root.right = node20;
        List<List<Integer>> s = new ArrayList<>();
        s.add(new ArrayList<Integer>() {{
            add(3);
        }});
        s.add(new ArrayList<Integer>() {{
            add(9);
            add(20);
        }});
        s.add(new ArrayList<Integer>() {{
            add(15);
            add(7);
        }});

        Assert.assertEquals(s, solution_bfs.levelOrder(root));
    }
}

package com.zhaosoft.test;

import com.zhaosoft.example.TreeNode;
import com.zhaosoft.example.exam101_150.exam103.Solution_BFS;
import com.zhaosoft.example.exam101_150.exam103.Solution_DFS;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution103Test {
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
            add(20);
            add(9);
        }});
        s.add(new ArrayList<Integer>() {{
            add(15);
            add(7);
        }});

        Assert.assertEquals(s, solution_bfs.zigzagLevelOrder(root));
    }

    @Test
    public void test1() {
        Solution_BFS solution_bfs = new Solution_BFS();
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node2.left = new TreeNode(4);
        node3.right = new TreeNode(5);
        root.left = node2;
        root.right = node3;
        List<List<Integer>> s = new ArrayList<>();
        s.add(new ArrayList<Integer>() {{
            add(1);
        }});
        s.add(new ArrayList<Integer>() {{
            add(3);
            add(2);
        }});
        s.add(new ArrayList<Integer>() {{
            add(4);
            add(5);
        }});
        Assert.assertEquals(s, solution_bfs.zigzagLevelOrder(root));
    }

    @Test
    public void test2() {
        Solution_DFS solution_bfs = new Solution_DFS();
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
            add(20);
            add(9);
        }});
        s.add(new ArrayList<Integer>() {{
            add(15);
            add(7);
        }});

        Assert.assertEquals(s, solution_bfs.zigzagLevelOrder(root));
    }

    @Test
    public void test3() {
        Solution_DFS solution_bfs = new Solution_DFS();
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node2.left = new TreeNode(4);
        node3.right = new TreeNode(5);
        root.left = node2;
        root.right = node3;
        List<List<Integer>> s = new ArrayList<>();
        s.add(new ArrayList<Integer>() {{
            add(1);
        }});
        s.add(new ArrayList<Integer>() {{
            add(3);
            add(2);
        }});
        s.add(new ArrayList<Integer>() {{
            add(4);
            add(5);
        }});
        Assert.assertEquals(s, solution_bfs.zigzagLevelOrder(root));
    }
}

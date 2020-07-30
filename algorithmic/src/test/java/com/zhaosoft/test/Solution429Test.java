package com.zhaosoft.test;

import com.zhaosoft.example.exam401_500.exam429.Node;
import com.zhaosoft.example.exam401_500.exam429.Solution_BFS;
import com.zhaosoft.example.exam401_500.exam429.Solution_DFS;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution429Test {
    @Test
    public void test() {
        Node root = new Node(1);
        Node node3 = new Node(3);
        node3.children = new ArrayList<Node>() {{
            add(new Node(5));
            add(new Node(6));
        }};
        root.children = new ArrayList<Node>() {{
            add(node3);
            add(new Node(2));
            add(new Node(4));
        }};

        Solution_BFS solution = new Solution_BFS();
        List<List<Integer>> s = new ArrayList<>();
        s.add(new ArrayList<Integer>() {{
            add(1);
        }});
        s.add(new ArrayList<Integer>() {{
            add(3);
            add(2);
            add(4);
        }});
        s.add(new ArrayList<Integer>() {{
            add(5);
            add(6);
        }});
        Assert.assertEquals(s, solution.levelOrder(root));
    }

    @Test
    public void test0() {
        Node root = new Node(1);
        Node node3 = new Node(3);
        node3.children = new ArrayList<Node>() {{
            add(new Node(5));
            add(new Node(6));
        }};
        root.children = new ArrayList<Node>() {{
            add(node3);
            add(new Node(2));
            add(new Node(4));
        }};

        Solution_DFS solution = new Solution_DFS();
        List<List<Integer>> s = new ArrayList<>();
        s.add(new ArrayList<Integer>() {{
            add(1);
        }});
        s.add(new ArrayList<Integer>() {{
            add(3);
            add(2);
            add(4);
        }});
        s.add(new ArrayList<Integer>() {{
            add(5);
            add(6);
        }});
        Assert.assertEquals(s, solution.levelOrder(root));
    }
}

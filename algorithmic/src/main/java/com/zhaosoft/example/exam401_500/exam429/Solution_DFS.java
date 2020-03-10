package com.zhaosoft.example.exam401_500.exam429;

import java.util.ArrayList;
import java.util.List;

public class Solution_DFS {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        _dfs(root, 0, result);
        return result;
    }

    public void _dfs(Node root, int level, List<List<Integer>> result) {
        //终止条件
        if (root == null) {
            return;
        }
        if (level >= result.size()) {
            List<Integer> currentLevel = new ArrayList<>();
            currentLevel.add(root.val);
            result.add(currentLevel);
        } else {
            result.get(level).add(root.val);
        }
        if (root.children != null) {
            for (Node node : root.children) {
                _dfs(node, level + 1, result);
            }
        }
    }
}

package com.zhaosoft.example.exam101_150.exam103;

import com.zhaosoft.example.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution_DFS {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        _dfs(root, 0, resultList);
        return resultList;
    }

    private void _dfs(TreeNode root, int level, List<List<Integer>> results) {
        if (root == null) {
            return;
        }
        //新层级
        if (level >= results.size()) {
            LinkedList<Integer> newCurrentLeven = new LinkedList<>();
            newCurrentLeven.add(root.val);
            results.add(newCurrentLeven);
        } else {
            //根据层级判断正序倒序
            if (level % 2 == 0) {
                results.get(level).add(root.val);
            } else {
                results.get(level).add(0, root.val);
            }
        }
        _dfs(root.left, level + 1, results);
        _dfs(root.right, level + 1, results);
    }
}

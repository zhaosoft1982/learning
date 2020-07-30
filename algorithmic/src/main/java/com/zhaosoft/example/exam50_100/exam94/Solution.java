package com.zhaosoft.example.exam50_100.exam94;

import com.zhaosoft.example.exam50_100.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> resultList = new ArrayList<>();
        _dfs(root, resultList);
        return resultList;
    }

    private void _dfs(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        _dfs(root.left, result);
        Integer current = root.val;
        result.add(current);
        _dfs(root.right, result);
    }
}

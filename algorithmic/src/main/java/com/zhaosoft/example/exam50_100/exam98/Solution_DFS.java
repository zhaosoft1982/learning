package com.zhaosoft.example.exam50_100.exam98;

import com.zhaosoft.example.exam50_100.TreeNode;

public class Solution_DFS {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return _dfs(root, null, null);
    }

    private boolean _dfs(TreeNode node, Integer min, Integer max) {
        //终止条件
        if (node == null) {
            return true;
        }

        int current = node.val;
        if (min != null && current <= min) return false;
        if (max != null && current >= max) return false;

        if (!_dfs(node.right, current, max)) return false;
        if (!_dfs(node.left, min, current)) return false;

        return true;
    }
}

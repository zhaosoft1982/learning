package com.zhaosoft.example.exam101_150.exam144;

import com.zhaosoft.example.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的前序遍历
 * @author zhaosoft
 */
public class Solution_DFS {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        if (root == null) return resultList;
        _dsf(root, resultList);
        return resultList;
    }

    private void _dsf(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        _dsf(root.left, result);
        _dsf(root.right, result);
    }
}

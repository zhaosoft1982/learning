package com.zhaosoft.example.exam101_150.exam102;

import com.zhaosoft.example.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 102. 二叉树的层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * 广度优先搜索，遍历树节点
 */
public class Solution_BFS {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>(20);
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> currentLevel = new ArrayList<>();
            //获取队列长度
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.pop();
                currentLevel.add(node.val);
                //下层放入队列，从左到右遍历，先放左子节点
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            resultList.add(currentLevel);
        }
        return resultList;
    }
}

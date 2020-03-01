package com.zhaosoft.example.exam101_150.exam103;

import com.zhaosoft.example.TreeNode;

import java.util.*;

public class Solution_BFS {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flg = false;
        while (!queue.isEmpty()) {
            List<Integer> currentLevel = new ArrayList<>();
            //获取队列长度
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (flg) {
                Collections.reverse(currentLevel); // 倒序排列
                flg = false;
            } else {
                flg = true;
            }
            resultList.add(currentLevel);
        }
        return resultList;
    }
}

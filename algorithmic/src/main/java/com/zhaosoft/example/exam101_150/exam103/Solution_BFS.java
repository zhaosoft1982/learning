package com.zhaosoft.example.exam101_150.exam103;

import com.zhaosoft.example.TreeNode;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */
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
                // 倒序排列
                Collections.reverse(currentLevel);
                flg = false;
            } else {
                flg = true;
            }
            resultList.add(currentLevel);
        }
        return resultList;
    }
}

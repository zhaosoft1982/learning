package com.zhaosoft.example.exam101_150.exam103;

import com.zhaosoft.example.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 103. 二叉树的锯齿形层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flg = false;
        while (!queue.isEmpty()) {
            LinkedList<Integer> currentLevel = new LinkedList<>();
            //获取队列长度
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (flg) {
                    currentLevel.addFirst(node.val);
                } else {
                    currentLevel.addLast(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            flg = !flg;
            resultList.add(currentLevel);
        }
        return resultList;
    }
}
package com.zhaosoft.example.exam101_150.exam144;

import com.zhaosoft.example.TreeNode;
import com.zhaosoft.example.exam101_150.exam146.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution_BFS {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> tempStack = new Stack();
        List<Integer> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        tempStack.push(root);
        while (!tempStack.isEmpty()) {
            TreeNode temp = tempStack.pop();
            resultList.add(temp.val);
            if (temp.right != null) {
                tempStack.push(temp.right);
            }
            if (temp.left != null) {
                tempStack.push(temp.left);
            }
        }

        return resultList;
    }
}

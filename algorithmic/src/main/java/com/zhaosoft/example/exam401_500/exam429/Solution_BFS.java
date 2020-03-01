package com.zhaosoft.example.exam401_500.exam429;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution_BFS {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.push(root);
        while (queue.size() > 0) {
            List<Integer> currentLevel = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node currentNode = queue.poll();
                currentLevel.add(currentNode.val);
                // add child node to queue
                if (currentNode.children != null && currentNode.children.size() > 0) {
                    for (Node node : currentNode.children) {
                        queue.addLast(node);
                    }
                }
            }
            result.add(currentLevel);
        }
        return result;
    }
}

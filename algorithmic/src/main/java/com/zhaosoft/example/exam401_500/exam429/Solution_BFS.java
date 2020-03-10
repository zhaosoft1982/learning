package com.zhaosoft.example.exam401_500.exam429;

import java.util.*;

public class Solution_BFS {
    public List<List<Integer>> levelOrder0(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            List<Integer> currentLevel = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node currentNode = queue.poll();
                currentLevel.add(currentNode.val);
                // add child node to queue
                if (currentNode.children != null) {
                    queue.addAll(currentNode.children);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        List<Node> previousLayer = Arrays.asList(root);

        while (!previousLayer.isEmpty()) {
            List<Node> currentLayer = new ArrayList<>();
            List<Integer> previousVals = new ArrayList<>();
            for (Node node : previousLayer) {
                previousVals.add(node.val);
                currentLayer.addAll(node.children);
            }
            result.add(previousVals);
            previousLayer = currentLayer;
        }

        return result;
    }
}

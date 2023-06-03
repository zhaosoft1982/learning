package com.zhaosoft.example.exam101_150.exam138;

import java.util.HashMap;

public class Solution2 {
    private HashMap<Node, Node> visited = new HashMap();

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        if (visited.containsKey(head)) return visited.get(head);
        Node newNode = new Node(head.val, null, null);
        visited.put(head, newNode);
        newNode.next = copyRandomList(head.next);
        newNode.random = copyRandomList(head.random);
        return newNode;
    }
}
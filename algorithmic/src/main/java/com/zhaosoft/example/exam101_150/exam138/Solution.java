package com.zhaosoft.example.exam101_150.exam138;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    class Node {
        int val;
        Node next;
        Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    public Node copyRandomList0(Node node) {
        Map<Node, Node> map = new HashMap<>();
        if (node == null) {
            return null;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node newNode = new Node(node.val, null, null);
        map.put(node, newNode);
        copyRandomList0(node.next);
        copyRandomList0(node.random);
        return node;
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        if (head == null) {
            return null;
        }
        Node node = head;
        while (node != null) {
            map.put(node, new Node(node.val, null, null));
            node = node.next;
        }

        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }

        return map.get(head);
    }
}

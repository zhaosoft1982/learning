package com.zhaosoft.example.exam101_150.exam138;

/**
 * @author zhaoxiaolei
 */
public class Node {
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
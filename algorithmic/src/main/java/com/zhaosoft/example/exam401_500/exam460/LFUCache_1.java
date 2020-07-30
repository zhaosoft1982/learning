package com.zhaosoft.example.exam401_500.exam460;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache_1 {
    private Map<Integer, Node> cache;
    private Map<Integer, LinkedHashSet<Node>> seqMap = new HashMap<>();
    private int size;
    private int capacity;
    private int minSeq = 1;

    public LFUCache_1(int capacity) {
        cache = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        seqInc(node);
        return node.value;
    }

    public void seqInc(Node node) {
        int seq = node.seq;
        LinkedHashSet<Node> set = seqMap.get(seq);
        set.remove(node);
        if (minSeq == seq && set.size() == 0) {
            minSeq++;
        }
        node.seq++;
        LinkedHashSet newSet = seqMap.get(seq + 1);
        if (newSet == null) {
            newSet = new LinkedHashSet<>();
            seqMap.put(seq + 1, newSet);
        }
        newSet.add(node);

    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;//更新值数据
            seqInc(node);
        } else {
            if (size == capacity) { //数量等于容量，剔除数据
                Node deadNode = removeNode();
                cache.remove(deadNode.key);
                size--;
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addNode(node);
            size++;
        }
    }

    private Node removeNode() {
        LinkedHashSet<Node> set = seqMap.get(minSeq);
        Node deadNode = set.iterator().next();
        set.remove(deadNode);
        return deadNode;
    }

    private void addNode(Node node) {
        LinkedHashSet set = seqMap.get(1);
        if (set == null) {
            set = new LinkedHashSet();
            seqMap.put(1, set);

        }
        set.add(node);
        minSeq = 1;
    }

    class Node {
        int key;
        int value;
        int seq = 1;

        Node(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }
}

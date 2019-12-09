package com.zhaosoft.example.exam208;

public class TrieNode {
    public char val;
    public TrieNode[] child = new TrieNode[26];

    public TrieNode() {

    }

    public TrieNode(char c) {
        this.val = c;
    }
}

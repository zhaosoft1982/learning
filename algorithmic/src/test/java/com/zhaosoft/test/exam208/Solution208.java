package com.zhaosoft.test.exam208;

import com.zhaosoft.example.exam208.Trie;
import org.junit.Test;


public class Solution208 {

    @Test
    public void test() {
        Trie trie = new Trie();

        trie.insert("apple");
        trie.search("apple");   // 返回 true
        trie.search("app");     // 返回 false
        trie.startsWith("app"); // 返回 true
        trie.insert("app");
        trie.search("app");     // 返回 true

    }
}

package com.zhaosoft.example.exam242;

import java.util.HashMap;

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.isEmpty() && t.isEmpty()) {
            return true;
        }

        HashMap<String, Integer> h1 = new HashMap<String, Integer>(s.length());
        HashMap<String, Integer> h2 = new HashMap<String, Integer>(t.length());
        for (int i = 0; i < s.length(); i++) {
            String item = s.substring(i, i + 1);
            if (h1.containsKey(item)) {
                h1.put(item, h1.get(item) + 1);
            } else {
                h1.put(item, 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            String item = t.substring(i, i + 1);
            if (h2.containsKey(item)) {
                h2.put(item, h2.get(item) + 1);
            } else {
                h2.put(item, 1);
            }
        }
        return h1.equals(h2);

    }

    public static void main(String [] args){
        System.out.println(new Solution().isAnagram("anagram","nagaram"));
    }
}

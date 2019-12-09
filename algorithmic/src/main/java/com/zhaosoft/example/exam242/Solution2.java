package com.zhaosoft.example.exam242;

import java.util.HashMap;

public class Solution2 {
    public boolean isAnagram(String s, String t) {
        if (s.isEmpty() && t.isEmpty()) {
            return true;
        }

        if(s.length()!=t.length()){
            return false;
        }

        HashMap<Character, Integer> h1 = new HashMap<Character, Integer>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            if (h1.containsKey(item)) {
                h1.put(item, h1.get(item) + 1);
            } else {
                h1.put(item, 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char item = t.charAt(i);
            Integer num=h1.get(item);
            if(num!=null){
                num--;
                if(num>0){
                    h1.put(item, num);
                }else{
                    h1.remove(item);
                }
            }else{
                return false;
            }

        }
        if(h1.size() != 0){
            return false;
        }
        else{
            return true;
        }

    }

    public static void main(String [] args){
        System.out.println(new Solution2().isAnagram("anagram","nagaram"));
    }
}

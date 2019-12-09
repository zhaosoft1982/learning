package com.zhaosoft.example.exam242;

public class Solution5 {
    public boolean isAnagram(String s, String t) {

        if (s == null || t == null)
            return  false;
        if (s.length() != t.length())
            return  false;

        int[] sIntArray = new int[26];

        for(int i=0;i<s.length();i++){
            sIntArray[s.charAt(i) - 'a']++;
            sIntArray[t.charAt(i) - 'a']--;

        }

        for (int count: sIntArray) {
            if (count != 0)
                return false;
        }
        return true;


    }
}

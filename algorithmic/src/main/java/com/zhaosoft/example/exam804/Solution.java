package com.zhaosoft.example.exam804;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author xiaoleizhao
 * @date 2018/12/13 18:27
 */
public class Solution {

    public int uniqueMorseRepresentations(String[] words) {
        String[] map = {
                ".-",
                "-...",
                "-.-.",
                "-..",
                ".",
                "..-.",
                "--.",
                "....",
                "..",
                ".---",
                "-.-",
                ".-..",
                "--",
                "-.",
                "---",
                ".--.",
                "--.-",
                ".-.",
                "...",
                "-",
                "..-",
                "...-",
                ".--",
                "-..-",
                "-.--",
                "--.."
        };
        if (words.length == 0) {
            return 0;
        }
        Set<String> set = new HashSet<String>();
        for (String word : words) {
            char[] temp = word.toCharArray();
            StringBuffer sb = new StringBuffer();
            for (char c : temp) {
                sb.append(map[c - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}

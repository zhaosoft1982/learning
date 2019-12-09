package com.zhaosoft.example.exam692;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 *Time Complexity:O(Nlog{N}), where N is the length of words.
 * We count the frequency of each word in O(N) time, then we sort the given words in O(NlogN) time.
 * Space Complexity: O(N), the space used to store our candidates.
 */
public class Solution {
    public List<String> topKFrequent(String[] words,int k){
        HashMap<String,Integer> count=new HashMap<String,Integer>();
        for (String word:words){
            count.put(word,count.getOrDefault(word,0)+1);
        }
        List<String> candidates = new ArrayList(count.keySet());
        Collections.sort(candidates, (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                w1.compareTo(w2) : count.get(w2) - count.get(w1));

        return candidates.subList(0, k);
    }
}

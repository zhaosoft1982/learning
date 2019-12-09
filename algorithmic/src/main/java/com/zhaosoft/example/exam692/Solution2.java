package com.zhaosoft.example.exam692;

import java.util.*;

public class Solution2 {
    public List<String> topKFrequent(String[] words,int k){
        Map<String,Integer> count=new HashMap<>();
        for(String word:words){
            count.put(word,count.getOrDefault(word,0)+1);
        }
        PriorityQueue<String> heap=new PriorityQueue<String>(
                (word1,word2)->count.get(word1).equals(count.get(word2))? word2.compareTo(word1):count.get(word1)-count.get(word2));
        for(String word:count.keySet()){
            heap.offer(word);
            if(heap.size()>k){
                heap.poll();
            }
        }

        List<String> ans=new ArrayList();
        while (!heap.isEmpty())ans.add(heap.poll());
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String args []){
        String [] words2 =new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        String [] words=new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(new Solution2().topKFrequent(words,2));

        System.out.println(new Solution2().topKFrequent(words2,4));
    }
}

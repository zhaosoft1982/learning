package com.zhaosoft.example.exam692;

import java.util.*;

public class Solution3 {
        public List<String> topKFrequent(String[] words, int k) {
            List<String> result=new ArrayList<String>();
            Map<String,Integer> hashMap=new HashMap<>();
            for(int i=0;i<words.length;i++){
                hashMap.put(words[i],hashMap.getOrDefault(words[i],0)+1);
            }
            List<Map.Entry<String,Integer>> list=new ArrayList<>(hashMap.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    if(o1.getValue()>o2.getValue()){
                        return -1;
                    }else if(o1.getValue()<o2.getValue()){
                        return 1;
                    }else{
                        return o1.getKey().compareTo(o2.getKey());
                    }
                }
            });
            for(int i=0;i<k;i++){
                result.add(list.get(i).getKey());
            }
            return result;
        }
    }
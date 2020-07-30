package com.zhaosoft.example.exam1_50.exam15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums==null){
            return null;
        }
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    if((nums[i]+nums[j]+nums[k])==0){
                        List<Integer> temp=new ArrayList<>(3);
                        temp.add(i);
                        temp.add(j);
                        temp.add(k);
                        Collections.sort(temp);
                        if(!result.contains(temp)){
                            result.add(temp);
                        }
                    }
                }
            }

        }
        return result;
    }


}

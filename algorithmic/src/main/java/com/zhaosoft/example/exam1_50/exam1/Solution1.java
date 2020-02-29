package com.zhaosoft.example.exam1_50.exam1;

import java.util.Arrays;
import java.util.HashMap;

public class Solution1 {
    public int [] twoSum(int [] sums, int target){
        HashMap<Integer,Integer> tempHashMap=new HashMap<>(sums.length);

        for(int i=0;i<sums.length;i++){
            Integer temValue=target -sums[i];
            if(tempHashMap.containsKey(temValue)){
                return new int[]{i,tempHashMap.get(temValue).intValue()};
            }else{
                tempHashMap.put(sums[i],i);
            }
        }

        return null;
    }


    public static void main(String [] args){
        Solution1 solution=new Solution1();
        int[] nums=new int[]{9,11,2,7,11,6,4,1,10,15};
        int[] result=solution.twoSum(nums,9);
        System.out.print(Arrays.toString(result));
    }
}

package com.zhaosoft.example.exam20;

import java.util.HashMap;
import java.util.Stack;

/**
 *
 * @author xiaoleizhao
 * @date 2018/11/4 15:15
 * @param
 * @return
 */
public class Solution {

    /**
     * Hash table that takes care of the mappings.
     */
    private HashMap<Character, Character> mappings;

    /**
     * Initialize hash map with mappings. This simply makes the code easier to read.
     */
    public Solution() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<s.length();i++){
          char temp=s.charAt(i);
          if(mappings.containsKey(temp)){
              char topElement = stack.empty() ? '#' : stack.pop();
              if(!mappings.get(temp).equals(topElement)){
                  return false;
              }

          }else{
              stack.push(temp);
          }
        }
        return stack.isEmpty();
    }

    public static void main(String [] args){
        String temp="()";
        System.out.print(new Solution().isValid(temp));
    }
}

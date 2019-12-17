package com.zhaosoft.redis;

/**
 * @author xiaoleizhao
 * @create 2019-12-16 11:20
 **/
public class SimpleHash {
    private int size = 1<<24;
    private int seed = 0;
    public SimpleHash(int seed){
        this.seed=seed;
    }

    public SimpleHash(int size,int seed){
        this.seed=seed;
        this.size=size;
    }
    public int hash(String string){
        int val=0;
        int len=string.length();
        for (int i = 0; i < len; i++) {
            val=val*seed+string.charAt(i);
        }
        return val&(size-1);
    }
}


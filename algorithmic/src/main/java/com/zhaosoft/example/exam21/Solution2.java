package com.zhaosoft.example.exam21;

import com.zhaosoft.example.ListNode;

/**
 * 递归形式执行
 */
public class Solution2 {

    /**
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;

        ListNode result;

        if(l1.val>=l2.val){
            result=l2;
            result.next=mergeTwoLists(l1,l2.next);
        }else{
            result=l1;
            result.next=mergeTwoLists(l1.next,l2);
        }

        return result;
    }
}

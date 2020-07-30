package com.zhaosoft.example.exam1_50.exam21;

import com.zhaosoft.example.ListNode;

/**
 * 两个有序链表合并
 * @author zhaoxl
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result=new ListNode(0);
        ListNode p3=result;
        while (l1!=null && l2!=null){
            if(l1.val<l2.val){
                p3.next=l1;
                l1=l1.next;
                p3=p3.next;
            }else {
                p3.next=l2;
                l2=l2.next;
                p3=p3.next;
            }
        }
        if(l1==null){
            p3.next=l2;
        }
        if(l2==null){
            p3.next=l1;
        }
        return result.next;
    }

    public static void main(String [] args){
        ListNode head=new ListNode(1);
        ListNode three=new ListNode(3);
        ListNode five=new ListNode(5);
        three.next=five;
        head.next=three;

        ListNode two=new ListNode(2);
        ListNode four=new ListNode(4);
        ListNode six=new ListNode(6);
        four.next=six;
        two.next=four;

        new com.zhaosoft.example.exam1_50.exam21.Solution().mergeTwoLists(head,two);
    }
}

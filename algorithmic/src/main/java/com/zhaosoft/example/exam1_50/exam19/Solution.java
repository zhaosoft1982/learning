package com.zhaosoft.example.exam1_50.exam19;

import com.zhaosoft.example.ListNode;

/**
 * 删除链表倒数第n个节点
 * @author zhaoxl
 */
public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode result=new ListNode(0);
        result.next=head;
        int length=0;
        ListNode first = head;
        while (first!=null){
            first=first.next;
            length++;
        }
        length =length-n;

        first=result;

        while (length>0){
            length--;
            first=first.next;
        }
        first.next = first.next.next;
        return result.next;
    }


    public static void main(String [] args){
        ListNode head=new ListNode(1);
        ListNode two=new ListNode(2);
//        ListNode three=new ListNode(3);
//        ListNode four=new ListNode(4);
//        ListNode five=new ListNode(5);
//        ListNode six=new ListNode(6);
//        five.next=six;
//        four.next=five;
//        three.next=four;
        two.next=null;
        head.next=two;
        new com.zhaosoft.example.exam1_50.exam19.Solution().removeNthFromEnd(head,1);
    }
}

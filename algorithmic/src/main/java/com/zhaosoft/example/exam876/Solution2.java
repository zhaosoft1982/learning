package com.zhaosoft.example.exam876;

import com.zhaosoft.example.ListNode;

public class Solution2 {
    public ListNode middleNode(ListNode head) {
        ListNode[] A = new ListNode[100];
        int t = 0;
        while (head!= null) {
            A[t++] = head;
            head = head.next;
        }
        return A[t / 2];
    }

    public static void main(String [] args){
        ListNode head=new ListNode(1);
        ListNode two=new ListNode(2);
        ListNode three=new ListNode(3);
        ListNode four=new ListNode(4);
        ListNode five=new ListNode(5);
        ListNode six=new ListNode(6);
        five.next=six;
        four.next=five;
        three.next=four;
        two.next=three;
        head.next=two;
        new Solution2().middleNode(head);
    }
}

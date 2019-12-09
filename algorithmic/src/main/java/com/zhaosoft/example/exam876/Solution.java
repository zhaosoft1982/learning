package com.zhaosoft.example.exam876;
import com.zhaosoft.example.ListNode;

/**
 * 链表的中间结点
 * 定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 */
public class Solution {
    public ListNode middleNode(ListNode head) {
        if(head==null) {return null;}
        if(head.next==null){ return head;}
        int i=1;
        ListNode p=new ListNode(head.val);
        p.next=head.next;
        while(p.next!=null){
            p.next=p.next.next;
            i++;
        }
        int k=i/2;
        while(k>0){
            head=head.next;
            k--;
        }
        return head;
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
        new Solution().middleNode(head);
    }
}

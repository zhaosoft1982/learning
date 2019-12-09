package com.zhaosoft.example.exam206;

import com.zhaosoft.example.ListNode;

import java.util.Stack;

public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null ||head.next==null) return null;
        Stack<ListNode> stack =new Stack<ListNode>();
        while (head!=null){
            stack.push(head);
            head=head.next;
        }
        ListNode result=new ListNode(0);
        ListNode p=result;
        while (!stack.isEmpty()){
           ListNode newListNode= stack.pop();
           newListNode.next=null;
           p.next=newListNode;
           p=p.next;
        }
        return result.next;
    }


    public static void main(String [] args){
        ListNode head=new ListNode(1);
        ListNode three=new ListNode(3);
        ListNode five=new ListNode(5);
        three.next=five;
        head.next=three;

        new com.zhaosoft.example.exam206.Solution().reverseList(head);
    }
}

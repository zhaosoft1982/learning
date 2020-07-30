package com.zhaosoft.example.exam1_50.exam5;

import com.zhaosoft.example.ListNode;

/**
 * 链表交换相邻元素
 * @author xiaoleizhao
 * @date 2018/11/3 19:43
 * @param
 * @return
 */
public class Sloution {
    public ListNode swapPairs(ListNode head) {
        ListNode pre=new ListNode(0);
        pre.next=head;
        head=pre;
        while (head.next!=null && head.next.next!=null){
            ListNode a=head.next;
            ListNode b=head.next.next;
            head.next=b;
            a.next=b.next;
            b.next=a;
            head=a;
        }
        return pre.next;
    }

}

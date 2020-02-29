package com.zhaosoft.example.exam1_50.exam4;

import com.zhaosoft.example.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断链表是否有环
 */
public class Sloution {
    /**
     * 复杂度分析
     * 时间复杂度：O(n)O(n)， 让我们将 nn 设为链表中结点的总数。为了分析时间复杂度，我们分别考虑下面两种情况。
     * 链表中不存在环：
     * 快指针将会首先到达尾部，其时间取决于列表的长度，也就是 O(n)O(n)。
     * 链表中存在环：
     * 我们将慢指针的移动过程划分为两个阶段：非环部分与环形部分：
     * 慢指针在走完非环部分阶段后将进入环形部分：此时，快指针已经进入环中 \text{迭代次数} = \text{非环部分长度} = N迭代次数=非环部分长度=N
     * 两个指针都在环形区域中：考虑两个在环形赛道上的运动员 - 快跑者每次移动两步而慢跑者每次只移动一步。其速度的差值为1，因此需要经过 \dfrac{\text{二者之间距
     * }}{\text{速度差值}}
     * 速度差值二者之间距离次循环后，快跑者可以追上慢跑者。这个距离几乎就是 "\text{环形部分长度 K}环形部分长度 K" 且速度差值为 1，
     * 我们得出这样的结论 \text{迭代次数} =\text{近}迭代次数=近似于 "\text{环形部分长度 K}环形部分长度 K".
     * 因此，在最糟糕的情形下，时间复杂度为 O(N+K)，也就是 O(n)。
     * 空间复杂度：O(1)， 我们只使用了慢指针和快指针两个结点，所以空间复杂度为 O(1)。
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null){
            return false;
        }
        ListNode oneNode=head;
        ListNode twoNode=head.next;
        while(oneNode!=twoNode){
            if(twoNode==null || twoNode==null){
                return false;
            }
            oneNode=oneNode.next;
            if(twoNode.next==null){
                return false;
            }
            twoNode=twoNode.next.next;
        }
        return true;
    }

    /**
     * 我们遍历所有结点并在哈希表中存储每个结点的引用（或内存地址）。如果当前结点为空结点 null（即已检测到链表尾部的下一个结点），
     * 那么我们已经遍历完整个链表，并且该链表不是环形链表。如果当前结点的引用已经存在于哈希表中，那么返回 true（即该链表为环形链表）。
     *
     * 复杂度分析
     * 时间复杂度：O(n)， 对于含有 n个元素的链表，我们访问每个元素最多一次。添加一个结点到哈希表中只需要花费 O(1) 的时间。
     * 空间复杂度：O(n)， 空间取决于添加到哈希表中的元素数目，最多可以添加 n个元素。
     * @author xiaoleizhao
     * @date 2018/11/3 19:34
     * @param head
     * @return boolean
     */
    public boolean hasCycle2(ListNode head){
        Set<ListNode> listNodes=new HashSet<>();
        while (head!=null){
            if(listNodes.contains(head)){
                return true;
            }
            listNodes.add(head);
            head=head.next;
        }

        return false;

    }
    public static void main(String [] args){
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        l1.next =l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l1;
        System.out.print(new Sloution().hasCycle2(l1));

    }
}

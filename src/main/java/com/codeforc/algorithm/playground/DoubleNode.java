package com.codeforc.algorithm.playground;

import com.codeforc.algorithm.datastruct.ListNode;

//给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
//返回删除后的链表的头节点。
//注意：此题对比原题有改动
public class DoubleNode {

    /**
     * 定义curNode对象，指向头节点，定义前一个节点对象指向头节点
     */
    public static ListNode deleteNode(ListNode head, int val) {
        if(head == null) return null;
        if(head.val == val) return head.next;
        ListNode curNode = head;
        ListNode preNode = head;
        while(curNode != null) {
            if(val == curNode.val) {
                preNode.next = curNode.next;
            }
            preNode = curNode;
            curNode = curNode.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.val = 4;
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);
        ListNode listNode = deleteNode(head, 4);
        System.out.println(listNode);
    }
}

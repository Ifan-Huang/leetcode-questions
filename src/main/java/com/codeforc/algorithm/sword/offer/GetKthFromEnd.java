package com.codeforc.algorithm.sword.offer;

import com.codeforc.algorithm.datastruct.ListNode;

import java.util.Stack;

//输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
//例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
public class GetKthFromEnd {

    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head == null) return null;
        Stack<ListNode> stack = new Stack<>();
        while(head != null) {
            stack.add(head);
            head = head.next;
        }
        for(int i = 0; i <= k; i++) {
            stack.pop();
        }
        return stack.pop();
    }

    public static void main(String[] args) {

    }
}
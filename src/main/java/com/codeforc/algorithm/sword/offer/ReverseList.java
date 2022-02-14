package com.codeforc.algorithm.sword.offer;

import com.codeforc.algorithm.datastruct.ListNode;

import java.util.Stack;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 */
public class ReverseList {

    public ListNode reverList(ListNode head) {
        if(head == null) return head;
        if(head.next == null) return head;
        Stack<Integer> stack = new Stack<>();
        while(null != head) {
            stack.add(head.val);
            head = head.next;
        }
        ListNode newHead = new ListNode();
        ListNode result = newHead;
        int size = stack.size();
        for(int i = 0; i < size; i++) {
            newHead.val = stack.pop();
            if(i != size - 1) {
                newHead.next = new ListNode();
                newHead = newHead.next;
            }
        }
        return result;
    }

    //输入: 1->2->3->4->5->NULL
    //输出: 5->4->3->2->1->NULL
    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode result = reverseList.reverList(head);
        System.out.println(result);
    }
}

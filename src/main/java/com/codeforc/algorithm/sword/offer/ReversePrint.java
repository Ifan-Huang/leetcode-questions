package com.codeforc.algorithm.sword.offer;

import com.codeforc.algorithm.datastruct.ListNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */
public class ReversePrint {

    /**
     * 用栈结构存储数据，然后pop出来
     */
    public int[] reversePrint(ListNode head) {
        if(head == null) return new int[]{};
        if(head.next == null) return new int[]{head.val};
        ListNode node = head;
        Stack<Integer> stack = new Stack<>();
        while (null != node) {
            stack.add(node.val);
            node = node.next;
        }
        int[] result = new int[stack.size()];
        int length = stack.size();
        for(int i = 0; i < length; i++) {
            result[i] = stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        ReversePrint reversePrint = new ReversePrint();
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        int[] ints = reversePrint.reversePrint(head);
        for(int i = 0 ; i < ints.length; i++)
            System.out.println(ints[i]);
    }
}
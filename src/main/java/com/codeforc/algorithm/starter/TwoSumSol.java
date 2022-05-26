package com.codeforc.algorithm.starter;

import com.codeforc.algorithm.datastruct.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 */
public class TwoSumSol {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> deque1 = new ArrayDeque<>();
        Deque<Integer> deque2 = new ArrayDeque<>();
        while(null != l1) {
            deque1.add(l1.val);
            l1 = l1.next;
        }

        while(null != l2) {
            deque2.add(l2.val);
            l2 = l2.next;
        }
        return new ListNode();
    }

    public static void main(String[] args) {
        TwoSumSol twoSumSol = new TwoSumSol();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode listNode = twoSumSol.addTwoNumbers(l1, l2);
        while(null != listNode) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

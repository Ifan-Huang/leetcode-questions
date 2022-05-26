package com.codeforc.algorithm.list;

import com.codeforc.algorithm.datastruct.ListNode;

/**
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class AddTwoNumbers {

    public ListNode solution(ListNode n1, ListNode n2) {
        Integer sum = getSumOfReveseNode(n1) + getSumOfReveseNode(n2);
        String s = String.valueOf(sum);
        char[] chars = s.toCharArray();
        ListNode root = new ListNode();
        ListNode node = root;
        for (int i =chars.length - 1; i >= 0; i--) {
            node.val = Character.getNumericValue(chars[i]);
            if(i != 0)
                node.next = new ListNode();
            node = node.next;
        }
        return root;
    }

    public int getSumOfReveseNode(ListNode node) {
        StringBuilder indexOfNumberString = new StringBuilder();
        while(null != node) {
            indexOfNumberString.append(node.val);
            node = node.next;
        }
        String originString = indexOfNumberString.toString();
        if("".equals(originString)) return 0;
        char[] chars = originString.toCharArray();
        StringBuilder resultStrBuilder = new StringBuilder();
        for(int i = chars.length - 1; i >= 0; i--) {
            resultStrBuilder.append(chars[i]);
        }
        return Integer.parseInt(resultStrBuilder.toString());
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        listNode.val = 2;
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(3);

        ListNode listNode2 = new ListNode();
        listNode2.val = 5;
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(4);
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode solution = addTwoNumbers.solution(listNode, listNode2);
        System.out.println(solution);

    }
}

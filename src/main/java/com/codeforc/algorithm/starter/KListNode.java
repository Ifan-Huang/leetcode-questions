package com.codeforc.algorithm.starter;

import com.codeforc.algorithm.datastruct.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class KListNode {

    public ListNode mergeKLists(ListNode[] lists) {
        if(null == lists || lists.length == 0) return null;
        if(lists.length == 1) {
            if(lists[0] == null) return null;
        }
        List<Integer> l = new ArrayList<>();
        for (ListNode list : lists) {
            while(list != null) {
                l.add(list.val);
                list = list.next;
            }
        }
        Collections.sort(l);
        ListNode curNode = new ListNode();
        ListNode root = curNode;
        for(int i = 0; i < l.size(); i++) {
            curNode.val = l.get(i);
            if(i == (l.size() - 1)) {
                break;
            }
            curNode.next = new ListNode();
            curNode = curNode.next;
        }
        return root;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode();
        ListNode[] fo = {l1,l2};
        KListNode kListNode = new KListNode();
        ListNode listNode = kListNode.mergeKLists(fo);
        System.out.println(listNode);
    }
}

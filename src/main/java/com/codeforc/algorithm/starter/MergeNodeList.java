package com.codeforc.algorithm.starter;

import com.codeforc.algorithm.datastruct.ListNode;

import java.util.List;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 */
public class MergeNodeList {

    /**
     * 定义返回链表
     * 定义root定位
     * 进行循环
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 != null) return list2;
        if(list2 == null && list1 != null) return list1;
        if(list1 == null) return null;

        ListNode resultNode = new ListNode();
        ListNode resultRoot = resultNode;
        while(null != list1 || null != list2) {
            if(list1 == null) {
                resultNode.val = list2.val;
                list2 = list2.next;
                if(list2 != null) {
                    resultNode.next = new ListNode();
                    resultNode = resultNode.next;
                }
                continue;
            }
            if(list2 == null) {
                resultNode.val = list1.val;
                list1 = list1.next;
                if(list1 != null) {
                    resultNode.next = new ListNode();
                    resultNode = resultNode.next;
                }
                continue;
            }
            int val1 = list1.val;
            int val2 = list2.val;
            if(val1 == val2) {
                resultNode.val = val1;
                resultNode.next = new ListNode();
                resultNode = resultNode.next;
                list1 = list1.next;
                continue;
            }
            resultNode.val = Math.min(val1, val2);
            resultNode.next = new ListNode();
            resultNode = resultNode.next;
            if(val1 < val2) {
                list1 = list1.next;
            } else {
                list2 = list2.next;
            }
        }
        return resultRoot;
    }

    public static void main(String[] args) {
        MergeNodeList mergeNodeList = new MergeNodeList();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode listNode = mergeNodeList.mergeTwoLists(l1, l2);
        System.out.println(listNode);
    }
}

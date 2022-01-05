package com.codeforc.algorithm.datastruct;

/**
 * @author: Ifan·Huang
 **/
public class ListNode {

    public int val;

    public ListNode next;

    ListNode() {}

    ListNode(int val) {this.val = val;}

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}

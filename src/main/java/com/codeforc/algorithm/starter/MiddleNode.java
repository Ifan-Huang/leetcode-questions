package com.codeforc.algorithm.starter;

/**
 * 给定一个头结点为 head的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 * 示例 1：
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 * 示例2：
 *
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/middle-of-the-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: Ifan·Huang
 **/
public class MiddleNode {

    public ListNode middleNode(ListNode head) {
        int i = 1;
        int j = 0;
        ListNode tempNode = head;
        while(tempNode.next != null) {
            tempNode = tempNode.next;
            i++;
            if(i % 2 == 0) j++;
        }
        ListNode resultNode = head;
        while(j != 0) {
            resultNode = resultNode.next;
            j--;
        }
        return resultNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        ListNode node = head.next;
        node.next = new ListNode(3);
        ListNode nodex = node.next;
        nodex.next = new ListNode(4);
        ListNode nodec = nodex.next;
        nodec.next = new ListNode(5);
        ListNode listNode = new MiddleNode().middleNode(head);
        System.out.println(listNode.val);
    }

    static class ListNode {
        int val;

        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

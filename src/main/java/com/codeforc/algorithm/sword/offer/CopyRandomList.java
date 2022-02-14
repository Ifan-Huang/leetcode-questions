package com.codeforc.algorithm.sword.offer;

import com.codeforc.algorithm.datastruct.Node;

import java.util.HashMap;

/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。
 * 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 */
public class CopyRandomList {

    /**
     * 复制原head,
     */
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node curNode = head;
        while(null != curNode) {
            map.put(curNode, new Node(curNode.val));
            curNode = curNode.next;
        }
        curNode = head;
        while(null != curNode) {
            map.get(curNode).next = map.get(curNode.next);
            map.get(curNode).random = map.get(curNode.random);
            curNode = curNode.next;
        }
        return map.get(head);
    }
}
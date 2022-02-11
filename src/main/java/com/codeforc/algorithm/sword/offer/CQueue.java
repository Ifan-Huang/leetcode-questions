package com.codeforc.algorithm.sword.offer;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 剑指 Offer (一)
 * 用两个栈实现一个队列。队列的声明如下，
 * 请实现它的两个函数 appendTail 和 deleteHead.
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回 -1 )
 * 示例 1：
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 */
public class CQueue {

    private LinkedList<Integer> stack1;
    private LinkedList<Integer> stack2;

    public CQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void appendTail(int num) {
        stack1.add(num);
    }

    /**
     * delete head
     * step 1: check stack1 is empty , then pop or move to stack2 foreach and pop stack2
     * step 2: move stack2 to stack1
     * @return
     */
    public int deleteHead() {
        if (stack1.isEmpty()) return -1;
        if (stack1.size() == 1) return stack1.pop();
        while (!stack1.isEmpty())
            stack2.add(stack1.pop());
        Integer resultInt = stack2.pop();
        while(!stack2.isEmpty()) stack1.add(stack2.pop());
        return resultInt;
    }

    public static void main(String[] args) {
        CQueue obj = new CQueue();

        obj.appendTail(3);
        System.out.println(obj);
        obj.appendTail(2);
        obj.appendTail(5);
        obj.appendTail(4);
        obj.appendTail(1);
        int i = obj.deleteHead();
        obj.appendTail(5);
        obj.appendTail(8);
        int i1 = obj.deleteHead();
        int i2 = obj.deleteHead();
        System.out.println(obj);
    }
}

package com.codeforc.algorithm.sword.offer;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 定义栈的数据结构，
 * 请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 */
public class MinStack {

    private Stack<Integer> dataStack;

    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        this.dataStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    /**
     * 添加数据
     */
    public void push(int x) {
        dataStack.add(x);
        if(minStack.isEmpty() || minStack.peek() > x) minStack.add(x);
    }

    /**
     * 弹栈
     */
    public void pop() {
        if(dataStack.isEmpty()) return;
        Integer pop = dataStack.pop();
        if(pop.equals(minStack.peek())) minStack.pop();
    }

    /**
     * 获取头部数据
     */
    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    /**
     *
     ["MinStack","push","push","push","min","pop","top","min"]
     [[],[-2],[0],[-3],[],[],[],[]]
     */
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int min1 = minStack.min();
        System.out.println(min1);
        minStack.pop();
        int top = minStack.top();
        System.out.println("top : " + top);
        int min2 = minStack.min();
        System.out.println(min2);
    }
}

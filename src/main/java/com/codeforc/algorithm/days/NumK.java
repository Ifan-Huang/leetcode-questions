package com.codeforc.algorithm.days;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。
 * 注意，不是必须有这些素因子，而是必须不包含其他的素因子。
 * 例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
 * 示例 1:
 * 输入: k = 5
 * 输出: 9
 *
 * https://leetcode.cn/contest/season/2022-fall/problems/6CE719/
 */
public class NumK {

    /**
     * 有了基本的分析思路，一个简单的解法是使用优先队列：
     * 起始先将最小数值 11 放入队列
     * 每次从队列取出最小值 xx，然后将 xx 所对应的数值 3x3x、5x5x 和 7x7x 进行入队
     * 对步骤 2 循环多次，第 kk 次出队的值即是答案
     * 为了防止同一数值多次进队，我们需要使用数据结构 SetSet 来记录入过队列的数值。
     */
    public int getKthMagicNumber(int k) {
        int[] nums = new int[]{3, 5, 7};
        Queue<Long> q = new ArrayDeque<>();
        Set<Long> set = new HashSet<>();
        q.add(1L); set.add(1L);
        while (!q.isEmpty()) {
            long t = q.poll();
            System.out.println("q: poll:=>" + t);
            if (--k == 0) return (int) t;
            for (int x : nums) {
                if (!set.contains(x * t)) {
                    q.add(x * t); set.add(x * t);
                }
            }
            System.out.println("finish queue:" + q);
        }
        return -1;
    }

    public static void main(String[] args) {
        int k = 15;
        NumK numK = new NumK();
        int kthMagicNumber = numK.getKthMagicNumber(k);
        System.out.println(
                kthMagicNumber
        );
    }
}

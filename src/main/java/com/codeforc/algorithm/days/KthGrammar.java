package com.codeforc.algorithm.days;

import java.util.HashMap;

/**
 * 我们构建了一个包含 n 行(索引从 1 开始)的表。首先在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
 * 例如，对于 n = 3 ，第 1 行是 0 ，第 2 行是 01 ，第3行是 0110 。
 * 给定行数n和序数 k，返回第 n 行中第 k个字符。（k从索引 1 开始）
 *
 * 示例 1:
 * 输入: n = 1, k = 1
 * 输出: 0
 * 解释: 第一行：0
 * 示例 2:
 * 输入: n = 2, k = 1
 * 输出: 0
 * 解释:
 * 第一行: 0
 * 第二行: 01
 * 示例 3:
 * 输入: n = 2, k = 2
 * 输出: 1
 * 解释:
 * 第一行: 0
 * 第二行: 01
 */
public class KthGrammar {

    public int kthGrammar(int n, int k) {
        int x = Integer.bitCount(k-1) & 1;
        return x;
    }

    public static void main(String[] args) {
        KthGrammar kthGrammar = new KthGrammar();
        int i = kthGrammar.kthGrammar(8, 20);
        System.out.println(i);
    }
}

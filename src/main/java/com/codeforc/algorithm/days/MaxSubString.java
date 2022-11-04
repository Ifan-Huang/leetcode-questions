package com.codeforc.algorithm.days;

/**
 * 给你一个字符串sequence，如果字符串 word连续重复k次形成的字符串是sequence的一个子字符串，那么单词word 的 重复值为 k 。单词 word的 最大重复值是单词word在sequence中最大的重复值。
 * 如果word不是sequence的子串，那么重复值k为 0 。
 * 给你一个字符串 sequence和 word，请你返回 最大重复值k 。
 * 示例 1：
 * 输入：sequence = "ababc", word = "ab"
 * 输出：2
 * 解释："abab" 是 "ababc" 的子字符串。
 * 示例 2：
 * 输入：sequence = "ababc", word = "ba"
 * 输出：1
 * 解释："ba" 是 "ababc" 的子字符串，但 "baba" 不是 "ababc" 的子字符串。
 * 示例 3：
 * 输入：sequence = "ababc", word = "ac"
 * 输出：0
 * 解释："ac" 不是 "ababc" 的子字符串。
 */
public class MaxSubString {

    public int maxRepeating(String sequence, String word) {
        int n = sequence.length(), m = word.length(), ans = 0;
        int[] f = new int[n + 10];
        for (int i = 1; i <= n; i++) {
            if (i - m < 0) continue;
            String sub = sequence.substring(i - m, i);
            if (sub.equals(word)) f[i] = f[i - m] + 1;
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        String se = "aaabaaaabaaabaaaabaaaabaaaabaaaaba";
        String word = "aaaba";
        int i = new MaxSubString().maxRepeating(se, word);
        System.out.println("maxK:: " + i);
    }
}

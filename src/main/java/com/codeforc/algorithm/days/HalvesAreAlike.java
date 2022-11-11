package com.codeforc.algorithm.days;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个偶数长度的字符串 s 。将其拆分成长度相同的两半，前一半为 a ，后一半为 b 。
 * 两个字符串 相似 的前提是它们都含有相同数目的元音（'a'，'e'，'i'，'o'，'u'，'A'，'E'，'I'，'O'，'U'）。注意，s 可能同时含有大写和小写字母。
 * 如果 a 和 b 相似，返回 true ；否则，返回 false 。
 * 示例 1：
 * 输入：s = "book"
 * 输出：true
 * 解释：a = "bo" 且 b = "ok" 。a 中有 1 个元音，b 也有 1 个元音。所以，a 和 b 相似。
 * 示例 2：
 * 输入：s = "textbook"
 * 输出：false
 * 解释：a = "text" 且 b = "book" 。a 中有 1 个元音，b 中有 2 个元音。因此，a 和 b 不相似。
 */
public class HalvesAreAlike {

    public boolean halvesAreAlike(String s) {
        Character[] sc = new Character[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        HashSet<Character> set = new HashSet<>(Arrays.asList(sc));
        String l = s.substring(0, s.length() / 2);
        String r = s.substring(s.length() / 2);
        int lx = 0;
        int rx = 0;
        for (Character c : l.toCharArray()) {
            if(set.contains(c)) lx++;
        }
        for (Character c : r.toCharArray()) {
            if(set.contains(c)) rx++;
        }
        return lx == rx;
    }
}

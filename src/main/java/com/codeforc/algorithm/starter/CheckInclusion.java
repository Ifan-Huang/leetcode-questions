package com.codeforc.algorithm.starter;


import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 * In other words, return true if one of s1's permutations is the substring of s2.
 *
 * Example 1:
 *
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 *
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: Ifan·Huang
 **/
public class CheckInclusion {

    /**
     * 给定一个字符Set，存入所有的S1包含的不可重复的字符(Set自动去重)
     * 对S2进行遍历,S2中包含了Set中的某一个字符的话，将Set对应的该字符去除，如果最终结果Set为空则true 否则false
     */
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char key = s1.charAt(i);
            need.put(key, need.getOrDefault(key, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        //在任意时刻，只有一侧在滑动
        while (right < s2.length()) {//右侧滑动
            char c = s2.charAt(right);
            right++;

            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c)))
                    valid++;
            }

            while (right - left >= s1.length()) {
                if (valid == need.size())
                    return true;
                char d = s2.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d)))
                        valid--;
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "bbbca";
        boolean b = new CheckInclusion().checkInclusion(s1, s2);
        System.out.println(b);
    }

}
package com.codeforc.algorithm.playground;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.TreeSet;

//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
public class Dp4 {

    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.equals("")) return 0;
        TreeSet<Character> set = new TreeSet<>();
        int res = 0;
        for(int l = 0, r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            while(set.contains(c)) {
                set.pollFirst();
                l++;
            }
            set.add(c);
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    public static void main(String[] args) {

        String s = "ynyo";
//        String s = "dvdf";
//        String s = "pwwkew";
//        String s = "pwwkew";""
        Dp4 dp4 = new Dp4();
        int i = dp4.lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}

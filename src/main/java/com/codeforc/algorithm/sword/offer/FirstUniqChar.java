package com.codeforc.algorithm.sword.offer;

import java.util.LinkedHashMap;

//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
public class FirstUniqChar {

    public char firstUniqChar(String s) {
        if(s.equals("")) return ' ';
        LinkedHashMap<Character, Boolean> map = new LinkedHashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char itemChar = s.charAt(i);
            Boolean aBoolean = map.get(itemChar);
            if(null == aBoolean) {
                map.put(itemChar, false);
            } else {
                map.put(itemChar, true);
            }
        }
        for(int i = 0; i < s.length(); i++) {
            Boolean aBoolean = map.get(s.charAt(i));
            if(!aBoolean) return s.charAt(i);
        }
        return ' ';
    }
}

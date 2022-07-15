package com.codeforc.algorithm.days;



/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if(null == strs || strs.length == 0) return "";
        String prefix = strs[0];
        if(strs.length == 1) return prefix;

        for (String str : strs) {
            prefix = getLongestPrefix(str, prefix);
        }

        return prefix;
    }

    private String getLongestPrefix(String str, String prefix) {
        if(str.equals(prefix)) return prefix;
        int leg = Math.min(str.length(), prefix.length());
        StringBuilder resultBuilder = new StringBuilder();
        for(int i = 0 ; i < leg; i++) {
            if(str.charAt(i) == prefix.charAt(i)) {
                resultBuilder.append(str.charAt(i));
            }
        }
        return resultBuilder.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"cir", "car"};
        String s = new LongestCommonPrefix().longestCommonPrefix(strs);
        System.out.println(s);
    }

}
